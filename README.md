# spring-boot-hateos

This is a fork of https://github.com/msoni89/spring-boot-hateos

[Spring Boot]: https://spring.io/projects/spring-boot

## Features

* Returns hateos links for paginated pincode list.
* Returns pin code details by `ID`.

## Supported versions

* Java 8
* Spring Boot 2.4.2
* Maven 3.x

## Usage


## Configuration properties

These can be configure by your "application.properties".  

```yml
    spring.datasource.url=jdbc:h2:mem:pin_code
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    spring.jpa.hibernate.ddl-auto=none
```

## Building and testing

To build and test, you can run:  

```sh
$ cd spring-boot-hateos
$ mvn clean install package
```
## Launch application

To build and test, you can run:  

```sh
$ cd spring-boot-hateos
$ mvn clean install package
$ mvn spring-boot:run
```
## Logs

```log
2021-02-06 22:19:49.782  INFO 169739 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2021-02-06 22:19:49.928  INFO 169739 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-02-06 22:19:50.102  INFO 169739 --- [           main] c.s.p.SpringBootStarterParentApplication : Started SpringBootStarterParentApplication in 4.538 seconds (JVM running for 4.906)
```

## Details

* Port: 8080
* Database: h2

## API Documentaion
* Swagger URL: http://localhost:8080/swagger-ui/index.html

## Curl Command

* curl http://localhost:8080/api/pin-code-list?page=0&size=1&sort=state,desc
```json
{
   "_embedded":{
      "pinCodes":[
         {
            "id":32934,
            "pinCode":700001,
            "postOfficeName":"Ananda Bazar Patrika",
            "city":"Kolkata",
            "district":"Calcutta",
            "state":"West Bengal",
            "_links":{
               "self":{
                  "href":"http://localhost:8080/api/pin-code/id/32934"
               }
            }
         }
      ]
   },
   "_links":{
      "first":{
         "href":"http://localhost:8080/api/pin-code-list?page=0&size=1&sort=state,desc"
      },
      "self":{
         "href":"http://localhost:8080/api/pin-code-list?page=0&size=1&sort=state,desc"
      },
      "next":{
         "href":"http://localhost:8080/api/pin-code-list?page=1&size=1&sort=state,desc"
      },
      "last":{
         "href":"http://localhost:8080/api/pin-code-list?page=39731&size=1&sort=state,desc"
      }
   },
   "page":{
      "size":1,
      "totalElements":39732,
      "totalPages":39732,
      "number":0
   }
}
```

* curl http://localhost:8080/api/pin-code/id/32934

```json
{
   "id":32934,
   "pinCode":700001,
   "postOfficeName":"Ananda Bazar Patrika",
   "city":"Kolkata",
   "district":"Calcutta",
   "state":"West Bengal",
   "_links":{
      "self":{
         "href":"http://localhost:8080/api/pin-code/id/32934"
      }
   }
}
```




