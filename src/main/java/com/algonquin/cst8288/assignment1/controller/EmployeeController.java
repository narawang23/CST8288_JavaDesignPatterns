package com.algonquin.cst8288.assignment1.controller;

import java.io.IOException;

import com.algonquin.cst8288.assignment1.employee.Employee;
import com.algonquin.cst8288.assignment1.persistence.JSONFormatter;

/**
 * Process, validate and save employee data.
 */
public class EmployeeController {

    private final EmployeeValidator validator;
    private final EmployeeSave storage;

    public EmployeeController() {
        this.validator = new EmployeeValidator();
        this.storage = new EmployeeSave(new JSONFormatter());
    }

    /**
     * Orchestrates the processing, validation, and storage of employee data.
     *
     * @param employee the employee object to be processed
     * @return "SUCCESS" if the employee data is processed and stored successfully,
     *         "FAILED" if the validation fails
     * @throws IOException if an I/O error occurs during the storage process
     */
    public String processEmployee(Employee employee) throws IOException {
        // Process data (e.g., Calculate bonus, total compensation, etc.)







        // Validate data
        if (!validator.isValidEmployee(employee)) {
            return "FAILED";
        }

        // Store data
        storage.saveEmployee(employee, "employee_data.txt");
        return "SUCCESS";
    }

}