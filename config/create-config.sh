#!/bin/sh

kubectl create configmap application-config --from-file=./application.yml

kubectl create configmap notification-config --from-file=./notification-service.yml
