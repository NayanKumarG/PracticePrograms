#! /bin/bash

read -p "Enter the name of the file :" file_name 
if [ -e $file_name ]
then
echo "$file_name found"
else
echo "file is empty"
fi


