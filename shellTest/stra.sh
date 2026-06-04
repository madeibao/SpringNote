#!/bin/bash

arr=(a1 a2 a3)
echo ${#arr[*]} # 读取数组长度
echo ${#arr[1]} # 读取数组某个元素长度

echo ${arr[*]} # 读取数组全部
echo ${arr[1]} # 读取数组某个元素