#!/bin/sh

kubectl delete service notification-service
kubectl delete service delivery-service
kubectl delete service account-service
kubectl delete service zipkin

kubectl delete deployment notification-service
kubectl delete deployment delivery-service
kubectl delete deployment account-service
kubectl delete deployment zipkin
