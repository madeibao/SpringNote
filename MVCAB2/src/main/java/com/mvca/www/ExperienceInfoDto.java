package com.mvca.www;

/**
 * @ClassName ExperienceInfoDto
 * @Author：Mayuan
 * @Date 2024/7/28/星期日 21:56
 * @Description TODO
 * @Version 1.0
 **/
public class ExperienceInfoDto {
    //公司
    private String company;
    //职位
    private String position;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "ExperienceInfoDto{" +
                "company='" + company + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
