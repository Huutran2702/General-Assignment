package candidate.app.utils;

import candidate.app.Main;
import org.apache.log4j.*;
import org.apache.log4j.spi.LoggingEvent;

import java.io.File;
import java.io.IOException;

public class WriteLogUtils {

    public static Logger setLogger(String fileName, String className) {
        Logger logger = Logger.getLogger(className);
        PatternLayout layout = new PatternLayout();
        layout.setConversionPattern("%d{yyyy-MM-dd HH:mm:ss} %-5p - %m%n");
        RollingFileAppender appender = null;
        try {
            appender = new RollingFileAppender(layout,fileName,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addAppender(appender);
        return logger;
    }

}
