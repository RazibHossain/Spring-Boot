Add dependency:

<dependency><
	groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
</dependency>


<dependency>
	<groupId>org.springframework.boot</groupId>
			
	<artifactId>spring-boot-starter-data-jpa</artifactId>
		
</dependency>

On Application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=root
spring.datasource.password=