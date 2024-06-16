package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.database.DBOperations;
import com.algonquin.cst8288.assignment2.library.AcademicLibrary;
import com.algonquin.cst8288.assignment2.library.PublicLibrary;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EventManager {
    private DBOperations dbOperations;
    private PublicLibrary publicLibrary;
    private AcademicLibrary academicLibrary;

    public EventManager() throws SQLException, IOException {
        this.dbOperations = new DBOperations();
        this.publicLibrary = new PublicLibrary();
        this.academicLibrary = new AcademicLibrary();
    }

    public Event createAndStoreEvent(EventType eventType)throws SQLException, IOException {
        Event event = null;
        switch (eventType) {
            case KIDS_STORY:
            case MOVIE_NIGHT:
                event = publicLibrary.createEvent(eventType);
                break;
            case WORKSHOP:
            case BOOK_LAUNCH:
                event = academicLibrary.createEvent(eventType);
                break;
            default:
                throw new IllegalArgumentException("Unknown event type: " + eventType);
        }
        if (event == null) {
            throw new IllegalStateException("Failed to create event for type: " + eventType);
        }
        event.calculateAdmissionFee();
        dbOperations.createEvent(event);
        return event;
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
