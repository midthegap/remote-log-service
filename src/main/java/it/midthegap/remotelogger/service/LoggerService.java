package it.midthegap.remotelogger.service;

import it.midthegap.remotelogger.resource.LogLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {

    private Logger logger = LoggerFactory.getLogger(LoggerService.class);

    public void logit(int priority, String tag, String message) {
        LogLevel level = LogLevel.from(priority);

        switch (level) {
            case TRACE -> trace(tag, message);
            case DEBUG -> debug(tag, message);
            case INFO -> info(tag, message);
            case WARN -> warn(tag, message);
            case ERROR -> error(tag, message);
            default -> debug(tag, message);
        }
    }

    protected void error(String tag, String message) {
        if (tag != null) {
            logger.error("{}-{}", tag, message);
        } else {
            logger.error(message);
        }
    }

    protected void warn(String tag, String message) {
        if (tag != null) {
            logger.warn("{}-{}", tag, message);
        } else {
            logger.warn(message);
        }
    }

    protected void info(String tag, String message) {
        if (tag != null) {
            logger.info("{}-{}", tag, message);
        } else {
            logger.info(message);
        }
    }

    protected void debug(String tag, String message) {
        if (tag != null) {
            logger.debug("{}-{}", tag, message);
        } else {
            logger.debug(message);
        }
    }

    protected void trace(String tag, String message) {
        if (tag != null) {
            logger.trace("{}-{}", tag, message);
        } else {
            logger.trace(message);
        }
    }

}
