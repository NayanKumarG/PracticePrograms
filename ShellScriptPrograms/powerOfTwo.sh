#! /bin/bash
echo "Power of two"

read -p "Enter a range:" range
function powerOfTwo()
{
for((i=0; i<=range ; i++))
do 
echo "2^$i" | bc -l
done
}
powerOfTwo
