package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;

public class BookLaunch extends Event {
//    public BookLaunch(int eventId, String eventName, String eventType, String eventDescription, String eventActivities, double admissionFees) {
//        super(eventId, eventName, eventType, eventDescription, eventActivities, admissionFees);
//    }

    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = Constants.BOOK_LAUNCH_RATE * Constants.BOOK_LAUNCH_DURATION;
    }
}
