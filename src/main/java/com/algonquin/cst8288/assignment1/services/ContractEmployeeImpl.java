package com.algonquin.cst8288.assignment1.services;
import com.algonquin.cst8288.assignment1.employee.Employee;
import java.util.Date;

public class ContractEmployeeImpl extends Employee implements CalContractE {

    @Override
    public Date renewalDate() {
        return null;
    }

    @Override
    public double CalTotal(int salary, double bonus) {
        return salary;
    }
}
