package com.algonquin.cst8288.assignment1.employee;
import com.algonquin.cst8288.assignment1.services.PermanentEmployeeService;
import com.algonquin.cst8288.assignment1.services.Rate;

public class PermanentEmployeeImpl extends Employee implements PermanentEmployeeService {

    public PermanentEmployeeImpl() {
    }

    public PermanentEmployeeImpl(String name, String email, String address, double salary, int numberOfServiceYear, double bonus, double totalCompensation) {
        super(name, email, address, salary);
        setNumberOfServiceYear(numberOfServiceYear);
        setBonus(bonus);
        setTotalCompensation(totalCompensation);

    }

    //    Bonus is 2.5% of base salary and calculated multiplying by the years of service.
    @Override
    public double calculateBonus(Employee employee) {
        return Rate.BONUS_PERCENTAGE * getSalary() * getNumberOfServiceYear();
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

    @Override
    public String toString() {
        return "PermanentEmployee: " +
                "name=" + getName() + '\'' +
                ", email=" + getEmail() + '\'' +
                ", address= " + getAddress() + '\'' +
                ", salary=" + getSalary() +
                ", numberOfServiceYear=" + getNumberOfServiceYear() +
                ", bonus=" + getBonus() +
                ", totalCompensation=" + getTotalCompensation() ;

    }
}
