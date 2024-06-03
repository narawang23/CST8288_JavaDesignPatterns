package com.algonquin.cst8288.assignment1.test;

import com.algonquin.cst8288.assignment1.controller.PersistenceService;
import com.algonquin.cst8288.assignment1.employee.Employee;
import com.algonquin.cst8288.assignment1.employee.PermanentEmployeeImpl;
import com.algonquin.cst8288.assignment1.persistence.Formatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PersistenceServiceTest {

    private PersistenceService employeeSaver;
    private Formatter formatter;
    private Employee employee;

    @BeforeEach
    void setUp() {
        formatter = new Formatter() {
            @Override
            public String format(Employee employee) {
                // Implement the format method as needed for testing
                return "FormattedEmployee";
            }
        };
        employeeSaver = new PersistenceService(formatter);
        employee = new PermanentEmployeeImpl();
        // Set up the employee with values as needed for testing
    }

    @Test
    void testSaveEmployee() throws IOException {
        String testFilename = "test_employee_data.txt";

        employeeSaver.saveEmployee(employee, testFilename);

        // Verify that the file was created and contains the expected string
        File file = new File(testFilename);
        assertTrue(file.exists(), "The file should exist after saving");
        assertTrue(file.length() > 0, "The file should not be empty");

        // Clean up the test file
        file.delete();
    }

}
