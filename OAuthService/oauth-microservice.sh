#!/bin/sh
sleep 30s
/usr/bin/java -jar -DDATABASE_PASSWORD=${DATABASE_PASSWORD} -DDATABASE_HOST=${DATABASE_HOST} -DDATABASE_USER=${DATABASE_USER} -DDATABASE_NAME=${DATABASE_NAME} -DDATABASE_PORT=${DATABASE_PORT} ./app.jar 
