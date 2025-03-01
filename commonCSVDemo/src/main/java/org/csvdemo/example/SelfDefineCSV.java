package org.csvdemo.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 自己定义csv的解析内容，
 *
 * @ClassName SelfDefineCSV
 * @Author：Mayuan
 * @Date 2025/3/1/星期六 17:04
 * @Description TODO
 * @Version 1.0
 **/
public class SelfDefineCSV {
    public static void main(String[] args) {
        try {
            // 创建一个 Writer 对象，用于写入 CSV 文件
            Writer out = new FileWriter("custom_output.csv");

            // 自定义 CSV 格式，使用分号作为分隔符
            CSVFormat customFormat = CSVFormat.DEFAULT.withDelimiter(';');

            // 使用自定义格式创建 CSVPrinter 对象
            CSVPrinter printer = new CSVPrinter(out, customFormat);

            // 写入表头
            printer.printRecord("Name", "Age", "City");

            // 写入数据行
            printer.printRecord("John", "25", "New York");
            printer.printRecord("Jane", "30", "Los Angeles");

            // 刷新并关闭 CSVPrinter
            printer.flush();
            printer.close();

            System.out.println("自定义格式的 CSV 文件写入成功！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("CSV 文件写入失败：" + e.getMessage());
        }
    }
}
