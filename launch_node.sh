#!/usr/bin/env bash

echo "adb - script"
killall node
START_PORT=4000

DEVICE_ID=`adb devices | tail -n +2 | cut -sf 1`
echo "Android Device Found : $DEVICE_ID"
JSON=jsonConfFiles/$DEVICE_ID.json
echo "Json file : $JSON"
PATH1=$(pwd)
CONFIGFILE=$PATH1/$JSON
echo "Config file : $CONFIGFILE"
NODE_PORT=$START_PORT
BOOTSTRAP_PORT=$((START_PORT + 1))
CHROME_PORT=$((START_PORT + 2))
echo "Node port: $NODE_PORT"
echo "Bootstrap port: $BOOTSTRAP_PORT"
echo "Chrome port: $CHROME_PORT"
echo "------------------------"
appium \
-a localhost \
-U ${DEVICE_ID} \
--nodeconfig $CONFIGFILE \
--full-reset \
--port $NODE_PORT \
--bootstrap-port $BOOTSTRAP_PORT \
--chromedriver-port $CHROME_PORT \
--log "${PATH1}/logs/${DEVICE_ID}-nodeServer.log"
