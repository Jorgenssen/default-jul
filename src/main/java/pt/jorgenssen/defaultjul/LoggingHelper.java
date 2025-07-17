package pt.jorgenssen.defaultjul;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LoggingHelper {

    static final Level ERROR = new CustomLevel("ERROR", 1000);
    static final Level DEBUG = new CustomLevel("DEBUG", 700);


    private final Logger logger;
    private final String className;

    private LoggingHelper(String className) {
        this.className = className;
        this.logger = Logger.getLogger(className);
        logger.setUseParentHandlers(false);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.FINEST);
        ch.setFormatter(new CustomFormatter());

        logger.addHandler(ch);
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
