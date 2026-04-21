mvn clean package
docker build -t apigateway .
docker tag apigateway razibhossain/apigateway
docker push razibhossain/apigateway