package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.event.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public class DBOperations {
    private Connection connection;
    private Properties queries;

    public DBOperations() throws SQLException, IOException {
        this.connection = DBConnection.getInstance().getConnection();
        loadQueries();
    }

    private void loadQueries() throws IOException {
        queries = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("queries.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find queries.properties");
                return;
            }
            queries.load(input);
        }
    }

    private Event createEventInstance(String eventType) {
        switch (eventType) {
            case "MOVIE_NIGHT":
                return new MovieNight();
            case "KIDS_STORY":
                return new KidsStoryTime();
            case "WORKSHOP":
                return new Workshop();
            case "BOOK_LAUNCH":
                return new BookLaunch();
            default:
                throw new IllegalArgumentException("Unknown event type: " + eventType);
        }
    }

    public List<Event> retrieveAllEvents() {
        List<Event> events = new ArrayList<>();
        String sql = queries.getProperty("retrieveAllEvents");

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String eventType = resultSet.getString("event_type");
                Event event = createEventInstance(eventType);
//              event.setEventId(resultSet.getInt("event_id"));
                event.setEventName(resultSet.getString("event_name"));
                event.setEventDescription(resultSet.getString("event_description"));
                event.setEventActivities(resultSet.getString("event_activities"));
                event.setAdmissionFees(resultSet.getDouble("admission_fees"));

                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }

    public Event retrieveEventById(int eventId) {
        Event event = null;
        String sql = queries.getProperty("retrieveEventById");

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, eventId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String eventType = resultSet.getString("event_type");
                event = createEventInstance(eventType);
                event.setEventName(resultSet.getString("event_name"));
                event.setEventDescription(resultSet.getString("event_description"));
                event.setEventActivities(resultSet.getString("event_activities"));
                event.setAdmissionFees(resultSet.getDouble("admission_fees"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return event;
    }

    public List<Event> retrieveEventByName(String eventName) {
        List<Event> events = new ArrayList<>();
        String sql = queries.getProperty("retrieveEventByName");

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, eventName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String eventType = resultSet.getString("event_type");
                Event event = createEventInstance(eventType);
                event.setEventName(resultSet.getString("event_name"));
                event.setEventDescription(resultSet.getString("event_description"));
                event.setEventActivities(resultSet.getString("event_activities"));
                event.setAdmissionFees(resultSet.getDouble("admission_fees"));

                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }

    public List<Event> retrieveEventByNameKeyword(String keyword) {
        List<Event> events = new ArrayList<>();
        String sql = queries.getProperty("retrieveEventByNameKeyword");

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String eventType = resultSet.getString("event_type"); // Assume event_type column exists
                Event event = createEventInstance(eventType);
                event.setEventName(resultSet.getString("event_name"));
                event.setEventDescription(resultSet.getString("event_description"));
                event.setEventActivities(resultSet.getString("event_activities"));
                event.setAdmissionFees(resultSet.getDouble("admission_fees"));

                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }

    public void updateEventByNameKeyword(Event event, String keyword) {
        String sql = queries.getProperty("updateEventByNameKeyword");

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, event.getEventName());
            preparedStatement.setString(2, event.getEventDescription());
            preparedStatement.setString(3, event.getEventActivities());
            preparedStatement.setDouble(4, event.getAdmissionFees());
            preparedStatement.setString(5, "%" + keyword + "%");

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEventById(int eventId) {
        String sql = queries.getProperty("deleteEventById");

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, eventId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEventByName(String eventName) {
        String sql = queries.getProperty("deleteEventByName");

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, eventName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createEvent(Event event) {
        String sql = queries.getProperty("createEvent");

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, event.getEventName());
            preparedStatement.setString(2, String.valueOf(event.getEventType()));
            preparedStatement.setString(3, event.getEventDescription());
            preparedStatement.setString(4, event.getEventActivities());
            preparedStatement.setDouble(5, event.getAdmissionFees());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
