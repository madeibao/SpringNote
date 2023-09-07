package com.candy.demo.controller;

/**
 * @ClassName FileUploadController
 * @Author：Mayuan
 * @Date 2023/9/7/0007 15:37
 * @Description TODO
 * @Version 1.0
 **/

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * 处理图片上传的
 * @author ASUS
 */
@RestController
public class FileUploadController {
    /** 获取配置文件中配置的图片上传路径 */
    @Value("${file.uploadFolder}")
    String  dir;

    /**
     * 处理图片上传的
     * @param file：上传的图片信息
     * @return 图片上传后的路径
     * @throws IOException
     */
    @RequestMapping("/upload")
    public String upload(@RequestParam("image") MultipartFile file) throws IOException {
        System.out.println(file);
//        日期格式化处理，指定格式为年月日
        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
        //准备文件夹，以图片上传的当前时间
        String format = sdf.format(new Date());
//        String  dir="E:\\CodeSpace\\img";
//        根据指定路径创建文件所放置的文件夹
//        根据上传图片的时间，创建文件夹
        File folder = new File(dir,format);
//        如果该文件夹不存在，则在本地创建一个文件夹
        if(!folder.exists()){
            folder.mkdirs();//
        }
        //准备文件
//        for(int i=0;i<file.length;i++){
//            String oldName = file[i].getOriginalFilename();
//            String fileName= UUID.randomUUID().toString() +oldName.substring(oldName.lastIndexOf("."));
//            File file1 = new File(folder, fileName);
//            //上传
//            file[i].transferTo(file1);
//        }

        String oldName = file.getOriginalFilename();//获取后缀
//        拼接文件名字
//        利用 UUID.randomUUID()生成唯一不重复的UUID码，与当前文件的后缀进行拼接
        String fileName= UUID.randomUUID().toString() +oldName.substring(oldName.lastIndexOf("."));
//        创建文件对象
        File file1 = new File(folder, fileName);
        //上传
        file.transferTo(file1);
//        拼接文件最终路径信息
        String imgUrl="http://localhost:8086/fileupload"+format+fileName;
        //组装url
        return imgUrl;
    }
}