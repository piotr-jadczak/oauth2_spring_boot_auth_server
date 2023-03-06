#!/bin/bash
source variables.sh

echo -e "\nDrop database: $dbname"
psql -c "drop database $dbname with (FORCE)" "user=$user password=$password"

echo -e "\nCreate database $dbname"
psql -c "create database $dbname owner $user" "user=$user password=$password"

echo -e "\nInitialize database:"
for file in update-db/*.sql;
do
  echo -e "\nExecute sql file: $file"
  psql -c "\i $file" "user=$user password=$password dbname=$dbname"
done