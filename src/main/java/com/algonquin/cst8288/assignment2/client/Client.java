//package com.algonquin.cst8288.assignment2.client;
//
//import com.algonquin.cst8288.assignment2.library.AcademicLibrary;
//import com.algonquin.cst8288.assignment2.library.PublicLibrary;
//
//import static com.algonquin.cst8288.assignment2.event.EventType.*;
//
//public class Client {
//
//	public static void main(String[] args) {
//		PublicLibrary pub_library = new PublicLibrary();
//		pub_library.createEvent(MOVIE_NIGHT);
//		pub_library.createEvent(KIDS_STORY);
//
//		AcademicLibrary academic_library = new AcademicLibrary();
//		academic_library.createEvent(WORKSHOP);
//		academic_library.createEvent(BOOK_LAUNCH);
//
//
//	}
//}
package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.library.AcademicLibrary;
import com.algonquin.cst8288.assignment2.library.PublicLibrary;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventManager;
import com.algonquin.cst8288.assignment2.event.MovieNight;
import com.algonquin.cst8288.assignment2.event.Workshop;

public class Client {

	public static void main(String[] args) {
		PublicLibrary pub_library = new PublicLibrary();
		MovieNight movieNight = new MovieNight();
		movieNight.setEventName("Friday Movie Night");
		movieNight.setEventDescription("Enjoy a movie under the stars!");
		movieNight.setEventActivities("Movie screening");
		movieNight.calculateAdmissionFee();
		pub_library.createEvent(movieNight);

		AcademicLibrary academic_library = new AcademicLibrary();
		Workshop workshop = new Workshop();
		workshop.setEventName("Python Workshop");
		workshop.setEventDescription("Learn Python from scratch!");
		workshop.setEventActivities("Python programming");
		workshop.calculateAdmissionFee();
		academic_library.createEvent(workshop);

		// Display the events
		EventManager eventManager = new EventManager();
		System.out.println(eventManager.retrieveEvent(movieNight.getId()));
		System.out.println(eventManager.retrieveEvent(workshop.getId()));
	}
}