package com.algonquin.cst8288.assignment1.services;

import com.algonquin.cst8288.assignment1.employee.Employee;

public interface PermanentEmployeeService extends EmployeeService {
    public double calculateBonus(Employee employee);
    public double pensionContribute(Employee employee);

}
