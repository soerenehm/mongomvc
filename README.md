## Spring Boot MVC Application 

Thymeleaf template is filled at startup by document entities stored in mongodb database configured by application properties.

Following dependencies are used: 

### Application
- Web
- MongoDB
- Lombok
- Thymeleaf

### Metrics
- Activator [http://localhost:8080/actuator](http://localhost:8080/actuator)
- HAL Browser [http://localhost:8080/browser/index.html#/actuator](http://localhost:8080/browser/index.html#/actuator)

### Development
- Devtools

## Swagger
- Swagger API [http://localhost:8080/v2/api-docs](http://localhost:8080/v2/api-docs)

 
### Use Docker Compose for creating Spring Boot Application with MongoDB

In parent folder `make` creates two docker container named 

* mongomvc (Spring Boot MVC Application)

* mongodb (MongoDB)

and run tests afterwards.

Attach to mongodb container:

```sh-session
$ docker exec -it mongodb bash 
```
    
and execute queries:

```sh-session
$ mongo # Starts mongo client
$ use custom # Change database
$ db.persons.find() # Execute query
```

   
[![Build Status](https://travis-ci.org/soerenehm/mongomvc.svg?branch=master)](https://travis-ci.org/soerenehm/mongomvc.svg?branch=master)   
