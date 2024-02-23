
# security-jwt-based-back

This is a Spring Boot project that shows how to secure resources using authentication with Spring Security and Json Web Token (JWT).

## Technologies used
- Java 21
- Spring Boot 3.2.2
- Spring Security 6.2
- Json Web Token 0.12.3

## Installation
Follow these steps to install and run the project:

    1. Navigate to the project directory: `cd your-repo`
    2. Build the project using Maven:: `mvn clean install`
    3. Run the project: `mvn spring-boot:run`
    4. Test the API Rest using postman or another application at `http://localhost:8080`.

## Usage
    1. Start the spring boot service
    2. Consume the register user service to register a user into database. It is required to provide a username and password.
    3. Consume the login service sending a request with username and password in the body.
    4. In case that login was successfully it will response a JWT token.
    5. Consume the welcome service sending a request with the JWT token in the authorization header.
    6. When consuming the welcome service and the JWT token is valid a welcome message will be displayed.
    7. When consuming the welcome service and the JWT token is not valid a forbidden response will displayed.

## API Reference

#### Endpoint to register a user

```http
  POST http://localhost:8080/authentication/register
```
Body request
```javascript
{
    "username":"someone@somehting.com",
    "password": "123456",
    "lastname": "lastname",
    "firstname": "firstname",
    "country": "country"
}
```


#### Endpoint to login and get a JWT token

```http
  POST http://localhost:8080/authentication/login
```


Body request
```javascript
{
    "username": "someone@somehting.com",
    "password":"123456"
}
```


#### Endpoint to get a secured resource

```http
  GET http://localhost:8080/api/v1/demo
```