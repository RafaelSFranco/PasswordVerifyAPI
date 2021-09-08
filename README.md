# :: Password Verify API ::

Web API to validate if a password is valid or not!

The password considered valid must contain the requirements below:

* Nine or more characters
* At least 1 digit
* At least 1 lowercase letter
* At least 1 uppercase letter
* At least 1 special character
* Consider the following characters as special: !@#$%^&*()-+
* Do not have repeated characters within the set
* Does not have blank spaces


## About the application

This is a simple API for querying and processing strings, I tried to make it as simple as possible, using
Kotlin, a technology that I'm still learning, to learn and demonstrate my knowledge.

No information transmitted here is encrypted or even stored.

This application is a response to the exercise provided by the company **Iti Itaú Digital**.


## Technologies used

To build this API, I used the following technologies:

* [Gradle](https://gradle.org)
* [Kotlin](https://kotlinlang.org/)
* [Spring Boot](https://spring.io)


## API architecture

* application
    * web
      * controllers
      * exceptions
      * requests
      * responses
      * services

The routes are executed through the Controller classes, which calls the call execution in the Service layer, which 
contains the entire business rule.


## How to build the application

You can run the application in your IDE of choice. In my case, I used IntelliJ IDE to develop and
run the application.

Check if your IDE supports Kotlin language, you may need to install Kotlin dependencies for
be able to build the application.

After that, just run the **PasswordVerifyApplication.kt** class. The Application will be available through the
port 8080. Ex: http://localhost:8080

When building the application you will be able to access the Swagger documentation available through the
address: http://localhost:8080/swagger-ui.html

To verify and pass the unit and component tests, just build the **tests** directory by the IDE
or run Gradle's build command through the terminal: **gradlew clean build**


## Expected call and return example

Example call with the CURL below:

    curl --location --request POST 'http://localhost:8080/api/verify-pwd' \
        --header 'Content-Type: application/json' \
        --data-raw '{
        "password": "AbTp9!foF"
    }'

Example of expected return:

Return valid password:

    {
        "isValid": true
    }

Return invalid password:

    {
        "isValid": false
    }

## More information and references

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.4/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.4/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#using-boot-devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

