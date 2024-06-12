package com.algonquin.cst8288.assignment2.library;
import com.algonquin.cst8288.assignment2.event.BookLaunch;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.event.Workshop;

public class AcademicLibrary extends Library {
    @Override
    public Event createEvent(EventType eventType) {
        switch (eventType) {
            case WORKSHOP:
                return new Workshop();
            case BOOK_LAUNCH:
                return new BookLaunch();
            default:
                throw new IllegalArgumentException("Unknown event type: " + eventType);
        }
    }
}

