
#!/bin/bash

function add() {
    echo "please input first number: "
    read a
    echo "please input second number: "
    read b
    return $(($a+$b))
}
add
echo "the sum of the two number is $? !"
# $?get the return value of the last command
