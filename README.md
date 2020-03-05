# private-spring-backend
Spring MVC web application for sharing homeworks and projects.
## Description

Will be added :)

## Tools & Frameworks

The application is written using Spring MVC framework and maven (for external dependency managment).

**Database & configuration**
* MySQL
* maven
* Tomcat
* Git


**Backend technologies**
* Java
* Spring MVC, Spring Boot, Spring Security
* Hibernate ORM, Hibernate Validator, JPA
* JUnit
* Project Lombok


**Frontend technologies**
* HTML, CSS, JavaScript
* JSP, JSTL
* Bootstrap 4

## How to run it?

Prerequisites: Intellij IDE ([with Gradle and Tomcat plugin installed]

1. Clone this git repository

` $ git clone https://github.com/mahtab2/private-spring-backend.git `

2. Open MySQL Workbench and type following SQL script:

```
DROP DATABASE  IF EXISTS `spring`;
CREATE DATABASE  IF NOT EXISTS `spring`;
USE `spring`;

 ```
 3.Change email and password in application.property file
 
 4. Run `tomcatRun` 
 
 5. The application will avaialble under URL `http://localhost:8050/index`
