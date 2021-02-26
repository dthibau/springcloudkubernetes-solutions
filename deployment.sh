#!/bin/sh

kubectl apply -f notification-service/k8s/notification.yaml
kubectl apply -f delivery-service/k8s/delivery-service.yaml
kubectl apply -f account-service/k8s/account.yaml
kubectl apply -f zipkin.yaml

