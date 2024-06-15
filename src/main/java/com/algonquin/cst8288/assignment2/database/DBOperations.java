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

    public Event retrieveEvent(int eventId) {
        Event event = null;
        String sql = "SELECT * FROM events WHERE event_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, eventId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                event = new Event();
                event.setEvent_id(resultSet.getInt("event_id"));
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

    public void createEvent(Event event) {
        String sql = "INSERT INTO events (event_name, event_description, event_activities, admission_fees) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, event.getEventName());
            preparedStatement.setString(2, event.getEventDescription());
            preparedStatement.setString(3, event.getEventActivities());
            preparedStatement.setDouble(4, event.getAdmissionFees());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEvent(Event event) {
        String sql = "UPDATE events SET event_name = ?, event_description = ?, event_activities = ?, admission_fees = ? WHERE event_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, event.getEventName());
            preparedStatement.setString(2, event.getEventDescription());
            preparedStatement.setString(3, event.getEventActivities());
            preparedStatement.setDouble(4, event.getAdmissionFees());
            preparedStatement.setInt(5, event.getEvent_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEvent(int eventId) {
        String sql = "DELETE FROM events WHERE event_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, eventId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}