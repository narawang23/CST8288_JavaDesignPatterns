package com.algonquin.cst8288.assignment1.controller;
import com.algonquin.cst8288.assignment1.employee.ContractEmployeeImpl;
import com.algonquin.cst8288.assignment1.employee.Employee;
import com.algonquin.cst8288.assignment1.employee.PermanentEmployeeImpl;

import java.time.LocalDate;

public class EmployeeProcessor {
    public void processEmployee(Employee employee) {
        if (employee instanceof PermanentEmployeeImpl) {
            PermanentEmployeeImpl permEmployee = (PermanentEmployeeImpl) employee;
            permEmployee.setBonus(employee);
            double totalCompensation = permEmployee.totalCompensation(employee);
            double pensionContribution = permEmployee.pensionContribute(employee);


        } else if (employee instanceof ContractEmployeeImpl) {
            ContractEmployeeImpl contractEmployee = (ContractEmployeeImpl) employee;
            LocalDate renewalDate = contractEmployee.renewalDate();
            double totalCompensation = contractEmployee.totalCompensation(employee);

        }
    }
}