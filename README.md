Spring Boot Demo Application
----------------------------

This application demonstrates employee form with CRUD operations.

In this project the following technologies are used

1.HTML
2.Bootstrap.css
3.Thymeleaf
4.Spring Boot
5.Spring JPA
6.Spring Rest
7.Spring Test
8.H2 Database
9.Mockito



How to run the executable jar
-----------------------------
Please find the mahidhar-demo-0.0.1-SNAPSHOT.jar in mahidharDemo/target folder

Go to the above specified folder through command line and run the below mentioned command

java -jar mahidhar-demo-0.0.1-SNAPSHOT.jar


How to stop the executable jar in Windows
-----------------------------------------
Ctrl-C is the command.
If the application is not responding then use the following commands
Go to your command line and run 'JPS'
You can see all the tasks that are running
Ex: 15412 mahidhar-demo-0.0.1-SNAPSHOT.jar
Give this command 'taskkill -f /PID 15412'


Viewing the H2 database console
--------------------------------

http://localhost:8080/console

In the window
JDBC URL : jdbc:h2:mem:mahidb
password : sa
Then you should able to login into the console

Sample Data
-----------

EmployeeCommandLineRunner.java loads the sample initial data





