package com.algonquin.cst8288.assignment1.employee;

public class PermanentEmployeeImpl extends Employee{
    private int numberOfServiceYear;
    private double bonus;
    private double totalCompensation;

    public PermanentEmployeeImpl() {

    }


    public int getNumberOfServiceYear() {
        return numberOfServiceYear;
    }

    public void setNumberOfServiceYear(int numberOfServiceYear) {
        this.numberOfServiceYear = numberOfServiceYear;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getTotalCompensation() {
        return totalCompensation;
    }

    public void setTotalCompensation(double totalCompensation) {
        this.totalCompensation = totalCompensation;
    }


}
