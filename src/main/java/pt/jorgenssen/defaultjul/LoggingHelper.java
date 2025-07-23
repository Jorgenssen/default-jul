package pt.jorgenssen.defaultjul;

import java.io.IOException;
import java.util.logging.*;

public class LoggingHelper {

    private static final Level ERROR = new CustomLevel("ERROR", 1000);
    private static final Level DEBUG = new CustomLevel("DEBUG", 700);


    private final Logger logger;
    private final String className;

    private LoggingHelper(String className) {
        this.className = className;
        this.logger = Logger.getLogger(className);
        logger.setUseParentHandlers(false);

        CustomFormatter formatter = new CustomFormatter();

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.FINEST);
        ch.setFormatter(formatter);

        FileHandler fh;
        try {
            fh = new FileHandler("default_app.log", true);
        } catch (IOException e) {
            throw new RuntimeException("Failed to create file handler for log file 'default_app.log'", e);
        }
        fh.setFormatter(formatter);
        fh.setLevel(Level.FINEST);

        logger.addHandler(ch);
        logger.addHandler(fh);
        logger.setLevel(Level.FINEST);
    }

    public static LoggingHelper getLogger(String className) {
        return new LoggingHelper(className);
    }

    public void info(String msg) {
        log(Level.INFO, msg);
    }

    public void warn(String msg) {
        log(Level.WARNING, msg);
    }

    public void debug(String msg) {
        log(DEBUG, msg);
    }

    public void error(String msg) {
        log(ERROR, msg);
    }

    private void log(Level level, String msg) {
        LogRecord logRecord = new LogRecord(level, msg);
        logRecord.setSourceClassName(className);
        logger.log(logRecord);
    }
}
