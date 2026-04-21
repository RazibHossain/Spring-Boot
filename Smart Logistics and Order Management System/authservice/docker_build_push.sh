mvn clean package
docker build -t authservice .
docker tag authservice razibhossain/authservice
docker push razibhossain/authservice