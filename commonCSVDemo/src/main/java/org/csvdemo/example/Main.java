package org.csvdemo.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
    private void processCSV() {
        try (Reader in = new FileReader("E:\\JavaWorkSpace2\\commonCSVDemo\\src\\main\\java\\org\\csvdemo\\example\\common.csv", StandardCharsets.UTF_8)) {
            // 读取文件：CSVFormat.EXCEL 表示使用Excel风格的 CSV 格式进行解析
            CSVParser records = CSVFormat.EXCEL.parse(in);
            // 读取所有行
            List<CSVRecord> list = records.getRecords();
            // 遍历每一行
            for (CSVRecord record : list) {
                // 输出每一行的大小
                System.out.println(record.size() + " ");
                // 遍历每一行的每一列
                for (int i = 0; i < record.size(); i++) {
                    System.out.print(record.get(i) + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        new Main().processCSV();
    }
}