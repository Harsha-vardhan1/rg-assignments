# Spring + Maven + Spring Boot Assignment

## Question 1: Install Maven 3.6 or above and verify with `mvn -v`

To install Maven, I downloaded version 3.8.x and configured environment variables.  
After setup, I ran the following command:

```bash
mvn -v
Successfully installed Maven using IntelliJ IDEA. Below is the output of the Maven version:

![Maven Version](./maven-version.png)## Question 2: What is the difference between Maven Central Repository and Local Repository?

Maven uses two types of repositories to manage dependencies:  
**Maven Central Repository** and **Local Repository**.

- **Maven Central Repository** is an online repository maintained by the Maven community that hosts publicly available libraries and artifacts.
- **Local Repository** is a local folder (usually located at `~/.m2/repository`) where Maven stores downloaded dependencies for offline use.
- During a build, Maven first looks for dependencies in the **local repository**; if not found, it downloads them from the **central repository**.

This mechanism helps in optimizing build time and reducing repeated downloads.
