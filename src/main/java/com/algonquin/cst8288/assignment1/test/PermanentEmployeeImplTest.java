package com.algonquin.cst8288.assignment1.test;

import com.algonquin.cst8288.assignment1.employee.Employee;
import com.algonquin.cst8288.assignment1.employee.PermanentEmployeeImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermanentEmployeeImplTest {

    @Test
    public void testCalculateBonus() {
        // Create an Employee object
        Employee employee = new Employee("John Doe", "john.doe@example.com", "123 Main St", 50000.0);

        // Create a PermanentEmployeeImpl object
        PermanentEmployeeImpl permanentEmployee = new PermanentEmployeeImpl();


        // Set numberOfServiceYear
        permanentEmployee.setNumberOfServiceYear(2);

        // Call calculateBonus method
        double bonus = permanentEmployee.calculateBonus(employee);
        permanentEmployee.setBonus(bonus);

        // Verify the result
        assertEquals(2500.0, bonus);
    }

    @Test
    public void testTotalCompensation() {
        // Create an Employee object
        Employee employee = new Employee("John Doe", "john.doe@example.com", "123 Main St", 50000.0);

        // Create a PermanentEmployeeImpl object
        PermanentEmployeeImpl permanentEmployee = new PermanentEmployeeImpl();

        // Call totalCompensation method
        double totalCompensation = permanentEmployee.totalCompensation(employee);

        // Verify the result
        assertEquals(51250.0, totalCompensation);
    }

    @Test
    public void testPensionContribute() {
        // Create an Employee object
        Employee employee = new Employee("John Doe", "john.doe@example.com", "123 Main St", 50000.0);

        // Create a PermanentEmployeeImpl object
        PermanentEmployeeImpl permanentEmployee = new PermanentEmployeeImpl();

        // Set salary
       // permanentEmployee.setSalary(50000.0);

        // set numberOfServiceYear
        permanentEmployee.setNumberOfServiceYear(1);

        // Call pensionContribute method
        double pensionContribution = permanentEmployee.pensionContribute(employee);

        // Verify the result
        assertEquals(500.0, pensionContribution);
    }

}
