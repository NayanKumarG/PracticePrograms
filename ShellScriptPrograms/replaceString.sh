#! /bin/bash
echo "Hello <<UserName>>,How are you"
first="Hello <<UserName>>,How are you"
read -p "Enter user name to replace:" name
echo"After replacing"
echo "${first/<<UserName>>/$name}"
