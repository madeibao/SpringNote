# 1.MyBatis介绍(雷神230集)

MyBatis-和数据库进行交互;持久化层框架

1) 从原始的JDBC----dbutils(QueryRunner)----JdbsTemplate---XXX;称为工具;

工具:一些功能的简单封装

框架:某个领域的整体解决方案; 缓存,考虑异常处理问题,考虑部分字段映射问题...

现状:不用原生JDBC

1. 麻烦;
2. sql语句是硬编码在程序中的;耦合()
3. Hibernate-数据库交互的框架(ORM框架) (使用各种框架)


ORM(Object Relation Mapping)对象关系映射

创建好javaBean;

```java
@Table("t_employee")

//session.get("1",Employee.class)
class Employee{
	private Integer empid;
    private String empName;
}
```

优点:   

1. 项目启动(数据库没有这张表.Hibernate帮你自动创建)
2. 如果有,且字段更新,Hibernate帮你自动添加字段
3. SQL不用写

缺点:	(黑箱半封闭)

1. 定制SQL;
2. HQL; SQL;
3. 全映射框架; 部分字段映射很难; 能做;

希望:	

1. 最好有一个框架能支持定制化SQL,
2. 而且功能强大;
3. SQL也不要硬编码在java文件中,导致维护困难

![image-20210507192608527](\MyBatis.assets\image-20210507192608527.png)

1. MyBatis将重要的步骤抽取出来可以人工定制,	其他步骤自动化;
2. 重要步骤都是写在配置文件中(好维护);
3. 完全解决数据库的优化问题;
4. MyBatis底层就是对原生JDBC的一个简单封装;
5. 既将java编码与sql抽取了出来,还不会失去自动化功能;半自动的持久化层框架
6. 一个轻量级框架 

![image-20210507193804874](\MyBatis.assets\image-20210507193804874.png)

MyBatis-jar包的扩展,需要的话可以自定义导包,但mybatis-3.4.1.jar都已经集成了

# 2.环境搭建(雷神231-234集)

## Mybatis_HelloWorld

1. 创建一个java工程
2. 创建测试库,测试表,以及封装数据的javaBean,和操作数据库的dao接口
   1. ​	创建表:Navicat创建
   2. ​	创建javaBean: Employee(封装表的数据)
   3. ​	创建一个Dao接口(EmployeeDao),用来操作数据库;
3. 用MyBatis操作数据库

## 导包

```markdown
//mysql-connector-java-5.1.47.jar
//mybatis-3.4.1.jar
//建议导入日志包,这样在mybatis关键的环节就会有日志打印
//log4j-1.2.17.jar(日志框架)依赖类路径下一个log4j.xml配置文件;
```

## 写配置

(两个,全局配置文件(指导mybatis运行的),dao接口的实现文件(描述dao中每个方法怎么工作))

1.第一个配置文件:

(成为mybatis的全局配置文件,指导mybatis如何正确运行,比如连接哪个数据库)

2.第二个配置文件:(编写每一个方法都如何向数据库发送sql语句,如何执行...相当于接口的实现类)

- 将mapper的namespace属性改为接口的全类名
- 配置细节

```markdown
<!-- namespace:名称空间:写接口的全类名,相当于告诉MyBatis这个配置文件是实现哪个接口的 -->
<mapper namespace="com.Ray.dao.EmployeeDao">
	<!-- public Employee getEmpById(Integer id); -->
	<!-- select: 用来定义一个查询操作 id:方法名,相当于这个配置是对某个方法的实现
		 resultType:指定方法运行后的返回值类型(查询操作必须指定)
		 #{属性名}:代表取出传递过来的某个参数的值
	-->  
	<select id="getEmpById" resultType="com.Ray.bean.Employee">
    select * from t_employee where id = #{id}
  </select>
  </mapper>
```

我们写的dao接口的实现文件,mybatis默认是不知道的,需要在全局配置文件中注册

```xml
<!-- 引入我们自己编写的每一个接口的实现文件 -->
  <mappers>
  	<!-- resource:表示从类路径下找资源(此处的EmployeeDao.xml在conf源文件下也就是在类路径下) -->
    <mapper resource="EmployeeDao.xml"/>
  </mappers>
</configuration>
```

## 测试

​		根据全局配置文件先创建一个

