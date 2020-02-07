#! /bin/bash
#demo of an array
echo "Enter the names"
read -a names
echo "Names in array:${names[@]}"
echo "Name in 0th index:${names[0]}"
echo "Name at 1st index:${names[1]}"
