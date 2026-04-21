mvn clean package
docker build -t discovery-service .
docker tag discovery-service razibhossain/discovery-service
docker push razibhossain/discovery-service