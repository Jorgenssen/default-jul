package pt.jorgenssen.defaultjul.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private static final Properties prop = new Properties();

    static {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("logging.properties");
        if (stream != null) {
            try {
                prop.load(stream);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load logging.properties configuration file", e);
            }
        }
    }

    public static Properties getProperties() {
        return prop;
    }
}
