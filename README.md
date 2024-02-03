# Sample Spring API Validation Project

> This project demonstrates some API validation patterns for Spring Boot Web Applications.

This project accompanies my blog post: [Validating Requests in Spring Boot 3](https://marcdenning.com/posts/2024/02/3/validating-requests-with-spring-boot-3/).  
It supersedes and builds on [Validating Requests in Spring Boot](https://marcdenning.com/posts/2020/02/11/validating-requests-in-spring-boot/) which was written for Spring Boot 2.
If you are looking for a reference for validation in Spring Boot 2, please check out the [`release/spring-boot-2`](https://github.com/marcdenning/spring-api-validation-sample/tree/release/spring-boot-2) branch of this repo.

## Getting started

The sample application is built with Gradle and uses the [Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html) to ensure a consistent build environment.
Build the Spring Boot application with the following command:

```bash
./gradlew clean build
```

## Technology in use

* Java 21
* JUnit 5
* Spring Boot 3
* Hibernate Validator 8
* Gradle 8.5
