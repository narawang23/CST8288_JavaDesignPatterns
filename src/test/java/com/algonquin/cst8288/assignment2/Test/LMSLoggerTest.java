package com.algonquin.cst8288.assignment2.Test;

import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LMSLoggerTest {
    private LMSLogger logger = LMSLogger.getInstance();

    @Test
    void testSingletonInstance() {
        LMSLogger instance1 = LMSLogger.getInstance();
        LMSLogger instance2 = LMSLogger.getInstance();
        assertEquals(instance1, instance2, "Only one instance should be created");
    }

    @Test
    void testLogMethods() {
        // Test INFO level
        logger.log(Level.INFO, "This is an info message");

        // Test WARNING level
        logger.log(Level.WARNING, "This is a warning message");

        // Test ERROR level
        logger.log(Level.SEVERE, "This is an error message", new Exception("Test Exception"));


    }
}