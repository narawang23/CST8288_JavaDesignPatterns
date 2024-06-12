package com.algonquin.cst8288.assignment2.library;
import com.algonquin.cst8288.assignment2.event.EventType;

public abstract class Library {
    abstract Object createEvent(EventType eventType);
}
