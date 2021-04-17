# Remote log service

REST service to log messages on the server.
Created to collect logging messages from mobile applications, and allow log 
analysis.

Service is created with a minimal Spring Boot application.
Logging is performed with logback, you can tweak the output in logback-spring.xml
configuration file.

The server use HTTPS but the certificate is self-signed, clients are required to
accept the certificate as valid.

## Build

Requirements:

* Java JDK 14+ 
* Maven 3

## Usage

Launch server app with:

mvn compile spring-boot:run

You will get a REST service with at following endpoint:

https://<SERVER ADDRESS>:8443/api/log
HTTP METHOD: POST
Expected parameters should be in the REQUEST BODY with media type 
application/x-www-form-urlencoded 
Parameter names: 

* priority (int),
* tag (String, optional),
* message (String)

Priority is one of

* 2 (TRACE)
* 3 (DEBUG)
* 4 (INFO)
* 5 (WARN)
* 6 (ERROR)

