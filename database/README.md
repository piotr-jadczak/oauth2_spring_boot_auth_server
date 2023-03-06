Directory contains scripts to build/rebuild database.
Project is using PostgreSQL 15.1.

Place your sql scripts in update-db folder. Run `refreshDB.sh` to execute them. Remeber scripts will be executed in lexical order.

Place your database details in `variables.sh` file.

Example how `variables.sh` file should look like:

```
#!/bin/bash

user=admin

password=adminPass

dbname=example_db

```