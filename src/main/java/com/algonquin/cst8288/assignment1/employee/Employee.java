package com.algonquin.cst8288.assignment1.employee;

import com.algonquin.cst8288.assignment1.services.Rate;

import java.time.LocalDate;
import java.util.Date;

public class Employee {

	private String name;
	private String email;
	private String address;
	private double salary;
	private int numberOfServiceYear;
	private double bonus;
	private double totalCompensation;
	private LocalDate renewalDate;

	public Employee() {
		// Default constructor
	}

	public Employee(String name, String email, String address, double salary) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.salary = salary;
	}

	public Employee(String name, String email, String address, double salary, LocalDate renewalDate) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.salary = salary;
		this.renewalDate = renewalDate;
	}

	public Employee(String name, String email, String address, double salary, int numberOfServiceYear, double bonus, double totalCompensation) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.salary = salary;
		this.numberOfServiceYear = numberOfServiceYear;
		this.bonus = bonus;
		this.totalCompensation = totalCompensation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
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

	public LocalDate getRenewalDate() {
		return renewalDate;
	}

	public void setRenewalDate(LocalDate renewalDate) {
		this.renewalDate = renewalDate;
	}

	@Override
	public String toString() {
		return null;
	}

}