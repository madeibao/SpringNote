#!/bin/bash

#打印每一行的第二和第三个字段：
awk '{ print $2,$3 }' example.txt

#统计文件中的行数：
awk 'END{ print NR }' example.txt