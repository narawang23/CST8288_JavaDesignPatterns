package com.algonquin.cst8288.assignment2.Test;

import com.algonquin.cst8288.assignment2.database.DBConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectionTest {
    private DBConnection instance1;
    private DBConnection instance2;

    @BeforeEach
    void setUp() throws SQLException {
        instance1 = DBConnection.getInstance();
        instance2 = DBConnection.getInstance();
    }

    @Test
    void testSingletonInstance() {
        assertEquals(instance1, instance2, "Only one instance should be created");
    }

    @Test
    void testDatabaseConnection() {
        assertNotNull(instance1.getConnection(), "Database connection should be established");
    }

    @AfterEach
    void tearDown() throws SQLException {
        // Close the connection if it's open
        if (instance1 != null && !instance1.getConnection().isClosed()) {
            instance1.getConnection().close();
        }
    }
}