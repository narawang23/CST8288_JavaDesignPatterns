package com.algonquin.cst8288.assignment1.services;
import com.algonquin.cst8288.assignment1.employee.Employee;

public class PermanentEmployeeImpl extends Employee implements CalPermanentE{

//    Bonus is 2.5% of base salary and calculated multiplying by the years of service.
    @Override
    public double calculateBonus(Employee employee) {
        return Rate.BONUS_PERCENTAGE * getSalary() * getNumberOfServiceYear();
    }

//    Total compensation is calculated as salary + bonus
    @Override
    public double totalCompensation(int salary, double bonus) {
        return getSalary() + getBonus();
    }

//    Pension contribution is 1% of base salary.
    @Override
    public double pensionContribute(int salary) {
        return getSalary() * Rate.PENSION_PERCENTAGE;
    }

}
