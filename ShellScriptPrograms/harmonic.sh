#! /bin/bash
#nth Harmonic number

echo "nth harmonic number"
read -p "Enter nth value:" range
total=0
res=0
for((i=1 ; i<=range ; i++))
do
res=$((1/$i)) | bc
total=$((total+res)) | bc
done
echo "harmonic number is:$total"
