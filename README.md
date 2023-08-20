# Todo Management Application

This is a web-based todo management application built using Spring Boot and React. The application provides secure REST APIs using Spring Security and JSON Web Tokens (JWT).

## Features

- **Server-side**: The server-side of the application is built using Spring Boot and provides secure REST APIs using Spring Security.
- **Client-side**: https://github.com/datbh06/todo-mgmt-FE 
- **Register and Login**: The application provides REST APIs for user registration and login. These APIs are secured using JWT.
- **Decentralization**: The application has been decentralized into normal users and admin users.
  - ***Normal users can register for an account, log in, and mark todo tasks as complete or pending.***
  - ***Admin users have all the permissions of normal users, as well as the ability to add, update, and delete tasks.***

## Usage

To use the application, simply register for an account as a normal user or log in as an admin user. Once logged in, you can manage your todo tasks by marking them as complete or pending. If you are an admin user, you can also add, update, and delete tasks.

## Tools and Technologies Used

### Server-side:

- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA (Hibernate)**
- **Maven**
- **IntelliJ IDEA**
- **MySQL database**
- **Postman**

## Running the Project
1. Make sure you have the following software installed on your computer:
    - Java Development Kit (JDK)
    - Maven
    - Node.js
2. Clone the repository or download the source code of the project.
3. Create a MySQL database and configure the `application.properties` file in the `src/main/resources` directory of the project
based on your database configuration, by adding .env file following format in .env.example file
4. Navigate to the root directory of the project and run the server side of the application (Using the command: mvn spring-boot:run or import and run on your IDE)
5. Navigate to the client-side directory of the project by following this link: [https://github.com/datbh06/todo-mgmt-FE]. Run the following command to install the dependencies and start the client side of the application:
6. Open your web browser and navigate to `http://localhost:3000` to access the application.
