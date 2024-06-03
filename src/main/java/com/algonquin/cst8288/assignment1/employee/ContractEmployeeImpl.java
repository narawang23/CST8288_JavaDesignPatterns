package com.algonquin.cst8288.assignment1.employee;
import com.algonquin.cst8288.assignment1.services.ContractEmployeeService;

import java.time.LocalDate;
import java.util.Date;

public class ContractEmployeeImpl extends Employee implements ContractEmployeeService {

    public ContractEmployeeImpl() {
    }

    public ContractEmployeeImpl(String name, String email, String address, double salary, LocalDate renewalDate) {
        super(name, email, address, salary, renewalDate);
    }

    @Override
    public LocalDate renewalDate() {
        return LocalDate.now().plusYears(1);
    }

    @Override
    public double totalCompensation(Employee employee) {
        return getSalary();
    }

    @Override
    public String toString() {
        return "ContractEmployee: " + '\''+
                "name=" + getName() + '\'' +
                ", email=" + getEmail() + '\'' +
                ", address=" + getAddress() + '\'' +
                ", salary=" + getSalary() +
                ", renewalDate=" + getRenewalDate()
                ;
    }
}