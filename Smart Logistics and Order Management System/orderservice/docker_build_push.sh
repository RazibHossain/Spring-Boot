mvn clean package
docker build -t order-service .
docker tag order-service razibhossain/order-service
docker push razibhossain/order-service