package com.algonquin.cst8288.assignment1.controller;
import com.algonquin.cst8288.assignment1.employee.*;


import java.time.LocalDate;

public class EmployeeProcessor {
    public void processEmployee(Employee employee) {
        if (employee instanceof PermanentEmployeeImpl) {
            PermanentEmployeeImpl permEmployee = (PermanentEmployeeImpl) employee;
            double bonus = permEmployee.calculateBonus(permEmployee);
            permEmployee.setBonus(bonus);
            double totalCompensation = permEmployee.totalCompensation(permEmployee);
            double pensionContribution = permEmployee.pensionContribute(permEmployee);


        } else if (employee instanceof ContractEmployeeImpl) {
            ContractEmployeeImpl contractEmployee = (ContractEmployeeImpl) employee;
            LocalDate renewalDate = contractEmployee.renewalDate();
            double totalCompensation = contractEmployee.totalCompensation(employee);

        }
    }
}