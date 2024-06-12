package com.algonquin.cst8288.assignment2.event;
import com.algonquin.cst8288.assignment2.constants.Constants;

public class KidsStoryTime extends Event {
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = Constants.KIDS_STORY_TIME_RATE * Constants.KIDS_STORY_TIME_DURATION;
    }
}
