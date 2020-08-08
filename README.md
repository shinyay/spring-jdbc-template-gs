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

## Demo
### Run MySQL Container
```shell script
$ docker container run --rm --name mysqldb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=appdb -d mysql
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
