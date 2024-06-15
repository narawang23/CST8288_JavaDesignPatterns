package com.algonquin.cst8288.assignment2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static DBConnection instance = null;
	private static Connection connection = null;

	private String serverUrl = "jdbc:mysql://localhost:3306/bookvault";
	private String userString = "root";
	private String passwordString = "vistopia";
	private String driverString = "com.mysql.cj.jdbc.Driver";

	private DBConnection() throws SQLException {
		try {
		Class.forName(driverString);//loads the driver (optional, normally autoloaded)
		this.connection = DriverManager.getConnection(serverUrl, userString, passwordString);
	} catch (ClassNotFoundException ex) {
		System.out.println("Database Connection Creation Failed : " + ex.getMessage());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static DBConnection getInstance() throws SQLException {
		if (instance == null) {
			instance = new DBConnection();
		} else if (instance.getConnection().isClosed()) {
			instance = new DBConnection();
		}
		return instance;
	}

	}
