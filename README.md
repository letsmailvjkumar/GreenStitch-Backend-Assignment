# Assignment

This is a sample project for managing user signup and login functionality using Spring Boot.

## Prerequisites

- Java 17
- Maven
- Database (e.g., MySQL, PostgreSQL, H2)

## Getting Started

1. Clone the repository:
   git clone https://github.com/your-username/assignment.git

Update the database configuration:
Open src/main/resources/application.properties.
Update the database connection details (URL, username, password) according to your setup.

Access the application:
The application will be running at http://localhost:8080.
Use an API testing tool (e.g., Postman) to interact with the endpoints.

Endpoints
Signup
URL: http://localhost:8080/signup
Method: POST
Request Body: JSON object with the following fields:
name: User's name
username: User's username
password: User's password
phone: User's phone number
dob: User's date of birth
Response: "Signup successful" if the user is created successfully; otherwise, "Username already exists" if the username is already taken.

Login
URL: http://localhost:8080/login
Method: POST
Request Body: JSON object with the following fields:
username: User's username
password: User's password
Response: A JSON Web Token (JWT) if the login is successful; otherwise, an "Invalid credentials" message.

Security
The application uses JWT-based authentication.
The /signup endpoint is accessible without authentication.
All other endpoints require authentication.

Database
The application uses a database to store user information.
Update the database connection details in application.properties to connect to your database.

Dependencies
Spring Boot Web
Spring Boot Data JPA
H2 Database (for development/testing)
Spring Security

Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.
