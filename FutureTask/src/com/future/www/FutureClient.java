package com.future.www;

/**
 * @ClassName FutrueClient
 * @Author：Mayuan
 * @Date 2024/7/13/星期六 17:17
 * @Description TODO
 * @Version 1.0
 **/

public class FutureClient {
    public Data request(final String queryStr) {
        //1.我想要一个代理对象(Data接口的实现类),先返回给发送请求的客户端,告诉他请求已经接受到,可以做其他的事情
        final FutureData futureData = new FutureData();
        //2.启动一个新的线程,去加载真实的数据,传递给这个代理对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                //3.这个新的线程可以慢慢地加载真实对象,然后传递给代理对象(真实的对象加载到方法中)
                RealData realData = new RealData(queryStr);
                futureData.setRealData(realData);
            }
        }).start();

        return futureData;
    }
}