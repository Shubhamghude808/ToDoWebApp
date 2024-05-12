# Todo Web App

This is a Todo Web application built using Spring MVC, Spring Boot, Spring Security, JPA, JSP, and Maven for project building. It supports different datastores including a static local list, H2 database, and MySQL and contained using Docker.

## Features

- User Authentication and Authorization with Spring Security
- CRUD operations for managing todos
- Multiple data storage options

## Prerequisites

Before running the application, make sure you have the following installed:

- Java Development Kit (JDK)
- Maven
- MySQL Server (optional, if you want to use MySQL)
- Docker (if you use MySQL database)

## Getting Started

Follow these steps to get the project up and running on your local machine:

1. Clone this repository:

    ```bash
    git clone https://github.com/Shubhamghude808/ToDoWebApp.git
    ```

2. Navigate to the project directory:

    ```bash
    cd ToDoWebApp
    ```

3. Build the project using Maven:

    ```bash
    mvn clean package
    ```

4. Run the application:

    ```bash
    java -jar target/ToDoWebApp-1.0.0.jar
    ```

5. Access the application in your browser:

    [http://localhost:8080](http://localhost:8080)

## Configuration

### Datastore Configuration

By default, the application uses a static local list for storing todos. If you want to use H2 database or MySQL, you can configure the datasource properties in the `application.properties` file located in `src/main/resources`.

#### H2 Database

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

## Usage of H2 Database / Static list
- Log in using the default credentials:
- Username: Shubham/Anish
- Password: 1/anish
- You can now manage your todos: create, read, update, and delete.

#### MySQL Database

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

## Usage of MySQL Database
- Navigate to http://localhost:3306 in your browser.
- Log in using the default credentials:
- Username: todos-user
- Password: dummytodos
- You can now manage your todos: create, read, update, and delete.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
