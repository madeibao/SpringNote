package com.mvca.www;

import java.util.List;

/**
 * @ClassName UserDto
 * @Author：Mayuan
 * @Date 2024/7/28/星期日 21:56
 * @Description TODO
 * @Version 1.0
 **/
public class UserDto {
    //个人基本信息
    private UserInfoDto userInfo;
    //工作信息
    private WorkInfoDto workInfo;
    //工作经验（0到n个）
    private List<ExperienceInfoDto> experienceInfos;

    public UserInfoDto getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoDto userInfo) {
        this.userInfo = userInfo;
    }

    public WorkInfoDto getWorkInfo() {
        return workInfo;
    }

    public void setWorkInfo(WorkInfoDto workInfo) {
        this.workInfo = workInfo;
    }

    public List<ExperienceInfoDto> getExperienceInfos() {
        return experienceInfos;
    }

    public void setExperienceInfos(List<ExperienceInfoDto> experienceInfos) {
        this.experienceInfos = experienceInfos;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userInfo=" + userInfo +
                ", workInfo=" + workInfo +
                ", experienceInfos=" + experienceInfos +
                '}';
    }
}