```java
//1.根据全局配置文件创建出一个SqlSessionFactory
		//SqlSessionFactory:是SqlSession工厂,负责创建SqlSession对象;
		//SqlSession:sql会话(代表和数据库的一次会话)
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
```

​		sqlSessionFactory中获取sqlSession对象操作数据库即可

```java
//2.获取和数据库的一次回话
		SqlSession openSession = sqlSessionFactory.openSession();
		//3.使用sqlSession操作数据库,获取到dao接口的实现
		EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
		//4.调用之前的方法
		Employee employee = employeeDao.getEmpById(1);
		System.out.println(employee);
```

![image-20210507225000243](\MyBatis.assets\image-20210507225000243.png)

# 3.如何写xml有提示(项目测试开始)(雷神235集)

1.只要eclipse找到了文件的dtd(约束文件)的位置即可

联网情况下:

![image-20210508141402514](\MyBatis.assets\image-20210508141402514.png)

未联网情况:

![image-20210508140947091](\MyBatis.assets\image-20210508140947091.png)

拷贝无效-------从jar包中解压出来

绑定约束文件位置

​	1.复制dtd的引用网址:http://mybatis.org/dtd/mybatis-3-config.dtd

​	2.来到window-preference

![image-20210508141747000](\MyBatis.assets\image-20210508141747000.png)

![image-20210508142012123](\MyBatis.assets\image-20210508142012123.png)

![image-20210508142233044](\MyBatis.assets\image-20210508142233044.png)

![image-20210508142528816](\MyBatis.assets\image-20210508142528816.png)

alt+/不显示的话,关掉配置文件窗口,再重新打开

Tips: 尝试快捷键要在<configuration>或<mapper>标签内使用,不然不显示

应该写哪些配置???

```xml
<!-- public Employee getEmpById(Integer id);
	返回值类型resultType:为全类名; 
	参数类型parameterType:不用写;-->
 	<select id="getEmpById" resultType="com.Ray.bean.Employee">
 		<!-- SQL语句不要写分号 -->
 		select * from t_employee where id = #{id}
 	</select>
	<!-- public int updateEmployee(Employee employee);
		返回值类型:增删改不用写,增删改是返回影响多少行
		参数类型:Mybatis自动判断,如果是数字类型(int long,封装为数字)
		如果是boolean,影响0行(封装为false,否则就是true)
	 	#{属性名},从传入的参数对象中取出对应属性的值
	 -->
  	<update id="updateEmployee" >
  		UPDATE t_employee
  			SET empname=#{empName},gender=#{gender},email=#{email}
  			WHERE id=#{id}
  	</update>
```



## Mybatis_HelloWorld_Plus(236集)

![image-20210508224703258](\MyBatis.assets\image-20210508224703258.png)

![image-20210508225506591](\MyBatis.assets\image-20210508225506591.png)

![image-20210509145243002](\MyBatis.assets\image-20210509145243002.png)

![image-20210509145355355](\MyBatis.assets\image-20210509145355355.png)

看雷神视频,注意雷神用的是Junit4, 用Junit5需要对应调整

| **特性**                                                     | **Junit 4**  | **Junit 5** |
| :----------------------------------------------------------- | ------------ | ----------- |
| 在当前类的所有测试方法之前执行。注解在静态方法上。此方法可以包含一些初始化代码。 | @BeforeClass | @BeforeAll  |
| 在当前类中的所有测试方法之后执行。注解在静态方法上。此方法可以包含一些清理代码。 | @AfterClass  | @AfterAll   |
| 在每个测试方法之前执行。注解在非静态方法上。可以重新初始化测试方法所需要使用的类的某些属性。 | @Before      | @BeforeEach |
| 在每个测试方法之后执行。注解在非静态方法上。可以回滚测试方法引起的数据库修改。 | @After       | @AfterEach  |

> 测试文件:

