# TacoCloud
A full-stack Spring Boot web app built alongside *Spring in Action, Sixth Edition* to explore the Spring ecosystem.

## Notes from building:

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

## Ch. 1: Building the homepage
### **The MVC pattern & basic Spring project structure**

- a controller class that handles requests for the home page
- a view template that defines what the home page looks like
- a simple test class to test the home page

## Ch. 2: Display model data and process form input

### **pt. 1**: the designTaco page 
- a controller that handles `GET` and `POST` for `/design`
- the `/design` view, a form using Thymeleaf for data binding [`th:*`] etc.
- a converter that takes a string from the form and returns the corresponding `Ingredient`

### **pt. 2:** validation 
- `@NotBlank`, `@Valid`, etc.

## Ch. 3: Connecting to a database 

- chose to use PostgreSQL instead of H2 for persistence across restarts
  - as well as for experience connecting an external database to a Spring Boot app
- defined the repository layer
  - defined an `IngredientRepository`, extends `CrudRepository`
  - defined a `OrderRepository`, extends `CrudRepository`
  - refactored db schema to use many-to-one relationship between `Taco` and `Order` istead of One-to-Many
- updated controllers to use new repositories
  - `DesignTacoController` now saves tacos with ingredients
  - `OrderController` saves orders with the tacos and their ingredients