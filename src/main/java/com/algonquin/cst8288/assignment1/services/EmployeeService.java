package com.algonquin.cst8288.assignment1.services;
//import com.algonquin.cst8288.assignment1.employee.Employee;
//import java.util.Date;

import com.algonquin.cst8288.assignment1.employee.Employee;

/**
 * 
 * EmployeeService interface
 * 
 */

public interface EmployeeService {
	public double totalCompensation(Employee employee);
	public double pensionContribute(Employee employee);

}
