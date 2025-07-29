package pt.jorgenssen.defaultjul.configuration;

public class Parameters {
    private Parameters() {}

    public static final String CUSTOM_FORMATTER_FORMAT_LINE = "%2$-7s %1$tF %1$tT [%3$s] %4$s - %6$s %n%7$s";
    public static final String CUSTOM_FORMATTER_FORMAT_PROPERTY = "java.util.logging.CustomFormatter.format";
    public static final String DEFAULT_LOG_FILE_PATH = "default_app.log";
    public static final String DEFAULT_LOG_FILE_PATH_PROPERTY = "java.util.logging.FileHandler.pattern";
}
