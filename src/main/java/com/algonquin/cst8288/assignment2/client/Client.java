package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.library.AcademicLibrary;
import com.algonquin.cst8288.assignment2.library.PublicLibrary;

import static com.algonquin.cst8288.assignment2.event.EventType.*;

public class Client {
	
	public static void main(String[] args) {
		PublicLibrary pub_library = new PublicLibrary();
		pub_library.createEvent(MOVIE_NIGHT);
		pub_library.createEvent(KIDS_STORY);

		AcademicLibrary academic_library = new AcademicLibrary();
		academic_library.createEvent(WORKSHOP);
		academic_library.createEvent(BOOK_LAUNCH);

	}
}
