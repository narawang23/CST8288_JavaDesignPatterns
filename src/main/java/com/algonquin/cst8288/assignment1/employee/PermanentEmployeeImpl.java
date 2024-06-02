package com.algonquin.cst8288.assignment1.employee;
import com.algonquin.cst8288.assignment1.services.PermanentEmployeeService;
import com.algonquin.cst8288.assignment1.services.Rate;

public class PermanentEmployeeImpl extends Employee implements PermanentEmployeeService {

//    private Employee employee;

    //    Bonus is 2.5% of base salary and calculated multiplying by the years of service.
    @Override
    public double calculateBonus(Employee employee) {
        return Rate.BONUS_PERCENTAGE * getSalary() * getNumberOfServiceYear();
    }

    public void setBonus(Employee employee) {
        double bonus = calculateBonus(employee);
        employee.setBonus(bonus);
    }


    //    Total compensation is calculated as salary + bonus
    @Override
    public double totalCompensation(Employee employee) {
        return getSalary() + getBonus();
    }

//    Pension contribution is 1% of base salary.
    @Override
    public double pensionContribute(Employee employee) {
        return getSalary() * Rate.PENSION_PERCENTAGE;
    }

}
