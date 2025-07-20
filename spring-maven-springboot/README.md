_# Spring + Maven + Spring Boot Assignment

## Question 1: Install Maven 3.6 or above and verify with `mvn -v`

To install Maven, I downloaded version 3.8.x and configured environment variables.  
After setup, I ran the following command:

```bash
mvn -v
Successfully installed Maven using IntelliJ IDEA. Below is the output of the Maven version:

![Maven Version](./maven-version.png)




## Question 2: What is the difference between Maven Central Repository and Local Repository?

Maven uses two types of repositories to manage dependencies:  
**Maven Central Repository** and **Local Repository**.

- **Maven Central Repository** is an online repository maintained by the Maven community that hosts publicly available libraries and artifacts.
- **Local Repository** is a local folder (usually located at `~/.m2/repository`) where Maven stores downloaded dependencies for offline use.
- During a build, Maven first looks for dependencies in the **local repository**; if not found, it downloads them from the **central repository**.

This mechanism helps in optimizing build time and reducing repeated downloads._



### Question 3: Common Maven Commands

Below are some essential Maven commands used to build and test Maven projects:

- **To build the Maven project**  
  This command compiles the code, runs tests, and packages the project (typically into a JAR or WAR file):

  ```bash
  mvn clean install
To run the Maven tests separately
This command runs all the test cases in the project:
mvn test'''




Please locate the maven settings.xml file and local maven repository in your machine and share the screenshot
Ans:Maven settings.xml commonly used to define the local repository.The **`settings.xml`** file is used to configure
 Maven settings like proxies, repository locations, credentials, etc. It is usually found in the following location:
~/.m2/settings.xml

The **Local Maven Repository** is the folder where Maven stores all the downloaded dependencies. By default, it is located at:

~/.m2/repository
Below is a screenshot showing the `settings.xml` file and the local Maven repository location on my machine:

![Maven Settings and Local Repo](./maven-settings-repo.png)




Question 5: What are the different ways in which an object can define its dependency in Dependency Injection (DI)?

The basic principle behind **Dependency Injection (DI)** is that objects define their dependencies, and those dependencies are provided externally rather than the object creating them itself.

There are three common ways to define dependencies in DI:

1. **Constructor Injection**
   - Dependencies are passed through the class constructor.
   - Recommended for mandatory dependencies.
   - Example:
     ```java
     public class UserService {
         private final UserRepository userRepository;

         public UserService(UserRepository userRepository) {
             this.userRepository = userRepository;
         }
     }
     ```

2. **Setter Injection**
   - Dependencies are set using public setter methods.
   - Useful for optional dependencies.
   - Example:
     ```java
     public class UserService {
         private UserRepository userRepository;

         public void setUserRepository(UserRepository userRepository) {
             this.userRepository = userRepository;
         }
     }
     ```

3. **Field Injection**
   - Dependencies are injected directly into the fields using annotations (e.g., `@Autowired` in Spring).
   - Quick to use, but not recommended for testing and immutability.
   - Example:
     ```java
     public class UserService {
         @Autowired
         private UserRepository userRepository;
     }
     ```





---

### Question 6: What is the difference between `@Autowired` and `@Inject` annotations?

The `@Autowired` annotation belongs to the Spring Framework, whereas `@Inject` is a part of the standard Java specification provided by JSR-330. Both are used for Dependency Injection in Java applications, allowing objects to declare their dependencies so that the framework can inject them at runtime.

`@Autowired` is specific to Spring and offers additional features such as the `required` attribute, which allows marking a dependency as optional. For example, `@Autowired(required = false)` tells Spring to inject the dependency if it's available, but not to throw an error if it isn’t.

On the other hand, `@Inject` is a standard Java annotation, meaning it can be used with any dependency injection framework that adheres to JSR-330 (like Google Guice or Spring itself). However, it does not offer the same level of customization as `@Autowired`—there is no built-in option to declare a dependency as optional.

In practice, both annotations work similarly in a Spring application, but `@Autowired` is preferred when you're fully committed to the Spring ecosystem, while `@Inject` may be used if you want your code to remain framework-agnostic and portable across different DI frameworks.





### Question 7: Explain the use of `@Repository`, `@Component`, `@Service`, and `@Controller` annotations with an example for each.

In Spring Framework, annotations like `@Component`, `@Service`, `@Repository`, and `@Controller` are used to define Spring-managed components and help Spring recognize them during component scanning. All of these are specializations of the `@Component` annotation and are used to indicate the role of a class in the application architecture.

##### `@Component`
`@Component` is a generic stereotype annotation used to define a Spring bean. It's a general-purpose annotation for any class that should be managed by the Spring container.

**Example:**
```java
@Component
public class UtilityService {
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

@Service

@Service is used to annotate classes that perform business logic or service tasks. It indicates that the class holds the business logic layer in a typical 3-layer architecture.
@Service
public class OrderService {
    public void placeOrder() {
        System.out.println("Order placed.");
    }
}

@Repository

@Repository is used for Data Access Object (DAO) classes that interact with the database. It also enables automatic exception translation from persistence-related exceptions to Spring’s DataAccessException.

@Repository
public class ProductRepository {
    public List<String> getAllProducts() {
        return Arrays.asList("Apple", "Banana", "Cherry");
    }
}

@Controller

@Controller is used to define a web controller class that handles HTTP requests in a Spring MVC application.

@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String homePage() {
        return "index"; // returns a view name
    }
}


8.Fix the code and explain why?
The following code tries to inject a property from application.properties, but the appName field is always null. Identify and fix the issue.
@Component
public class AppNamePrinter {
	@Value("app.name")
     private String appName;
 
	public void printAppName() {
     	System.out.println("Application Name: " + appName);
 	}
 }

ans:You're passing "app.name" as a literal string, so Spring will inject the string "app.name" instead of resolving the value from application.properties.

As a result, appName will either be:

"app.name" (a literal string), or
null if it can't convert it (which is common if no default is set and resolution fails silently depending on context)
@Component
public class AppNamePrinter {

    @Value("${app.name}")
    private String appName;

    public void printAppName() {
        System.out.println("Application Name: " + appName);
    }
}
Explanation
@Value("${app.name}") tells Spring to inject the value of the property named app.name from your application.properties file.
@Value("app.name") (what you had) is just a literal string, and it doesn’t do any placeholder resolution.
 Make Sure:
Your application.properties (or application.yml) contains:
app.name=MySpringApp
And that component scanning and property resolution are enabled (which they typically are by default in a Spring Boot app)

What does the @SpringBootApplication annotation do?
The @SpringBootApplication annotation is a convenience annotation in Spring Boot that combines several key Spring annotations to simplify configuration and bootstrapping of a Spring application.
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
The @SpringBootApplication annotation is equivalent to using:
@Configuration
@EnableAutoConfiguration
@ComponentScan
Breakdown of its components:
@Configuration
Marks the class as a source of bean definitions — like a Java-based configuration class.
@EnableAutoConfiguration
Tells Spring Boot to automatically configure the application based on the dependencies present in the classpath (e.g., it configures an embedded Tomcat server if spring-boot-starter-web is found).
@ComponentScan
Enables component scanning so that Spring can discover beans (@Component, @Service, @Repository, @Controller, etc.) in the same package or sub-packages.
With @SpringBootApplication, you can create a Spring Boot application without having to manually add @Configuration, @EnableAutoConfiguration, and @ComponentScan separately.

@SpringBootApplication
public class DemoApp {
    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class, args);
    }
}
This single annotation simplifies Spring Boot application setup and is placed on the main class of your app.