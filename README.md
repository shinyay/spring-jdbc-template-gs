# Spring Jdbc Template Getting Started

Database Access using Spring JDBC Template

## Description
Spring provides a template class called `JdbcTemplate` that makes it easy to work with SQL relational databases and JDBC.

### CommandLineRunner
This Application class implements Spring Boot’s `CommandLineRunner`, which means it will execute the run() method after the application context is loaded.

### JdbcTemplate Function
- execute
- update
- batchUpdate
- query / queryForXXX

### Configuration MySQL
- spring:
  - datasource:
    - url: jdbc:mysql://${MYSQL_HOST:localhost}:3306/appdb?allowPublicKeyRetrieval=true&useSSL=false
      - Connection String to MySQL DB
    - username: root
      - Access User to MySQL
    - password: root
      - Access Password
    - driver-class-name: com.mysql.cj.jdbc.Driver
      - MySQL Driver
      - since 8.x : `com.mysql.cj.jdbc.Driver`
      - before 8.x: `com.mysql.jdbc.Driver`
    - schema: classpath:database/schema.sql
      - Path for Schema file at initialization
    - data: classpath:database/data.sql
      - Path for Data file at initialization
    - initialization-mode: always

## Demo
### Run MySQL Container
```shell script
$ docker container run --rm --name mysqldb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=appdb -d mysql
```

### Run Spring Application
```shell script
$ ./gradlew clean bootRun
```

### Confirm MySQL Container
#### Access MySQL Container
```shell script
$ docker exec -it mysqldb bash
```

#### Connect to MySQL
```shell script
# mysql -u root -p
Enter password:<root>

Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 45
Server version: 8.0.21 MySQL Community Server - GPL

Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql>
```

#### Query Data
```shell script
mysql> use appdb
mysql> show tables;
mysql> select * from children;
```

## Features

- CommandLineRunner
- JdbcTemplate

## Requirement

## Usage

## Installation

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
