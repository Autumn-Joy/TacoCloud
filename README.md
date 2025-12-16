# TacoCloud
A full-stack Spring Boot web app built alongside *Spring in Action, Sixth Edition* to explore the Spring ecosystem.

## Notes from during building:

### Manually running & testing the project

This project uses Maven. 
To test and build manually, run:
```aiignore
./mvnw spring-boot:run
```

This project uses JUnit tests. The command for running tests is:
``` 
./mvnw test
```

### Building the homepage

- a controller class that handles requests for the home page
- a view template that defines what the home page looks like
- a simple test class to test the home page
