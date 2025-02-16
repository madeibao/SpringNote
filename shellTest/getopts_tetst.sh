
#!/bin/bash
while getopts "ab:cd:" Option
do
case $Option in
a) echo -e "a = $OPTIND";;
b) echo -e "b = $OPTIND $OPTARG";;
c) echo -e "c = $OPTIND";;
d) echo -e "d = $OPTIND $OPTARG";;
esac
done
shift $(($OPTIND - 1))

echo $#

# sh ./getopts_tetst.sh -a -b foo -c -d bar

# a = 2
# b = 4 foo
# c = 5
# d = 7 bar
# 3