# default-jul
The most default JUL (java util logging) wrapper implementation, no configs, just import and go.  
Currently only console logging is available with four the most essential log levels (`info`, `debug`, `warning` and `error`).

### Add dependency
```xml
<dependency>
    <groupId>pt.jorgenssen</groupId>
    <artifactId>defaultjul</artifactId>
    <version>0.0.1</version>
</dependency>
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
```text
DEBUG   2025-07-17 22:20:51 [main] pt.jorgenssen.Main - Print debug message 
INFO    2025-07-17 22:20:51 [main] pt.jorgenssen.Main - Print info message 
WARNING 2025-07-17 22:20:51 [main] pt.jorgenssen.Main - Print warning message 
ERROR   2025-07-17 22:20:51 [main] pt.jorgenssen.Main - Print error message 
```
