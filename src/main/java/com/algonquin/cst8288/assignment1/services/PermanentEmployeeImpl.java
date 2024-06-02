package com.algonquin.cst8288.assignment1.services;
import com.algonquin.cst8288.assignment1.employee.Employee;

public class PermanentEmployeeImpl extends Employee implements CalPermanentE{

    @Override
    public double pensionContribution(Employee employee) {
        return 0;
    }

    @Override
    public double calculateBonus(Employee employee) {
        return 0;
    }

    @Override
    public double CalTotal(int salary, double bonus) {
        return 0;
    }

}
