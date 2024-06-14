package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.database.DBOperations;

import java.sql.SQLException;

public class EventManager {
    private DBOperations dbOperations;

    public EventManager() throws SQLException {
        this.dbOperations = new DBOperations();
    }

    public void createEvent(Event event) {
        dbOperations.createEvent(event);
    }

    public Event retrieveEvent(int eventId) {
        return dbOperations.retrieveEvent(eventId);
    }

    public void updateEvent(Event event) {
        dbOperations.updateEvent(event);
    }

    public void deleteEvent(int eventId) {
        dbOperations.deleteEvent(eventId);
    }
}