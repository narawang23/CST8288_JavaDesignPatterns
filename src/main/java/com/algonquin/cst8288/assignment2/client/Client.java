package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.event.*;
import com.algonquin.cst8288.assignment2.library.AcademicLibrary;
import com.algonquin.cst8288.assignment2.library.PublicLibrary;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		EventManager eventManager = null;

		try {
			eventManager = new EventManager();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return;
		}

		while (true) {
			System.out.println("CHOOSE the operation by number:\n 1. Add 2. Remove 3. Update 4. Search\nAny other number: Exit");
			int choice = input.nextInt();
			input.nextLine();  // consume newline

			switch (choice) {
				case 1:
					addEvent(input, eventManager);
					break;
				case 2:
					removeEvent(input, eventManager);
					break;
				case 3:
					updateEvent(input, eventManager);
					break;
				case 4:
					searchEvent(input, eventManager);
					break;
				default:
					System.out.println("Exiting...");
					return;
			}
		}
	}

	private static void addEvent(Scanner input, EventManager eventManager) {
		System.out.println("Enter the event type:\nKIDS_STORY,\nMOVIE_NIGHT,\nWORKSHOP,\nBOOK_LAUNCH");
		String eventType = input.nextLine().toUpperCase();

		Event event = null;

		switch (eventType) {
			case "KIDS_STORY":
				event = new KidsStoryTime();
				break;
			case "MOVIE_NIGHT":
				event = new MovieNight();
				break;
			case "WORKSHOP":
				event = new Workshop();
				break;
			case "BOOK_LAUNCH":
				event = new BookLaunch();
				break;
			default:
				System.out.println("Invalid event type");
				return;
		}

		System.out.println("Enter the event name: ");
		event.setEventName(input.nextLine());
		System.out.println("Enter the event description: ");
		event.setEventDescription(input.nextLine());
		System.out.println("Enter the event activities: ");
		event.setEventActivities(input.nextLine());

		eventManager.createEvent(event);
		System.out.println("Event added successfully!");
	}

	private static void removeEvent(Scanner input, EventManager eventManager) {
		System.out.println("Enter the event ID to remove: ");
		int eventId = input.nextInt();
		input.nextLine();  // consume newline

		eventManager.deleteEventById(eventId);
		System.out.println("Event removed successfully!");
	}

	private static void updateEvent(Scanner input, EventManager eventManager) {
		System.out.println("Enter the event ID to update: ");
		int eventId = input.nextInt();
		input.nextLine();  // consume newline

		Event event = eventManager.retrieveEvent(eventId);
		if (event == null) {
			System.out.println("Event not found!");
			return;
		}

		System.out.println("Enter the new event name: ");
		event.setEventName(input.nextLine());
		System.out.println("Enter the new event description: ");
		event.setEventDescription(input.nextLine());
		System.out.println("Enter the new event activities: ");
		event.setEventActivities(input.nextLine());

		eventManager.updateEventByNameKeyword(event, event.getEventName());
		System.out.println("Event updated successfully!");
	}

	private static void searchEvent(Scanner input, EventManager eventManager) {
		System.out.println("Search by: 1. Event ID 2. Event Name");
		int searchChoice = input.nextInt();
		input.nextLine();  // consume newline

		switch (searchChoice) {
			case 1:
				System.out.println("Enter the event ID: ");
				int eventId = input.nextInt();
				input.nextLine();  // consume newline

				Event event = eventManager.retrieveEvent(eventId);
				if (event != null) {
					System.out.println(event);
				} else {
					System.out.println("Event not found!");
				}
				break;
			case 2:
				System.out.println("Enter the event name: ");
				String eventName = input.nextLine();

				List<Event> events = eventManager.retrieveEventsByName(eventName);
				if (events.isEmpty()) {
					System.out.println("No events found!");
				} else {
					events.forEach(System.out::println);
				}
				break;
			default:
				System.out.println("Invalid search choice");
				break;
		}
	}
}
