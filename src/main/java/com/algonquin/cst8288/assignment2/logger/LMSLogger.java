package com.algonquin.cst8288.assignment2.logger;

import java.util.logging.*;

public class LMSLogger {
    private static LMSLogger instance = null;
    private Logger logger;

    private LMSLogger() {
        this.logger = Logger.getLogger(LMSLogger.class.getName());
    }

    public static synchronized LMSLogger getInstance() {
        if (instance == null) {
            instance = new LMSLogger();
        }
        return instance;
    }

    public void log(Level level, String message) {
        logger.log(level, message);
    }

    public void log(Level level, String message, Throwable thrown) {
        logger.log(level, message, thrown);
    }
}