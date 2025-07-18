# default-jul
The most default JUL (java util logging) wrapper implementation, no configs, just import and go.  
Currently console and file logging are available with four the most essential log levels (`info`, `debug`, `warning` and `error`).

> **_NOTE:  This small lib is only for local projects or local debug purposes_**

### Add dependency and declare Github repo
[Working with the Apache Maven registry](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry)    
*Maven settings.xml*
```xml
  <profiles>
    <profile>
      <id>github</id>
      <repositories>
        <repository>
          <id>central</id>
          <url>https://repo.maven.apache.org/maven2</url>
        </repository>
        <repository>
          <id>github</id>
          <url>https://maven.pkg.github.com/Jorgenssen/default-jul</url>
        </repository>
      </repositories>
    </profile>
  </profiles>

  <servers>
    <server>
      <id>github</id>
      <username>YOUR_GITHUB_NAME</username>
      <password>YOUR_GITHUB_PASSWORD</password>
    </server>
  </servers>

```

*Maven pom.xml*
```xml
<dependency>
    <groupId>pt.jorgenssen</groupId>
    <artifactId>defaultjul</artifactId>
    <version>0.0.1</version>
</dependency>
```

[Working with the Gradle registry](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry)    
*Gradle build.gradle*
```groovy
repositories {
    mavenCentral()
    maven {
        name = "github"
        url = uri("https://maven.pkg.github.com/Jorgenssen/default-jul")
        credentials {
            username = 'YOUR_GITHUB_NAME'
            password = 'YOUR_GITHUB_PASSWORD'
        }
    }
    mavenLocal()
}

dependencies {
    implementation "pt.jorgenssen:defaultjul:0.0.1"
}
```

### Instantiate `LoggingHelper`

```java
package pt.jorgenssen;

import pt.jorgenssen.defaultjul.LoggingHelper;

public class Main {

    private static final LoggingHelper LOGGER = LoggingHelper.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOGGER.debug("Print debug message");
        LOGGER.info("Print info message");
        LOGGER.warn("Print warning message");
        LOGGER.error("Print error message");
    }
}
```

### See the result
Console log
```text
DEBUG   2025-07-17 22:20:51 [main] pt.jorgenssen.Main - Print debug message 
INFO    2025-07-17 22:20:51 [main] pt.jorgenssen.Main - Print info message 
WARNING 2025-07-17 22:20:51 [main] pt.jorgenssen.Main - Print warning message 
ERROR   2025-07-17 22:20:51 [main] pt.jorgenssen.Main - Print error message 
```

File log (placed at project's root directory)
![img_gradle.png](img_gradle.png)
![img_maven.png](img_maven.png)