```java
package com.Ray.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Ray.bean.Employee;
import com.Ray.dao.EmployeeDao;

public class MyBatisCRUDTest {
	SqlSessionFactory sqlsessionFactory;
	@BeforeEach
	public void initSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlsessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	
	
	@Test
	void test() throws IOException{
		//1. 根据全局配置文件显得到SqlSessionFactory
				Employee employee;
				//2.得到SqlSession对象;
				SqlSession openSession = sqlsessionFactory.openSession();
				try {
					//3.获取到dao接口的实现(映射器)
					EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
					employee = employeeDao.getEmpById(1);
				} finally{
					// TODO Auto-generated catch block
					openSession.close();
				}
				System.out.println(employee);
	}
	@Test
	void insertTest() {
		//1.获得与数据库的一次会话
		SqlSession openSession = sqlsessionFactory.openSession(true);//5.true为自动提交
		try {
			//2.获取到接口的映射器
			EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
			//3.测试
			int i = mapper.insertEmployee(new Employee(null, "Mike", "Mike@qq.com", 0));
			System.out.println(i);
		} finally{
			//4.手动提交
			//openSession.commit();
			openSession.close();
		}
	}
	@Test
	void deleteTest() {
		SqlSession openSession = sqlsessionFactory.openSession(true);
		try {
			EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
			boolean b = mapper.deleteEmployee(3);
			System.out.println(b);
		} finally{
			openSession.close();
		}
	}
	@Test
	void updateTest() {
		SqlSession openSession = sqlsessionFactory.openSession(true);
		try {
			EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
			int i = mapper.updateEmployee(new Employee(2, "Tom", "tom@qq.email", 1));
			System.out.println(i);
		} finally{
			openSession.close();
		}
	}
}
```

