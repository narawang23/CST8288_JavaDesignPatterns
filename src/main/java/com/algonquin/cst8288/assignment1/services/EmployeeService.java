package com.algonquin.cst8288.assignment1.services;

import com.algonquin.cst8288.assignment1.employee.Employee;

import java.util.Date;

/**
 * 
 * EmployeeService interface
 * 
 */

public interface EmployeeService {

	public double calculateTotalCompensation(Employee PermanentEmployees);
	
	public double pensionContribution(Employee employee);
	
	public double calculateBonus(Employee employee);
	
	public Date renewalDate();
	
}
