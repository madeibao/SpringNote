/*
 Navicat Premium Data Transfer

 Source Server         : myTest
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : workspace

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 22/08/2023 14:35:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` double(10, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'aaa', 3500);
INSERT INTO `account` VALUES (2, 'bbb', 800);
INSERT INTO `account` VALUES (3, 'mc', 300);
INSERT INTO `account` VALUES (4, 'md', 400);
INSERT INTO `account` VALUES (5, 'me', 200);

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `user_id` int(0) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ustates` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 'C', 'A');
INSERT INTO `book` VALUES (2, 'C++', 'B');
INSERT INTO `book` VALUES (3, 'java', 'a');
INSERT INTO `book` VALUES (4, 'python', 'c');
INSERT INTO `book` VALUES (5, 'C#', 'b');

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count` int(0) NULL DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES (1, '爱国者', 10, '美国');
INSERT INTO `books` VALUES (2, '东风', 20, '中国');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `c_id` int(0) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`c_id`) USING BTREE,
  INDEX `fk_teacher_id`(`teacher_id`) USING BTREE,
  CONSTRAINT `fk_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`t_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, 'class_a', 1);
INSERT INTO `class` VALUES (2, 'class_b', 2);

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `id` int unsigned NOT NULL,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES (2, '6班');
INSERT INTO `classes` VALUES (9, '8班');
INSERT INTO `classes` VALUES (10, '7班');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '软件部');
INSERT INTO `department` VALUES (2, '体验部');
INSERT INTO `department` VALUES (3, '营销部');
INSERT INTO `department` VALUES (4, '法律部');
INSERT INTO `department` VALUES (5, '高管部');
INSERT INTO `department` VALUES (6, '');

-- ----------------------------
-- Table structure for dept_emp
-- ----------------------------
DROP TABLE IF EXISTS `dept_emp`;
CREATE TABLE `dept_emp`  (
  `emp_no` int(0) NOT NULL,
  `dept_no` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  PRIMARY KEY (`emp_no`, `dept_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept_emp
-- ----------------------------
INSERT INTO `dept_emp` VALUES (10001, 'd001', '1986-06-26', '9999-01-01');
INSERT INTO `dept_emp` VALUES (10002, 'd001', '1996-08-03', '9999-01-01');
INSERT INTO `dept_emp` VALUES (10003, 'd001', '1996-08-03', '1997-08-03');
INSERT INTO `dept_emp` VALUES (10003, 'd004', '1995-12-03', '9999-01-01');
INSERT INTO `dept_emp` VALUES (10004, 'd004', '1986-12-01', '9999-01-01');
INSERT INTO `dept_emp` VALUES (10005, 'd003', '1989-09-12', '9999-01-01');
INSERT INTO `dept_emp` VALUES (10006, 'd002', '1990-08-05', '9999-01-01');
INSERT INTO `dept_emp` VALUES (10007, 'd005', '1989-02-10', '9999-01-01');
INSERT INTO `dept_emp` VALUES (10008, 'd005', '1998-03-11', '2000-07-31');
INSERT INTO `dept_emp` VALUES (10009, 'd006', '1985-02-18', '9999-01-01');
INSERT INTO `dept_emp` VALUES (10010, 'd005', '1996-11-24', '2000-06-26');
INSERT INTO `dept_emp` VALUES (10010, 'd006', '2000-06-26', '9999-01-01');

-- ----------------------------
-- Table structure for dept_manager
-- ----------------------------
DROP TABLE IF EXISTS `dept_manager`;
CREATE TABLE `dept_manager`  (
  `dept_no` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `emp_no` int(0) NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  PRIMARY KEY (`emp_no`, `dept_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept_manager
-- ----------------------------
INSERT INTO `dept_manager` VALUES ('d001', 10002, '1996-08-03', '9999-01-01');
INSERT INTO `dept_manager` VALUES ('d004', 10004, '1986-12-01', '9999-01-01');
INSERT INTO `dept_manager` VALUES ('d003', 10005, '1989-09-12', '9999-01-01');
INSERT INTO `dept_manager` VALUES ('d002', 10006, '1990-08-05', '9999-01-01');
INSERT INTO `dept_manager` VALUES ('d005', 10010, '1996-11-24', '2000-06-26');
INSERT INTO `dept_manager` VALUES ('d006', 10010, '2000-06-26', '9999-01-01');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT,
  `Salary` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, 100);
INSERT INTO `employee` VALUES (2, 200);
INSERT INTO `employee` VALUES (3, 300);

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees`  (
  `emp_no` int(0) NOT NULL,
  `birth_date` date NOT NULL,
  `first_name` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `hire_date` date NOT NULL,
  PRIMARY KEY (`emp_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES (10001, '1953-09-02', 'Georgi', 'Facello', 'M', '1986-06-26');
INSERT INTO `employees` VALUES (10002, '1964-06-02', 'Bezalel', 'Simmel', 'F', '1985-11-21');
INSERT INTO `employees` VALUES (10003, '1959-12-03', 'Parto', 'Bamford', 'M', '1986-08-28');
INSERT INTO `employees` VALUES (10004, '1954-05-01', 'Chirstian', 'Koblick', 'M', '1986-12-01');
INSERT INTO `employees` VALUES (10005, '1955-01-21', 'Kyoichi', 'Maliniak', 'M', '1989-09-12');
INSERT INTO `employees` VALUES (10006, '1953-04-20', 'Anneke', 'Preusig', 'F', '1989-06-02');
INSERT INTO `employees` VALUES (10007, '1957-05-23', 'Tzvetan', 'Zielinski', 'F', '1989-02-10');
INSERT INTO `employees` VALUES (10008, '1958-02-19', 'Saniya', 'Kalloufi', 'M', '1994-09-15');
INSERT INTO `employees` VALUES (10009, '1952-04-19', 'Sumant', 'Peac', 'F', '1985-02-18');
INSERT INTO `employees` VALUES (10010, '1963-06-01', 'Duangkaew', 'Piveteau', 'F', '1989-08-24');
INSERT INTO `employees` VALUES (10011, '1953-11-07', 'Mary', 'Sluis', 'F', '1990-01-22');

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper`  (
  `paper_id` int(0) NOT NULL AUTO_INCREMENT,
  `paper_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paper_num` int(0) NULL DEFAULT NULL,
  `paper_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`paper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES (5, '这里论文名称', 10, '这里是详情');
INSERT INTO `paper` VALUES (7, '计算机视觉', 20, '图像理解');
INSERT INTO `paper` VALUES (9, '射频感应', 20, 'RFID射频感应');
INSERT INTO `paper` VALUES (10, '射频感应2', 2, 'NFC应用');
INSERT INTO `paper` VALUES (12, 'WIFI', 2, 'WIFI应用');
INSERT INTO `paper` VALUES (13, 'BlueTooth', 2, '蓝牙应用');
INSERT INTO `paper` VALUES (14, 'Chare', 2, '论文数量分析');
INSERT INTO `paper` VALUES (15, 'Linux 内核', 2, 'Linux 内核详细描述');
INSERT INTO `paper` VALUES (16, 'NFC', 2, 'NFC基本');
INSERT INTO `paper` VALUES (18, '苗刀', 2, '靳一川');
INSERT INTO `paper` VALUES (19, '高丽航空', 2, '朝鲜');
INSERT INTO `paper` VALUES (20, '郑耀先', 2, '间谍');

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `pname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `brand` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` float(7, 2) NULL DEFAULT NULL,
  `stock` smallint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES (101, '数码相机', '奥林巴斯', 1330.00, 3);
INSERT INTO `products` VALUES (102, '平板电脑', '苹果', 1990.00, 5);
INSERT INTO `products` VALUES (103, '笔记本计算机', '联想', 4900.00, 8);
INSERT INTO `products` VALUES (104, '苹果7', '苹果', 5300.00, 5);
INSERT INTO `products` VALUES (105, '台式计算机', '戴尔', 4500.00, 10);

-- ----------------------------
-- Table structure for salaries
-- ----------------------------
DROP TABLE IF EXISTS `salaries`;
CREATE TABLE `salaries`  (
  `emp_no` int(0) NOT NULL,
  `salary` int(0) NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  PRIMARY KEY (`emp_no`, `from_date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salaries
-- ----------------------------
INSERT INTO `salaries` VALUES (10001, 90000, '1986-06-26', '1987-06-26');
INSERT INTO `salaries` VALUES (10001, 88958, '2002-06-22', '9999-01-01');
INSERT INTO `salaries` VALUES (10002, 72527, '1996-08-03', '1997-08-03');
INSERT INTO `salaries` VALUES (10002, 72527, '2000-08-02', '2001-08-02');
INSERT INTO `salaries` VALUES (10002, 72527, '2001-08-02', '9999-01-01');
INSERT INTO `salaries` VALUES (10003, 90000, '1996-08-03', '1997-08-03');

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES (1, 'mayuan', 22);
INSERT INTO `stu` VALUES (2, '鲁智深', 23);
INSERT INTO `stu` VALUES (3, '鲁达', 25);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `s_id` int(0) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `class_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`s_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'student_A', 1);
INSERT INTO `student` VALUES (2, 'student_B', 1);
INSERT INTO `student` VALUES (3, 'student_C', 1);
INSERT INTO `student` VALUES (4, 'student_D', 2);
INSERT INTO `student` VALUES (5, 'student_E', 2);
INSERT INTO `student` VALUES (6, 'student_F', 2);

-- ----------------------------
-- Table structure for studenta
-- ----------------------------
DROP TABLE IF EXISTS `studenta`;
CREATE TABLE `studenta`  (
  `id` int unsigned NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studenta
-- ----------------------------
INSERT INTO `studenta` VALUES (1, '张三', 0);
INSERT INTO `studenta` VALUES (2, '关羽', 96);
INSERT INTO `studenta` VALUES (3, '刘备', 99);

-- ----------------------------
-- Table structure for t_account
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_account
-- ----------------------------
INSERT INTO `t_account` VALUES (44, '⼩小明', '000', 18);
INSERT INTO `t_account` VALUES (45, '小鲁', '222', 23);
INSERT INTO `t_account` VALUES (46, '张三', '123123', 22);
INSERT INTO `t_account` VALUES (48, '王五', '111111', 24);
INSERT INTO `t_account` VALUES (49, '张三', '123123', 22);

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept`  (
  `did` int(0) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`did`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_emp
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp`  (
  `eid` int(0) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `did` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`eid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `age` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', '123456', '2000-12-04', '23');
INSERT INTO `t_user` VALUES (2, 'manager', '123456', '2000-12-04', '23');
INSERT INTO `t_user` VALUES (3, 'admin2', '1234567', '1995-08-11', '25');

-- ----------------------------
-- Table structure for tb_brand
-- ----------------------------
DROP TABLE IF EXISTS `tb_brand`;
CREATE TABLE `tb_brand`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ordered` int(0) NULL DEFAULT NULL,
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_brand
-- ----------------------------
INSERT INTO `tb_brand` VALUES (1, '华为', '华为技术有限公司', 100, '万物互联', 1);
INSERT INTO `tb_brand` VALUES (6, '百度', '百度在线网络技术公司', 5, '搜搜搜', 0);
INSERT INTO `tb_brand` VALUES (8, '小米', '小米科技有限公司', 50, 'are you ok', 1);
INSERT INTO `tb_brand` VALUES (10, '华为', '华为技术有限公司', 100, '万物互联', 1);
INSERT INTO `tb_brand` VALUES (11, 'APPLE3', '苹果3', 3, '美国3', 1);
INSERT INTO `tb_brand` VALUES (12, '格力', '格力电器股份有限公司', 30, '让世界爱上中国造', 1);
INSERT INTO `tb_brand` VALUES (13, '阿里巴巴', '阿里巴巴集团控股有限公司', 10, '买买买', 1);
INSERT INTO `tb_brand` VALUES (14, '腾讯', '腾讯计算机系统有限公司', 50, '玩玩玩', 0);
INSERT INTO `tb_brand` VALUES (15, '百度', '百度在线网络技术公司', 5, '搜搜搜', 0);
INSERT INTO `tb_brand` VALUES (17, '华为', '华为技术有限公司', 100, '万物互联', 1);
INSERT INTO `tb_brand` VALUES (18, '小米', '小米科技有限公司', 50, 'are you ok', 1);
INSERT INTO `tb_brand` VALUES (19, '格力', '格力电器股份有限公司', 30, '让世界爱上中国造', 1);
INSERT INTO `tb_brand` VALUES (20, '阿里巴巴', '阿里巴巴集团控股有限公司', 10, '买买买', 1);
INSERT INTO `tb_brand` VALUES (21, '腾讯', '腾讯计算机系统有限公司', 50, '玩玩玩', 0);
INSERT INTO `tb_brand` VALUES (22, '百度', '百度在线网络技术公司', 5, '搜搜搜', 0);
INSERT INTO `tb_brand` VALUES (24, '小米', '小米科技有限公司', 50, 'are you ok', 1);
INSERT INTO `tb_brand` VALUES (25, '三只松鼠', '三只松鼠股份有限公司', 5, '好吃不上火', 0);
INSERT INTO `tb_brand` VALUES (26, '华为', '华为技术有限公司', 100, '万物互联', 1);
INSERT INTO `tb_brand` VALUES (27, '小米', '小米科技有限公司', 50, 'are you ok', 1);
INSERT INTO `tb_brand` VALUES (28, '格力', '格力电器股份有限公司', 30, '让世界爱上中国造', 1);
INSERT INTO `tb_brand` VALUES (29, '阿里巴巴', '阿里巴巴集团控股有限公司', 10, '买买买', 1);
INSERT INTO `tb_brand` VALUES (30, '腾讯', '腾讯计算机系统有限公司', 50, '玩玩玩', 0);
INSERT INTO `tb_brand` VALUES (31, '百度', '百度在线网络技术公司', 5, '搜搜搜', 0);
INSERT INTO `tb_brand` VALUES (33, '华为', '华为技术有限公司', 100, '万物互联', 1);
INSERT INTO `tb_brand` VALUES (34, '小米', '小米科技有限公司', 50, 'are you ok', 1);
INSERT INTO `tb_brand` VALUES (35, '格力', '格力电器股份有限公司', 30, '让世界爱上中国造', 1);
INSERT INTO `tb_brand` VALUES (36, '阿里巴巴', '阿里巴巴集团控股有限公司', 10, '买买买', 1);
INSERT INTO `tb_brand` VALUES (37, '腾讯', '腾讯计算机系统有限公司', 50, '玩玩玩', 0);
INSERT INTO `tb_brand` VALUES (38, '百度', '百度在线网络技术公司', 5, '搜搜搜', 0);
INSERT INTO `tb_brand` VALUES (40, '小米', '小米科技有限公司', 50, 'are you ok', 1);
INSERT INTO `tb_brand` VALUES (41, '三只松鼠', '三只松鼠股份有限公司', 5, '好吃不上火', 0);
INSERT INTO `tb_brand` VALUES (42, '华为', '华为技术有限公司', 100, '万物互联', 1);
INSERT INTO `tb_brand` VALUES (43, '小米', '小米科技有限公司', 50, 'are you ok', 1);
INSERT INTO `tb_brand` VALUES (44, '格力', '格力电器股份有限公司', 30, '让世界爱上中国造', 1);
INSERT INTO `tb_brand` VALUES (45, '阿里巴巴', '阿里巴巴集团控股有限公司', 10, '买买买', 1);
INSERT INTO `tb_brand` VALUES (46, '腾讯', '腾讯计算机系统有限公司', 50, '玩玩玩', 0);
INSERT INTO `tb_brand` VALUES (47, '百度', '百度在线网络技术公司', 5, '搜搜搜', 0);
INSERT INTO `tb_brand` VALUES (48, '京东', '北京京东世纪贸易有限公司', 40, '就是快', 1);
INSERT INTO `tb_brand` VALUES (49, '小马千里', '小马千里科技', 2, 'hello world', 1);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'ming', '1234567890');
INSERT INTO `tb_user` VALUES (2, 'wang', '1234567890');
INSERT INTO `tb_user` VALUES (3, 'mayuan', '123456');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `t_id` int(0) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 'teacher1');
INSERT INTO `teacher` VALUES (2, 'teacher2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'BIG SHOW', 'bigshow');
INSERT INTO `user` VALUES (2, '张四', '2323');
INSERT INTO `user` VALUES (3, '张三', '345');
INSERT INTO `user` VALUES (4, '张五', '2323');
INSERT INTO `user` VALUES (5, 'e', '5');
INSERT INTO `user` VALUES (6, 'm', '23');
INSERT INTO `user` VALUES (7, 'ee', '6');

-- ----------------------------
-- Table structure for user4
-- ----------------------------
DROP TABLE IF EXISTS `user4`;
CREATE TABLE `user4`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user4
-- ----------------------------
INSERT INTO `user4` VALUES (1, '张三', 'newpassword', 12);
INSERT INTO `user4` VALUES (2, '李四', 'password2', 12);
INSERT INTO `user4` VALUES (4, '王二', 'abcd', 13);
INSERT INTO `user4` VALUES (5, '王二', 'abcd', 13);
INSERT INTO `user4` VALUES (6, '王二', 'abcd', 13);
INSERT INTO `user4` VALUES (7, '王二', 'abcd', 13);

-- ----------------------------
-- Table structure for usera
-- ----------------------------
DROP TABLE IF EXISTS `usera`;
CREATE TABLE `usera`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住址',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usera
-- ----------------------------
INSERT INTO `usera` VALUES (1, '马远', '男', '北京', '2022-02-14');
INSERT INTO `usera` VALUES (2, '鲁智深', '男', '南京', '2022-02-14');

-- ----------------------------
-- Table structure for userb
-- ----------------------------
DROP TABLE IF EXISTS `userb`;
CREATE TABLE `userb`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for userc
-- ----------------------------
DROP TABLE IF EXISTS `userc`;
CREATE TABLE `userc`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userc
-- ----------------------------
INSERT INTO `userc` VALUES (1, 'Bob', 'ma');
INSERT INTO `userc` VALUES (2, 'nice', 'mb');
INSERT INTO `userc` VALUES (3, 'alice', 'mc');

-- ----------------------------
-- Table structure for userd
-- ----------------------------
DROP TABLE IF EXISTS `userd`;
CREATE TABLE `userd`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userd
-- ----------------------------
INSERT INTO `userd` VALUES (1, 'ab', 'abc');

-- ----------------------------
-- Table structure for weather
-- ----------------------------
DROP TABLE IF EXISTS `weather`;
CREATE TABLE `weather`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `RecordDate` date NULL DEFAULT NULL,
  `Temperature` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of weather
-- ----------------------------
INSERT INTO `weather` VALUES (1, '2015-01-01', 10);
INSERT INTO `weather` VALUES (2, '2015-01-02', 25);
INSERT INTO `weather` VALUES (3, '2015-01-03', 20);
INSERT INTO `weather` VALUES (4, '2015-01-04', 30);

SET FOREIGN_KEY_CHECKS = 1;
