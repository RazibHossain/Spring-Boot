mvn clean package
docker build -t product-service .
docker tag product-service razibhossain/product-service
docker push razibhossain/product-service