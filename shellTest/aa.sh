
#!/bin/bash

# 提示用户输入循环次数
echo "please enter the loop count:"
read count

# 检查输入是否为有效的数字
if [ "$count" -lt 0 ]; then
    echo "请输入一个有效的数字。"
    exit 1
fi

# 使用 for 循环打印 "hello world"
for ((i = 1; i <= count; i++))
do
    echo "hello world"
done

for skill in Ada Coffe Action Java; 
do
    echo "I am good at ${skill} Script"
done

