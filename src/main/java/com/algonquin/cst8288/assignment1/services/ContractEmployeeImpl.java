package com.algonquin.cst8288.assignment1.services;
import com.algonquin.cst8288.assignment1.employee.Employee;
import java.time.LocalDate;

public class ContractEmployeeImpl extends Employee implements CalContractE {

    @Override
    public LocalDate renewalDate() {
        return LocalDate.now().plusYears(1);
    }

    @Override
    public double totalCompensation(Employee employee) {
        return getSalary();
    }

//    @Override
//    public double pensionContribute(Employee employee) {
//        return getSalary() * Rate.PENSION_PERCENTAGE;
//    }
}