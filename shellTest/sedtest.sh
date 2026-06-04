#!/bin/bash

# sed -i 's/原字符串/新字符串/g' 文件名

# i 表示忽略大小写
# g 表示全局替换
# s 表示替换操作
# 原字符串和替换的字符串之间用斜杠分隔

# 例子：将文件 example.txt 中的所有 "foo" 替换为 "hee"

# 命令：
echo "foo" >> example.txt
echo "foo" >> example.txt
echo "foo" >> example.txt

# 首先查看下文件内容
cat example.txt

# 然后执行替换操作, 首先进行备份，以防万一
sed -i.bak 's/foo/dee/g' example.txt

# 查看替换后的文件内容
cat example.txt

