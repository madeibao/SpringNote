package com.wjb.service;

import com.wjb.face.service.studentService;

/**
 * @Description
 * @Author jianbo wang
 * @Date:2021/12/2 0002 12:15
 */
public class StudentServiceImpl implements studentService {
    @Override
    public int save() {
        System.out.println("这是StudentServiceImpl类");
        return 450;
    }
}
