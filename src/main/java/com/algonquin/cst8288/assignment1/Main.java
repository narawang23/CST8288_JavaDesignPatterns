package com.algonquin.cst8288.assignment1;
import com.algonquin.cst8288.assignment1.employee.*;
import com.algonquin.cst8288.assignment1.controller.*;
import com.algonquin.cst8288.assignment1.persistence.*;
import java.io.IOException;

/**
 * 
 * Main class to execute the application
 * 
 */

public class Main {
	public static void main(String[] args) throws IOException {
		// Instantiate two Employee objects
		Employee permanentEmployee = new PermanentEmployeeImpl();
		Employee contractEmployee = new ContractEmployeeImpl();

		// Use PermanentEmployeeImpl.java and ContractEmployeeImpl.java to calculate and populate required data for objects
		((PermanentEmployeeImpl) permanentEmployee).setBonus(permanentEmployee);
		((ContractEmployeeImpl) contractEmployee).renewalDate();

		// Instantiate EmployeeController
		EmployeeController employeeController = new EmployeeController(new EmployeeProcessor(), new EmployeeValidator(), new EmployeeSaver());


		// Utilize EmployeeController.java to save both objects in JSON and Text formats
		employeeController.handleEmployee(permanentEmployee, "json_employee_data.txt");
		employeeController.handleEmployee(contractEmployee, "json_employee_data.txt");
		employeeController.handleEmployee(permanentEmployee, "text_employee_data.txt");
		employeeController.handleEmployee(contractEmployee, "text_employee_data.txt");

		// Output the data to the console
		System.out.println(permanentEmployee.toString());
		System.out.println(contractEmployee.toString());
	}	

}
