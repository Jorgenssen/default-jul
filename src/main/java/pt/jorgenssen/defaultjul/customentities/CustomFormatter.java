package pt.jorgenssen.defaultjul.customentities;

import pt.jorgenssen.defaultjul.configuration.Parameters;
import pt.jorgenssen.defaultjul.configuration.PropertiesLoader;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {


    public CustomFormatter() {}

    @Override
    public String format(LogRecord record) {

        var dateTime = ZonedDateTime.ofInstant(record.getInstant(), ZoneId.systemDefault());

        // Use record.getLongThreadID in Java 16 and later
        long threadId = record.getLongThreadID();
        String threadName = getThread(threadId)
                .map(Thread::getName)
                .orElse("Thread with ID " + threadId);

        // See also: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Formatter.html
        var formatString = PropertiesLoader.getProperties()
                .getProperty(
                        Parameters.CUSTOM_FORMATTER_FORMAT_PROPERTY,
                        Parameters.CUSTOM_FORMATTER_FORMAT_LINE
                );

        return String.format(
                formatString,
                dateTime,
                record.getLevel().getName(),
                threadName,
                record.getSourceClassName(),
                record.getSourceMethodName(),
                record.getMessage(),
                stackTraceToString(record)
        );
    }

    private static String stackTraceToString(LogRecord record) {
        final String throwableAsString;
        if (record.getThrown() != null) {
            var stringWriter = new StringWriter();
            var printWriter = new PrintWriter(stringWriter);
            printWriter.println();
            record.getThrown().printStackTrace(printWriter);
            printWriter.close();
            throwableAsString = stringWriter.toString();
        } else {
            throwableAsString = "";
        }
        return throwableAsString;
    }

    static Optional<Thread> getThread(long threadId) {
        Set<Thread> threads = Thread.getAllStackTraces().keySet();
        return threads.stream()
                .filter(t -> t.getId() == threadId)
                .findFirst();
    }
}
