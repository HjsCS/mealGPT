# Alimama MealGPT Server side

## Tech Stach:
+ SpringBoot
+ Spring Security + JWT
+ Docker
+ Docker Compose
+ MYSQL
+ Lombok
+ SpringDataJPA

## How to run this application
+ Navigate the the root folder under the command line
+ Run the command to build the whole project: maven clean build
+ Either run the command to start the application: java -jar ./target/demosecurity-0.0.1-SNAPSHOT.jar
+ Or run docker-compose up, then application and MySQL are both up and running.

## How to deploy this application
+ Download the mysql docker image first by using the command
```docker pull mysql```
+ Run the docker components by ```docker run -p 3306:3306 -name mysql -e MYSQL_ROOT_PASSWORD=Alimama123 -d mysql```
+ Copy the setup sql file into the docker container ```docker cp ./sql/setup.sql mysql:./```
+ ```docker built -t app ./``` To build the docker image for springboot
+ upload docker image to the repository and download it in ec2 linux VM.