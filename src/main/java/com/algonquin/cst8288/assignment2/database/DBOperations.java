package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;/**/

public class DBOperations {
    private Connection connection;
    private Properties queries;

    public DBOperations() {
        try {
            this.connection = DBConnection.getInstance().getConnection();
            this.queries = loadQueries();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Properties loadQueries() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("queries.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public void storeEvent(Event event) throws SQLException {
        String storeEventQuery = queries.getProperty("storeEvent");
        try (PreparedStatement statement = connection.prepareStatement(storeEventQuery)) {
            statement.setString(1, event.getEventName());
            statement.setString(2, event.getEventType().toString());
            statement.setString(3, event.getEventDescription());
            statement.setString(4, event.getEventActivities());
            statement.setDouble(5, event.getAdmissionFees());
            statement.executeUpdate();
        }
    }

    public List<Event> retrieveAllEvents() throws SQLException {
        String sql = queries.getProperty("retrieveAllEvents");
        List<Event> events = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Event event = mapResultSetToEvent(resultSet);
                events.add(event);
            }
        }
        return events;
    }

    public Event retrieveEventById(int eventId) throws SQLException {
        String sql = queries.getProperty("retrieveEventById");
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, eventId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToEvent(resultSet);
                }
            }
        }
        return null;
    }

    public List<Event> retrieveEventByName(String eventNameKeyword) throws SQLException {
        String sql = queries.getProperty("retrieveEventByName");
        List<Event> events = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + eventNameKeyword + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Event event = mapResultSetToEvent(resultSet);
                    events.add(event);
                }
            }
        }
        return events;
    }

    public void updateEventByNameKeyword(String eventNameKeyword, Event updatedEvent) throws SQLException {
        String sql = queries.getProperty("updateEventByNameKeyword");
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, updatedEvent.getEventName());
            statement.setString(2, updatedEvent.getEventType().toString());
            statement.setString(3, updatedEvent.getEventDescription());
            statement.setString(4, updatedEvent.getEventActivities());
            statement.setDouble(5, updatedEvent.getAdmissionFees());
            statement.setString(6, "%" + eventNameKeyword + "%");
            statement.executeUpdate();
        }
    }

    public void deleteEventById(int eventId) throws SQLException {
        String sql = queries.getProperty("deleteEventById");
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, eventId);
            statement.executeUpdate();
        }
    }

    private Event mapResultSetToEvent(ResultSet resultSet) throws SQLException {
        int eventId = resultSet.getInt("event_id");
        String eventName = resultSet.getString("event_name");
        String eventTypeStr = resultSet.getString("event_type");
        EventType eventType = EventType.valueOf(eventTypeStr);
        String eventDescription = resultSet.getString("event_description");
        String eventActivities = resultSet.getString("event_activities");
        double admissionFees = resultSet.getDouble("admission_fees");

        return new Event(eventId, eventName, eventDescription, eventActivities, admissionFees, eventType) {
            @Override
            public void calculateAdmissionFee() {

            }
        };
    }
}

