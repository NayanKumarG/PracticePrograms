#! /bin/bash
#script to find given year is leap year or not
read -p "Enter the year to check leap or not:" year
if [[ (($year%400 -eq 0)) || (($year%4 -eq 0)) && (($year%100 -ne 0))]]
then
echo "Given year $year is leap year"
else
echo "Not a leap year"
fi 
