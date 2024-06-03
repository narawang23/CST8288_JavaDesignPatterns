package com.algonquin.cst8288.assignment1.test;
import com.algonquin.cst8288.assignment1.employee.*;
import com.algonquin.cst8288.assignment1.controller.*;

import java.io.IOException;
import java.time.LocalDate;

/**
 * 
 * Main class to execute the application
 * 
 */

public class Main {
	public static void main(String[] args) throws IOException {

		// Instantiate two Employee objects
		Employee permanentEmployee = new PermanentEmployeeImpl(
				"Joe Dow",
				"Joe.dow@abc.com",
				"1381 WOODROFFE AVE.",
				90000.0,
				10,
				0,
				0
		);

		double bonus = ((PermanentEmployeeImpl) permanentEmployee).calculateBonus(permanentEmployee);
		permanentEmployee.setBonus(bonus);

		double totalCompensation = permanentEmployee.getSalary() + permanentEmployee.getBonus();
		permanentEmployee.setTotalCompensation(totalCompensation);

		Employee contractEmployee = new ContractEmployeeImpl(
				"Jane Smith",
				"jane.smith@example.com",
				"456 Woodroffe Rd, Ottawa City",
				60000,
				LocalDate.now().plusYears(1) // Renewal date, 1 year from today
		);


		// Instantiate EmployeeController
		EmployeeController employeeController = new EmployeeController(new EmployeeProcessor(), new EmployeeValidator(), new PersistenceService());

		// Utilize EmployeeController.java to save both objects in JSON and Text formats
		employeeController.handleEmployee(permanentEmployee, "json_employee_data.txt");
		employeeController.handleEmployee(contractEmployee, "json_employee_data.txt");

		employeeController.handleEmployee(permanentEmployee, "text_employee_data.txt");
		employeeController.handleEmployee(contractEmployee, "text_employee_data.txt");


		// Output the data to the console
		System.out.println(permanentEmployee);
		System.out.println(contractEmployee);

	}	

}
