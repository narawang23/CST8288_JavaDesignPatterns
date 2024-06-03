package com.algonquin.cst8288.assignment1.controller;

import com.algonquin.cst8288.assignment1.employee.Employee;
import com.algonquin.cst8288.assignment1.persistence.Formatter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PersistenceService {
    private Formatter formatter;

    public PersistenceService() {
    }

    public PersistenceService(Formatter formatter) {
        this.formatter = formatter;
    }

    /**
     * Write data into file but it violates DIP
     *
     * @param employee
     * @throws IOException
     */
    public void saveEmployee(Employee employee, String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(formatter.format(employee));
            writer.flush();
        }
    }
}