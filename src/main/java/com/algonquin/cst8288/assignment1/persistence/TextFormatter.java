package com.algonquin.cst8288.assignment1.persistence;

import java.io.IOException;

import com.algonquin.cst8288.assignment1.employee.Employee;

/**
 * An implementation for formatting the data in plain text format.
 */
public class TextFormatter implements Formatter {

    /**
     * The method processes the Employee object and extracts the attributes
     * in a key-value pair format.
     *
     * @param employee the Employee object to be formatted.
     * @return a String representation of the Employee in key-value format.
     * @throws IOException if an input/output error occurs.
     */
    @Override
    public String format(Employee employee) throws IOException {
        if (employee == null) {
            throw new IOException("Employee object cannot be null");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("name=").append(employee.getName()).append(", ");
        sb.append("email=").append(employee.getEmail());
        return sb.toString();
    }

}