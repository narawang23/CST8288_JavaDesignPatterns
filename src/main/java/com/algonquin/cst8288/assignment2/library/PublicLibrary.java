package com.algonquin.cst8288.assignment2.library;

import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.event.KidsStoryTime;
import com.algonquin.cst8288.assignment2.event.MovieNight;

public class PublicLibrary extends Library{
    @Override
    public Object createEvent(EventType eventType){
        switch (eventType){
            case MOVIE_NIGHT:
                return new MovieNight().toString();
            case KIDS_STORY:
                return new KidsStoryTime().toString();
            default:
                throw new IllegalArgumentException("Unknown event type: " + eventType);
        }
    };

}
