package com.algonquin.cst8288.assignment2.Test;

import com.algonquin.cst8288.assignment2.constants.Constants;
import com.algonquin.cst8288.assignment2.event.BookLaunch;
import com.algonquin.cst8288.assignment2.event.KidsStoryTime;
import com.algonquin.cst8288.assignment2.event.MovieNight;
import com.algonquin.cst8288.assignment2.event.Workshop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EventTests {

    // for KidsStoryTime
    @Test
    void testKidsStoryTimeAdmissionFee() {
        KidsStoryTime event = new KidsStoryTime();
        event.calculateAdmissionFee();
        double expectedFee = Constants.KIDS_STORY_TIME_RATE * Constants.KIDS_STORY_TIME_DURATION;
        Assertions.assertEquals(expectedFee, event.getAdmissionFees(), "Admission fee for Kids Story Time should be calculated correctly");
    }

    // for BookLaunch
    @Test
    void testBookLaunchAdmissionFee() {
        BookLaunch event = new BookLaunch();
        event.calculateAdmissionFee();
        double expectedFee = Constants.BOOK_LAUNCH_RATE * Constants.BOOK_LAUNCH_DURATION;
        Assertions.assertEquals(expectedFee, event.getAdmissionFees(), "Admission fee for Book Launch should be calculated correctly");
    }

    // for MovieNight
    @Test
    void testMovieNightAdmissionFee() {
        MovieNight event = new MovieNight();
        event.calculateAdmissionFee();
        double expectedFee = Constants.MOVIE_NIGHT_RATE * Constants.MOVIE_NIGHT_DURATION;
        Assertions.assertEquals(expectedFee, event.getAdmissionFees(), "Admission fee for Movie Night should be calculated correctly");
    }

  //for Workshop
    @Test
    void testWorkshopAdmissionFee() {
        Workshop event = new Workshop();
        event.calculateAdmissionFee();
        double expectedFee = Constants.WORKSHOP_RATE * Constants.WORKSHOP_DURATION;
        Assertions.assertEquals(expectedFee, event.getAdmissionFees(), "Admission fee for Workshop should be calculated correctly");
    }
}
