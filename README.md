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

## Ch. 4: Connecting to a non-relational database

- prioritizing relational databases for this project. Proceeding to chapter 5.

## Ch. 5: Configuring Spring Security
- add Spring Security to the project with Maven
- configure Spring Security

Steps of configuring Spring Security:
- [1] Define a basic security class, `SecurityConfig`
  - Spring Security provides many password encoders, but for this project, we're using `BCryptPasswordEncoder`
  - principle: "The password in the database is never decoded."
  - `SecurityConfig` will serve as the main location for the security rules of the application
- [2] Define a basic `UserDetailService` interface
  - uses `UserDetailsService` from the Spring Security core library (the docs linked [here](https://docs.spring.io/spring-security/reference/api/java/org/springframework/security/core/userdetails/UserDetailsService.html))
- [3] the implementation `UserDetailsServiceImplementation` allows users to be found by their username, or returns an error if the user is not found

-  [4] Registration: 
  - Part 1: the controller: `RegistrationController` + `RegistrationFormDTO`
      - `RegistrationForm` is a Thymeleaf form that allows users to register for an account
      - `RegistrationFormDTO` is a data transfer object (DTO) that defines the fields in the registration form
      - `RegistrationFormDTO` defines the toUser() method, called by RegistrationController
      - `toUser()` takes in a passwordEncoder instance from the RegistrationController
      - `toUser()` uses that parameter to encode the password and create a User instance
      - `RegistrationController` handles the form submission and saves the user to the database
  - Part 2: the view
    - Thymeleaf template `registration.html` uses the fields as defined in `RegistrationFormDTO`
    - the form is submitted to `/register`
  - Part 3: the security rules
    - `SecurityConfig` defines the security rules for `/register`
    - Spring Security enables CSRF protection by default
  
  - Summary:
    - home, login, and register pages accessible without auth
    - register form properly stores new user in db
    - login flow properly locates user by username and compares password to hashed password stored in db

**quick tip:**
- For Spring Boot projects, put @Configuration classes in a subpackage, 
- not at the same level as the main application class, 
- to avoid "subtle bean scanning" issues.


Question:
  Since the book is using H2 and I'm using PostgreSQL, the security approach will be different?