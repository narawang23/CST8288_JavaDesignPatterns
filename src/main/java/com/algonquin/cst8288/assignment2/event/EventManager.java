package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.database.DBOperations;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EventManager {
    private DBOperations dbOperations;

    public EventManager() throws SQLException, IOException {
        this.dbOperations = new DBOperations();
    }

    public void createEvent(Event event) {
        dbOperations.createEvent(event);
    }

    public Event retrieveEvent(int eventId) {
        return dbOperations.retrieveEventById(eventId);
    }

    public List<Event> retrieveAllEvents() {
        return dbOperations.retrieveAllEvents();
    }

    public List<Event> retrieveEventsByName(String eventName) {
        return dbOperations.retrieveEventByName(eventName);
    }

    public List<Event> retrieveEventsByNameKeyword(String keyword) {
        return dbOperations.retrieveEventByNameKeyword(keyword);
    }

    public void updateEventByNameKeyword(Event event, String keyword) {
        dbOperations.updateEventByNameKeyword(event, keyword);
    }

    public void deleteEventById(int eventId) {
        dbOperations.deleteEventById(eventId);
    }

    public void deleteEventByName(String eventName) {
        dbOperations.deleteEventByName(eventName);
    }
}
