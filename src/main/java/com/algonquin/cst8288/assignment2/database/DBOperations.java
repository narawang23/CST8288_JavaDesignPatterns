package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.event.Event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperations {
    private Connection connection;
    Event event = null;

    public DBOperations() throws SQLException {
        // Replace with your database connection details
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        this.connection = DriverManager.getConnection(url, username, password);
    }

    public Event retrieveEvent(Event eventId) {

        String sql = "SELECT * FROM events where event_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,
                    event_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                event = new Event();
                event.setEventName(resultSet.getString("eventName"));
                event.setEventDescription(resultSet.getString("eventDescription"));
                event.setEventActivities(resultSet.getString("eventActivities"));
                event.setAdmissionFees(resultSet.getDouble("admissionFees"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return event;
    }
}