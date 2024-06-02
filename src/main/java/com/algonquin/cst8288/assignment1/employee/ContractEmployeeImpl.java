package com.algonquin.cst8288.assignment1.employee;
import com.algonquin.cst8288.assignment1.services.ContractEmployeeService;

import java.time.LocalDate;

public class ContractEmployeeImpl extends Employee implements ContractEmployeeService {

    @Override
    public LocalDate renewalDate() {
        return LocalDate.now().plusYears(1);
    }

    @Override
    public double totalCompensation(Employee employee) {
        return getSalary();
    }


}