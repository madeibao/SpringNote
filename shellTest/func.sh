#!/bin/bash

# function to add two numbers
function sum()
{
	echo $(expr 6 + 7)
}

num=$(sum)
echo "sum is $num"