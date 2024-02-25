
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
2. Build the project using Maven: `mvn clean install`
3. Run the project: `mvn spring-boot:run`
4. Test the API Rest using postman or another application at `http://localhost:8080`.

## Usage
 1. Start the spring boot service.
 2. Register a user into database providing a username and password. The created user will have an administrator role. Use the `user registration service`.
 3. Login to the app by sending a request with username and password in the body. Use the `login service`.
 4. In case login was successful the response will show a jwt token. Copy that token.
 5. Paste the token into a new Authorization Header request.
 6. Consume the `administrators welcome service` and it will show a message for administrators with ok http status.
 7. Consume the `users welcome service` and it will not show any message with 403 forbidden http status because user rol is not administrator.
 8. Consume the `guests welcome service` and it will show a message for guests with ok http status because every role is a guest.

## Api Reference

#### User registration service

```http
  POST http://localhost:8181/authentication/register
  
   Body
   {
      "username":"someone@somehting.com",
      "password": "123456",
      "lastname": "lastname",
      "firstname": "firstname",
      "country": "country"
   }
```

#### Login service

```http
  POST http://localhost:8181/authentication/login
  
   Body
   {
      "username": "someone@somehting.com",
      "password":"123456"
   }
```


#### Administrators welcome service

```http
  GET http://localhost:8181/api/administrators/v1/welcome
```

#### Users welcome service

```http
  GET http://localhost:8181/api/users/v1/welcome
```

#### Guests welcome service

```http
  GET http://localhost:8181/api/guests/v1/welcome
```

### Thanks for reading me!