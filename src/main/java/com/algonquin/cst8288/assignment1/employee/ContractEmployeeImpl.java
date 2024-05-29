package com.algonquin.cst8288.assignment1.employee;

import com.algonquin.cst8288.assignment1.services.EmployeeService;
import com.algonquin.cst8288.assignment1.services.Rate;

import java.util.Date;



public class ContractEmployeeImpl extends Employee implements EmployeeService, Rate {
    private Date renewalDate;

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }


    @Override
    public double calculateTotalCompensation(Employee PermanentEmployees) {
        return 0;
    }

    @Override
    public double pensionContribution(Employee employee) {
        return 0;
    }

    @Override
    public double calculateBonus(Employee employee) {
        return 0;
    }

    @Override
    public Date renewalDate() {
        return null;
    }
}
