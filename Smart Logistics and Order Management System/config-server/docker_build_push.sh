mvn clean package
docker build -t config-server .
docker tag config-server razibhossain/config-server
docker push razibhossain/config-server