package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.database.DBOperations;
import com.algonquin.cst8288.assignment2.library.PublicLibrary;
import com.algonquin.cst8288.assignment2.library.AcademicLibrary;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.algonquin.cst8288.assignment2.event.EventType.KIDS_STORY;
import static com.algonquin.cst8288.assignment2.event.EventType.MOVIE_NIGHT;

public class EventManager {
    private PublicLibrary publicLibrary;
    private AcademicLibrary academicLibrary;
    private DBOperations dbOperation;

    public EventManager() throws SQLException, IOException {
        this.publicLibrary = new PublicLibrary();
        this.academicLibrary = new AcademicLibrary();
        this.dbOperation = new DBOperations();
    }

    public void createEvent(EventType eventType) {
        switch (eventType) {
            case KIDS_STORY:
                Event kidsStoryTime = publicLibrary.createEvent(KIDS_STORY);
                break;
            case MOVIE_NIGHT:
                Event movieNight = publicLibrary.createEvent(MOVIE_NIGHT);
                break;
            case WORKSHOP:
                Event workshop = academicLibrary.createEvent(EventType.WORKSHOP);
                break;
            case BOOK_LAUNCH:
                Event bookLaunch = academicLibrary.createEvent(EventType.BOOK_LAUNCH);
                break;
            default:
                throw new IllegalArgumentException("Unknown event type: " + eventType);
        }
    }

    public void storeEvent(Event event) throws SQLException {
        dbOperation.storeEvent(event);

    }

    public List<Event> retrieveAllEvents() throws SQLException {
        List<Event> allEvents = dbOperation.retrieveAllEvents();
        return allEvents;
    }

    public List<Event> retrieveEventByName(String eventName) throws SQLException {
        List<Event> events = dbOperation.retrieveEventByName(eventName);
        return events != null ? events : new ArrayList<Event>();
    }

    public void updateEventByNameKeyword(String keyword, Event updatedEvent) throws SQLException {
        dbOperation.updateEventByNameKeyword(keyword, updatedEvent);
    }

    public void deleteEventById(int eventId) throws SQLException {
        dbOperation.deleteEventById(eventId);
    }
}