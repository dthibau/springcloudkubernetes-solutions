kubectl apply -f notification-service/k8s/notification-prod.yaml
kubectl apply -f delivery-service/k8s/delivery-service-prod.yaml
kubectl apply -f delivery-service/k8s/delivery-service-prod-v2.yaml
kubectl apply -f order-service/k8s/order-prod.yaml
kubectl apply -f zipkin.yaml
