package com.algonquin.cst8288.assignment2.event;
import com.algonquin.cst8288.assignment2.constants.Constants;

public class KidsStoryTime extends Event {

//    public KidsStoryTime(int eventId, String eventName, String eventType, String eventDescription, String eventActivities, double admissionFees) {
//        super(eventId, eventName, eventType, eventDescription, eventActivities, admissionFees);
//    }

    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = Constants.KIDS_STORY_TIME_RATE * Constants.KIDS_STORY_TIME_DURATION;
    }
}