> EmployeeDao.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
 <mapper namespace="com.Ray.dao.EmployeeDao">
 	<!-- public Employee getEmpById(Integer id);返回值类型为全类名; 参数类型不用写;-->
 	<select  id="getEmpById" resultType="com.Ray.bean.Employee">
 		<!-- SQL语句不要写分号 -->
 		select * from t_employee where id = #{id}
 	</select>
	<!-- public int updateEmployee(Employee employee);
		增删改不用写返回值类型,增删改是返回影响多少行
		Mybatis自动判断,如果是数字类型(int long,自动封装为数字)
		如果是boolean,影响0行(封装为false,否则就是true)
	 	#{属性名},从传入的参数对象中取出对应属性的值
	 -->
	<update id="updateEmployee">
  		UPDATE t_employee
			SET empname=#{empName},gender=#{gender},email=#{email}
  			WHERE id=#{id}
  	</update>
  <!-- public int insertEmployee(Employee employee);-->
  <insert id="insertEmployee">
  		INSERT INTO t_employee(empName,gender,email)
  		VALUES(#{empName},#{gender},#{email})
  </insert>
  <!-- public boolean deleteEmployee(Integer id); -->
  <delete id="deleteEmployee">
  		DELETE FROM t_employee WHERE id=#{id}
  </delete>
 </mapper>
```

> mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <!-- 配置连接池 -->
      <dataSource type="POOLED">
        <property name="driver" value="com.mysql.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3306/mybatis_0325"/>
        <property name="username" value="root"/>
        <property name="password" value="root"/>
      </dataSource>
    </environment>
  </environments>
  <!-- mapper中注册我们所有写的dao接口的实现文件 -->
  <mappers>
  <!-- resource:表示从类路径下找资源(此处的EmployeeDao.xml在conf源文件下也就是在类路径下) -->
    <mapper resource="EmployeeDao.xml"/>
  </mappers>
</configuration>
```

### 总结:

1. 两个文件:
   1. 全局配置文件: mybatis-config.xml; 指导mybatis正确运行的一些全局设置
   2. SQL映射文件: EmployeeDao.xml; 相当于是对Dao接口的一个实现描述
2. 细节
   1. 获取到的是接口的代理对象; mybatis自动创建的;
   2. SqlSessionFactory和SqlSession;
      1. SqlSessionFactory创建SqlSession对象,Factory只new一次就行
      2. SqlSession: 相当于connection和数据库进行交互的,和数据库的一次回话就应该创建一个新的sqlSession;

## 全局配置文件(雷神237-244集)

### configuration 配置**(只有mapper和setting重要!!!!!)**

#### properties 属性(237集)

![image-20210509164545525](\MyBatis.assets\image-20210509164545525.png)

#### settings 设置(237集)

![image-20210509164402119](\MyBatis.assets\image-20210509164402119.png)

#### typeAliases 类型命名(238,239集)

![image-20210509165724652](\MyBatis.assets\image-20210509165724652.png)

![image-20210509170001457](\MyBatis.assets\image-20210509170001457.png)

![image-20210509170624432](\MyBatis.assets\image-20210509170624432.png)

![image-20210509171220861](\MyBatis.assets\image-20210509171220861.png)

推荐不起别名!!!使用全类名,可以Ctrl+左键,快速进行修改

#### typeHandlers 类型处理器(240,241集)

![image-20210509172744202](\MyBatis.assets\image-20210509172744202.png)

![image-20210509173523879](\MyBatis.assets\image-20210509173523879.png)

![image-20210509173451255](\MyBatis.assets\image-20210509173451255.png)



#### objectFactory 对象工厂

#### plugins 插件(241集(可以不看))

#### environments 环境(242集(可以不看))

![image-20210509180000052](\MyBatis.assets\image-20210509180000052.png)

#### environment 环境变量

##### transactionManager 事务管理器

##### dataSource 数据源

#### databaseIdProvider 数据库厂商标识(243集)

![image-20210509175749861](\MyBatis.assets\image-20210509175749861.png)

注意标签的顺序

![image-20210509180615482](\MyBatis.assets\image-20210509180615482.png)

#### mappers 映射器(244集)

![image-20210509182458175](\MyBatis.assets\image-20210509182458175.png)





```xml
<!-- 8.写好的sql映射文件需要使用mappers注册进来 -->
  <mappers>
  	<!-- url:可以从磁盘或者网络路径引用sql映射文件,一般不用-->
  	
  	<!-- resource:在类路径下的sql映射文件-->
  	<!-- <mapper resource="EmployeeDao.xml"/> 默认使用-->
  	
  	<!-- class:直接引用接口的全类名;需将xml放在和dao接口同目录下,而且文件名和接口名一致-->
  	<!-- <mapper class="com.Ray.dao.EmployeeDao" />-->
  	
  	<!-- class的另一种用法:配合注解使用(重要的dao还是写在配置文件里,简单的dao直接标注解)-->
  	<!-- <mapper class="com.Ray.dao.EmployeeDaoAnnotation"/> -->
  	<!-- 最终建议:<mapper resource="mybatisMapper/EmployeeDao.xml"/>建议把所有Mapper文件,统一放置-->
  	
      <!-- 批量注册 name=""; dao所在的包名-->
  	 <package name="com.Ray.dao"/>
      <!--需将xml放在和dao接口同目录下,而且文件名和接口名一致-->
  </mappers>
```

![image-20210509190359857](\MyBatis.assets\image-20210509190359857.png)

![image-20210509191042615](\MyBatis.assets\image-20210509191042615.png)

## SQL配置文件(245-260集)

### 详情见  [mybatis官方文档](https://mybatis.org/mybatis-3/zh/sqlmap-xml.html)(245集)

### 获取自增主键的值(246集)

![image-20210510170513320](\MyBatis.assets\image-20210510170513320.png)

### 获取非自增主键的值(247集)

![image-20210510172559557](\MyBatis.assets\image-20210510172559557.png)

![image-20210510173705764](\MyBatis.assets\image-20210510173705764.png)

![image-20210510173754599](\MyBatis.assets\image-20210510173754599.png)

Tips:不写 order,resultType,keyProperty也能成功,但此时是自增的,而不是自己控制id+1,注意控制台Parameters:null

![image-20210510173950730](\MyBatis.assets\image-20210510173950730.png)

### 参数的各种取值(248集)

![image-20210510180042533](\MyBatis.assets\image-20210510180042533.png)

Parameter 'id' not found. Available parameters are [0, 1, param1, param2]

![image-20210510180730052](\MyBatis.assets\image-20210510180730052.png)

![image-20210510182421861](\MyBatis.assets\image-20210510182421861.png)

![image-20210510184448519](\MyBatis.assets\image-20210510184448519.png)

![image-20210510184529551](\MyBatis.assets\image-20210510184529551.png)

```xml
<!-- 现象
		1.单个参数:
			基本类型:取值,#{随便写}
			传入pojo(javabean)
		2.多个参数
			public Employee getEmpByIdAndEmpName(Integer id, String empName);
			取值:#{参数名}是无效的;
			可用:0,1(参数的索引)或者param1,param2(第几个参数paramN)
			原因:只要传入了多个参数; mybatis会自动的将这些参数封装在一个map中;
				封装时使用的key就是参数的索引和参数的第几个表示
				Map<String,Object> map = new HashMap<>();
				map.put("1",传入的值);map.put("2","传入的值");
				#{key}就是从这个map取值
		
		3.	@Param: 为参数指定key; 命名参数; 我们以后也推荐这么做
			我们可以告诉mybatis,封装参数map的时候别乱来,使用我们指定的key
		4. 	传入了pojo(javabean)
	 		取值:#{pojo的属性名}
	 	5.	传入了map: 将多个要使用的参数封装起来
	 		取值:#{key}
	 	扩展: 多个参数:自动封装map;
	 	method01(@Param("id")Integer id,String empName,Employee employee)
	 	Integer id-> #{id}
	 	String empName -> #{param2}
	 	Employee employee(取出这个里面的email)->#{param3.email}
	 	
	 	无论传入什么参数都要能正确的取出值;
	 	#{key/属性名}
	 -->
```



### SQL映射文件-oracle数据库情况下jdbcType需要被指定(249集)暂且跳过

​	

### SQL映射文件-#{}和${}取值的区别(250集)

```xml
<!-- 
		实际上在mybatis中;两种取值方式;
		#{属性名};是参数预编译的方式,参数的位置都是用?替代,参数后来都是预编译设置进去.安全,不会有sql注入问题
		${属性名} ;不是参数预编译,而是直接和sql语句进行拼串; 不安全
			传入一个'1 or 1=1 or';
			id = 1 or 1=1 or and empname=
			
			${}使用场景:sql语句只有参数位置是支持预编译的, 表名位置不支持预编译
			log_2021_12,log_2018_1(日志表表名);(日志作了多张表)表名为动态传参
			select * from ${日志表表名} where id = ? and empname=?
		-->
	<!--  id = #{id} and empname=#{empName} 
	 	  select * from t_employee where id = ? and empname=?  -->
	 
	<!--  id = ${id} and empname=#{empName} 
		  select * from t_employee where id = 1 and empname=?
		  
		  一般都是使用#{};安全;在不支持参数预编译的位置使用${}
	-->
```

### SQL映射文件-查询返回list(251集)

返回列表或集合,SQL映射文件resultType写元素的类型,而不是列表或集合本身

![image-20210510224953026](\MyBatis.assets\image-20210510224953026.png)



### SQL映射文件-查询多个封装map(252集)

查询一条记录,返回一个map,列名作为key,值作为value

![image-20210511101222547](\MyBatis.assets\image-20210511101222547.png)

查询多条记录,返回一个map,主键作为key,封装对象作为value,==需使用注解@MapKey(id)==

![image-20210511104129087](\MyBatis.assets\image-20210511104129087.png)

下图为使用注解测试成功,但是打印对象没有按照toString打印

![image-20210511104856977](\MyBatis.assets\image-20210511104856977.png)

![image-20210511105559824](\MyBatis.assets\image-20210511105559824.png)

![image-20210511105757799](\MyBatis.assets\image-20210511105757799.png)

### SQL映射文件-resultType自定义封装规则(253集)	

![image-20210511115813547](\MyBatis.assets\image-20210511115813547.png)

![image-20210511120112339](\MyBatis.assets\image-20210511120112339.png)

![image-20210511122218223](\MyBatis.assets\image-20210511122218223.png)

### [SQL映射文件-联合查询-1、级联属性的方式封装查出的数据](https://www.bilibili.com/video/BV1d4411g7tv?p=254)(254集)

![image-20210514221434898](\MyBatis.assets\image-20210514221434898.png)

### SQL映射文件-联合查询-2、使用association定义联合查询的对象的封装规则(255集)

![image-20210514223958671](\MyBatis.assets\image-20210514223958671.png)

### SQL映射文件-联合查询-3、加谈-关联关系(256集)

> 1-1关联 1-n  n-n关联
> 一个key开一把lock: 1-1
> 从lock来看key: 1-n
> 从key来看lock: n-1
> n-n:学生和老师
> 一对n:外键一定放在n的一端
> ==n-n:中间表存储对应关系==
>
> 滚回去复习数据库设计范式！！！

### SQL映射文件-联合查询-4、collection定义集合类型属性的封装规则(257集)

![image-20210515114120688](\MyBatis.assets\image-20210515114120688.png)

### SQL映射文件-联合查询-5、使用select属性指定分步查询(258集)

![image-20210515133524363](\MyBatis.assets\image-20210515133524363.png)



### SQL映射文件-联合查询-6、按需加载和延迟加载(259集)

![image-20210515135112444](\MyBatis.assets\image-20210515135112444.png)

![image-20210515135646520](\MyBatis.assets\image-20210515135646520.png)

![image-20210515141216403](\MyBatis.assets\image-20210515141216403.png)

### SQL映射文件-联合查询-7、collection分步查询延迟加载测试(260集)

![image-20210515144330261](\MyBatis.assets\image-20210515144330261.png)



## 动态Sql(261-267集)

### 动态sql-if标签(261集)

![image-20210515155930065](\MyBatis.assets\image-20210515155930065.png)

### 动态sql-where标签(262集)

![image-20210515210148560](\MyBatis.assets\image-20210515210148560.png)

### 动态sql-trim标签(263集)

![image-20210515211303019](\MyBatis.assets\image-20210515211303019.png)

### 动态sql-foreach遍历元素(264集)

```xml
<!-- <foreach>帮我们遍历集合的；collection="";指定要遍历的集合的key list参数的类型，
			填list(collection="list")能取出来，用参数名ids(collection="ids")不能，
			但在使用@Param指定参数名后就可以了-->
		<!--
			index="" 索引
				如果遍历的是一个list:
					index:指定的变量保存了当前索引
					item:保存当前遍历的元素的值
				如果遍历的是一个map:
					index:指定的变量就是保存了当前遍历的元素的key
					item:就是保存当前遍历的元素的值
			item="" 变量名：每次遍历出的元素起一个变量名方便引用
			open="" 以什么开始
			close="" 以什么结束
			separator="" 每个遍历的元素的分隔符
		 -->
```

![image-20210515214404421](\MyBatis.assets\image-20210515214404421.png)





### 动态sql-choose分支选择(265集)

![image-20210515222159752](\MyBatis.assets\image-20210515222159752.png)![image-20210515222523703](\MyBatis.assets\image-20210515222523703.png)

### 动态sql-使用if结合set完成mybatis动态更新(266集)

![image-20210515224425830](\MyBatis.assets\image-20210515224425830.png)

![image-20210515225658785](\MyBatis.assets\image-20210515225658785.png)



### 动态sql-补充-OGNL和其他两个可用的参数(267集)

![image-20210515230919297](\MyBatis.assets\image-20210515230919297.png)

### 动态sql-sql标签bind+抽取可重用的sql，使用include包含进来(268集)

<bind>标签:可以使用ONGL表达式创建一个变量并将其绑定到上下文中

```xml
<if test="username" != null and userName != ''">
   and user_name like concat('%',#{userName},'%')
</if>
<!-- 如果使用concat函数连接字符串,在MySQL中,这个函数支持多个参数,但在Oracle中只支持两个参数.由于不同数据库之间的语法差异,如果更换数据库,有些SQL语句可能就需要重写.针对这种情况,可以使用bind标签来避免由于更换数据库带来的麻烦.将上面的方法改为bind方式后,代码如下 -->
<if test="username" != null and userName != ''">
    <bind name="userNameLike" value="'%' + userName + '%'"/>
    and user_name like #{userNameLike}
</if>
<!-- <bind>标签的两个属性都是 -->
```

<inclued>标签:抽取可重用的sql语句![image-20210515232358955](\MyBatis.assets\image-20210515232358955.png)

## 缓存(269-276集)

### 缓存-缓存简介(269集)

缓存:	暂时的存储一些数据; 加快系统的查询速度

CPU:	主频:	4-2.7GHZ

​			 内存:	4G-8G	1333MHZ	2166MHZ

​			 CPU:	一级缓存(4MB)	二级缓存(16MB)

数据库交互:

> Employee employee = employDao.getEmpById(1);

MyBatis缓存机制: Map; 能保存查询出的一些数据

一级缓存:线程级别的缓存; 本地缓存; SqlSession级别的缓存

二级缓存:全局范围的缓存; 除过当前线程; SqlSession能用外其他也可以使用

---



### 缓存-一级缓存体会(270集)

一级缓存: MyBatis: SqlSession级别的缓存; 默认存在;

机制:	只要之前查询过的数据, mybatis就会保存在一个缓存中(Map);下次获取直接从缓存中拿

![image-20210516091739629](\MyBatis.assets\image-20210516091739629.png)

### 缓存-一级缓存失效的几种情况以及观察原理(271集)

一级缓存失效的几种情况
一级缓存是SqlSession级别的缓存

1.不同的sqlSession,使用不同的一级缓存;
只有在同一个sqlSession期间查询到的数据会保存到这个sqlSession的缓存中;下次使用这个sqlSession查询会从缓存中拿
2.同一个方法,不同的参数,由于可能之前没查询过,所以还会发新的sql
3.在sqlSession期间执行上任何一次增删改操作,增删改操作会把缓存清空
4.手动清空缓存

![image-20210516092819790](\MyBatis.assets\image-20210516092819790.png)![image-20210516093650678](\MyBatis.assets\image-20210516093650678.png)

![image-20210516094130206](\MyBatis.assets\image-20210516094130206.png)

![image-20210516094809961](\MyBatis.assets\image-20210516094809961.png)

### 缓存-二级缓存体验(272集)

二级缓存:

一级缓存:SqlSession关闭或者提交以后,一级缓存的数据就会放在二级缓存中;mybatis默认没有使用的;配置;

二级缓存的使用:

1.全局配置开启二级缓存

> <!-- 开启全局缓存开关 -->
> 		<setting name="cacheEnabled" value="true"/>

2.配置某个dao.xml文件,让其使用

> <!-- 使用二级缓存 -->
> 	<cache></cache>

![image-20210516100135259](\MyBatis.assets\image-20210516100135259.png)

![image-20210516101402779](\MyBatis.assets\image-20210516101402779.png)

### 缓存-缓存的查询顺序(273集)

1.不会出现一级缓存和二级缓存中有同一数据
	  		二级缓存中:一级缓存关闭就有了
	  		一级缓存中:二级缓存中没有此数据, 就会看一级缓存,一级缓存没有去查数据库
	  		数据库的查询后的结果放在一级缓存中了;
2.任何时候都是先看二级缓存,再看一级缓存.如果大家都没有就去查询数据库

![image-20210516104422428](\MyBatis.assets\image-20210516104422428.png)

### 缓存-缓存原理(274集)

![image-20210516105242171](\MyBatis.assets\image-20210516105242171.png)

### 缓存-缓存有关的属性(275集)

1、全局setting的cacheEnable：配置二级缓存的开关。一级缓存一直是打开的。
2、select标签的useCache属性：配置这个select是否使用二级缓存。一级缓存一直是使用的
3、sql标签的flushCache属性：增删改默认flushCache=true。sql执行以后，会同时清空一级和二级缓存。查询默认flushCache=false。
4、sqlSession.clearCache()：只是用来清除一级缓存。
5、当在某一个作用域 (一级缓存Session/二级缓存Namespaces) 进行了 C/U/D 操作后，默认该作用域下所有 select 中的缓存将被clear。 

![image-20210516105642716](\MyBatis.assets\image-20210516105642716.png)useCache=""是否使用二级缓存,对一级缓存没影响 默认是true![image-20210516105934038](\MyBatis.assets\image-20210516105934038.png)

### 缓存-整合第三方缓存(276集)

MyBatis开放了Cache接口

整合ehcache;ehcache非常专业的java进程内的缓存框架

1.导包

> ehcache-core-2.6.8.jar(ehcache核心包)
> mybatis-ehcache-1.0.3.jar(ehcache与mybatis整合包,可以不写Cache的实现类)
> slf4j-api-1.7.21.jar
> slf4j-log4j12-1.7.21.jar

2.ehcache要工作有一个配置文件;

文件名叫ehcache.xml;放在类路径的根目录下

3.在mapper.xml中配置使用自定义的缓存

```xml
<cache type="org.mybatis.caches.ehcache.EhcacheCache"></cache>
```

4.别的dao还要用

```xml
<!--和别的dao公用一块缓存-->
<cache namespace="com.Ray.dao.TeacherDao"></cache>
```

![image-20210516112930791](\MyBatis.assets\image-20210516112930791.png)