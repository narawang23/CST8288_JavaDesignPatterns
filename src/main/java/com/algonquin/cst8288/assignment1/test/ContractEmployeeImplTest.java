package com.algonquin.cst8288.assignment1.test;

import com.algonquin.cst8288.assignment1.employee.ContractEmployeeImpl;
import com.algonquin.cst8288.assignment1.employee.Employee;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContractEmployeeImplTest {

    @Test
    public void testRenewalDate() {

        Employee employee = new Employee("John Doe", "john.doe@example.com", "123 Main St", 50000.0, LocalDate.of(2024, 6, 3));

        ContractEmployeeImpl contractEmployee = new ContractEmployeeImpl();


        contractEmployee.setRenewalDate(employee.getRenewalDate());


        LocalDate newRenewalDate = contractEmployee.renewalDate();


        assertEquals(LocalDate.of(2025, 6, 3), newRenewalDate);
    }

    @Test
    public void testTotalCompensation() {

        Employee employee = new Employee("John Doe", "john.doe@example.com", "123 Main St", 50000.0, LocalDate.of(2024, 6, 3));

        ContractEmployeeImpl contractEmployee = new ContractEmployeeImpl();

        double totalCompensation = contractEmployee.totalCompensation(employee);

        assertEquals(50000.0, totalCompensation);
    }

}
