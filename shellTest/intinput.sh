


set -u
set -e
BEGINCOLOR="\033[$[RANDOM%6+31]m"
ENDCOLOR="\033[0m"

read -p "please input a num " data
if [[ "$data" =~ ^[0-9]+$ ]];then
	if [ $data -eq 0 ];then
		echo -e $BEGINCOLOR"0 is not a positive integer"$ENDCOLOR
	else
		echo -e $BEGINCOLOR"$data is legal integer"$ENDCOLOR
	fi
else
	echo -e $BEGINCOLOR"invalid format number, retry"$ENDCOLOR
fi


