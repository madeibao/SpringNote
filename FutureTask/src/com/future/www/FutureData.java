package com.future.www;

/**
 * @ClassName Future
 * @Author：Mayuan
 * @Date 2024/7/13/星期六 17:14
 * @Description TODO
 * @Version 1.0
 **/

public class FutureData implements Data {

    private RealData realData;
    private boolean isReady = false;

    @Override
    public synchronized String getRequest() {
        // 如果没装载好,程序就一直处于阻塞状态
        while(!isReady){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //装载好直接获取数据即可
        return this.realData.getRequest();
    }

    public synchronized void setRealData(RealData realData){
        //如果已经装载完毕了,就直接返回
        if(isReady){
            return;
        }
        //如果没装载,进行装载真实对象
        this.realData = realData;
        isReady = true;
        //进行通知
        notify();   //通知wait()方法往下走
    }
}