Task Management API (Spring Boot + JWT)
Project Overview

This project is a Task Management REST API built using Spring Boot and Spring Security with JWT authentication.
The application allows users to register, login, and manage tasks securely.

After logging in, users receive a JWT token, which must be included in the request header to access protected APIs.

Features

1.User Registration
2.User Login with JWT Authentication
3.Secure REST APIs using Spring Security
4.Create Task
5.Get All Tasks
6.Get Task by ID
7.Update Task
8.Delete Task

Technologies Used

1.Java
2.Spring Boot
3.Spring Security
4.JWT (JSON Web Token)
5.Spring Data JPA
6.MySQL

src/main/java/com/maven/task
│
├── controller
│   ├── AuthController
│   └── TaskController
│
├── model
│   ├── User
│   └── Task
│
├── repository
│   ├── UserRepository
│   └── TaskRepository
│
├── service
│   ├── CustomUserDetailsService
│   └── TaskService
│
├── security
│   ├── JwtFilter
│   ├── JwtUtil
│   └── SecurityConfig
│
└── TaskApplication

API Endpoints
Authentication APIs
Register User
POST /api/v1/auth/register

Request Body

{
 "name": "John",
 "email": "john@example.com",
 "password": "123456"
}

Login User
POST /api/v1/auth/login

Request Body

{
 "email": "john@example.com",
 "password": "123456"
}

Response

{
 "token": "jwt_token_here"
}

Task APIs (Protected)

All task APIs require Authorization Header

Authorization: Bearer <jwt_token>
Create Task
POST /api/tasks

Request Body

{
 "title": "Finish Assignment",
 "description": "Complete CRUD task",
 "status": "Pending",
 "userId": 1
}

Get All Tasks
GET /api/tasks
Get Task by ID
GET /api/tasks/{id}
Update Task
PUT /api/tasks/{id}

Delete Task
DELETE /api/tasks/{id}
How to Run the Project

Clone the repository

git clone https://github.com/Aff11/taskmanagement.git

Open the project in Eclipse

Configure database in application.properties

Example:

spring.datasource.url=jdbc:mysql://localhost:3306/task
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update

Run the application
TaskApplication.java

Test APIs using Postman

Security

This project uses JWT-based authentication.

Steps:

1.User logs in
2.Server generates a JWT token
3.Client sends token in request header
4.JwtFilter validates token for protected APIs

Future Improvements

1.Role-based authentication
2.Task priority and due dates
3.Pagination for tasks
4.Swagger API documentation
5.Frontend integration
Maven

Postman
