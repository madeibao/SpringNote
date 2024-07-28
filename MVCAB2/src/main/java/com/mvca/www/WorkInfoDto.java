package com.mvca.www;

/**
 * @ClassName WorkInfoDto
 * @Author：Mayuan
 * @Date 2024/7/28/星期日 21:57
 * @Description TODO
 * @Version 1.0
 **/
public class WorkInfoDto {
    //工作年限
    private Integer workYears;
    //工作地点
    private String workAddress;

    public Integer getWorkYears() {
        return workYears;
    }

    public void setWorkYears(Integer workYears) {
        this.workYears = workYears;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    @Override
    public String toString() {
        return "WorkInfoDto{" +
                "workYears=" + workYears +
                ", workAddress='" + workAddress + '\'' +
                '}';
    }
}
