package com.algonquin.cst8288.assignment2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection connection = null;


	private String serverUrl = "jdbc:mysql://localhost:3306/bookvault";
	private String userString = "root";
	private String passwordString = "password";
	private String driverString = "com.mysql.cj.jdbc.Driver";

	private DBConnection(String serverUrl, String userString, String passwordString, String driverString) {

	}
}
