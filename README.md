## Spring Boot MVC Application 

Thymeleaf template is filled at startup by document entities stored in mongodb database configured by application properties.
Entry Url is `localhost:8080`.

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

    `docker exec -it mongodb bash`
    
and execute queries:    

    Starting mongo client by `mongo`
     
    Change database by `use custom`
    
    Execute query by `db.persons.find()`. 

   