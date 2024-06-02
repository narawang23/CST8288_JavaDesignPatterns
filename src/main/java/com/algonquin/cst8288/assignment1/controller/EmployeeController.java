package com.algonquin.cst8288.assignment1.controller;
import java.io.IOException;
import com.algonquin.cst8288.assignment1.employee.Employee;

/**
 * Process, validate and save employee data.
 */
public class EmployeeController {
    private final EmployeeProcessor employeeProcessor;
    private final EmployeeValidator validator;
    private final EmployeeSaver storage;

    public EmployeeController(EmployeeProcessor employeeProcessor, EmployeeValidator validator, EmployeeSaver storage) {
        this.employeeProcessor = employeeProcessor;
        this.validator = validator;
        this.storage = storage;
    }

    /**
     * Orchestrates the processing, validation, and storage of employee data.
     *
     * @param employee the employee object to be processed
     * @return "SUCCESS" if the employee data is processed and stored successfully,
     *         "FAILED" if the validation fails
     * @throws IOException if an I/O error occurs during the storage process
     */
    public String handleEmployee(Employee employee, String fileName) throws IOException {
        // Process data (e.g., Calculate bonus, total compensation, etc.)
        employeeProcessor.processEmployee(employee);

        // Validate data
        if (!validator.isValidEmployee(employee)) {
            return "FAILED";
        }

        // Store data
        storage.saveEmployee(employee, "employee_data.txt");
        return "SUCCESS";
    }

}