kubectl apply -f notification-service/k8s/notification.yaml
kubectl apply -f delivery-service/k8s/delivery-service.yaml
kubectl apply -f order-service/k8s/order.yaml
kubectl apply -f zipkin.yaml
