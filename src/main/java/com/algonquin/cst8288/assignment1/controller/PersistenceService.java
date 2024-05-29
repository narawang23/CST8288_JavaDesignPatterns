package com.algonquin.cst8288.assignment1.controller;

import com.algonquin.cst8288.assignment1.employee.Employee;
import com.algonquin.cst8288.assignment1.persistence.Formatter;
import com.algonquin.cst8288.assignment1.persistence.JSONFormatter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PersistenceService {
    public PersistenceService(JSONFormatter jsonFormatter) {
    }

    /**
     * Write data into file but it violates DIP
     *
     * @param person
     * @throws IOException
     */
    public void saveEmployee(Employee person, String filename) throws IOException {
        Formatter formatter = new JSONFormatter();
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(formatter.format(person));
            writer.flush();
        }
    }
}