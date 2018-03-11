#!/usr/bin/env bash
FINAL_NAME=mongomvc-1.0.0-SNAPSHOT.jar

cp target/$FINAL_NAME ./docker
docker-compose up -d
rm ./docker/$FINAL_NAME
