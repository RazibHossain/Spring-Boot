mvn clean package
docker build -t payment-service .
docker tag payment-service razibhossain/payment-service
docker push razibhossain/payment-service