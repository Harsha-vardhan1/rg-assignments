# Spring + Maven + Spring Boot Assignment

## Question 1: Install Maven 3.6 or above and verify with `mvn -v`

To install Maven, I downloaded version 3.8.x and configured environment variables.  
After setup, I ran the following command:

```bash
mvn -v
Successfully installed Maven using IntelliJ IDEA. Below is the output of the Maven version:

![Maven Version](./maven-version.png)
## Question 2: What is the difference between Maven Central Repository and Local Repository?

- **Maven Central Repository** is a remote repository maintained by the Maven community. It hosts a large collection of publicly available libraries and dependencies that can be downloaded over the internet when needed.
- **Local Repository**, on the other hand, is a directory on the developer’s machine (typically `~/.m2/repository`) where Maven caches downloaded dependencies for reuse in future builds.
- When building a project, Maven first checks the **local repository** for required dependencies. If not found, it fetches them from the **central repository** or other configured remote repositories and then stores them locally.
