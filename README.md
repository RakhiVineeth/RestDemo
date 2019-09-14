# RestDemo
"# Rest-API" 
1. Clone the application
https://github.com/RakhiVineeth/RestDemo.git
2. Create Mysql database
create database employee_database
3. Change mysql username and password as per your installation
* open src/main/resources/application.properties
* change spring.datasource.username and spring.datasource.password as per your mysql installation
4. Build and run the app using maven
mvn package
java -jar target/rest-api-0.0.1-SNAPSHOT.jar
Alternatively, you can run the app without packaging it using -
mvn spring-boot:run
The app will start running at http://localhost:8080.
5. Explore Rest APIs
The app defines following CRUD APIs.
Employee Resource
1. GET api/resources/v1/employees/
2. POST api/resources/v1/employees/
3. GET api/resources/v1/employees/{id}
4. PUT api/resources/v1/employees/{id}
5. DELETE api/resources/v1/employees/{id}

Department Resource

6. GET  api/resources/v1/departments/
7. POST api/resources/v1/departments/
8. GET  api/resources/v1/departments/{ id }
9. PUT  api/resources/v1/departments/{ id }
10. DELETE api/resources/v1/departments/{ id }



Getting List of employees associated with department id
api/resources/v1/employees/department/2

