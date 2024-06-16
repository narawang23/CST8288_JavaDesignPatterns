package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.event.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		EventManager eventManager;

		try {
			eventManager = new EventManager();
		} catch (SQLException | IOException e) {
			System.out.println("Error occurred while initializing the EventManager. Exiting...");
			return;
		}

		while (true) {
			System.out.println("CHOOSE the operation by number:\n 1. Add 2. Remove 3. Update 4. Search\nAny other number: Exit");
			int choice = input.nextInt();
			input.nextLine();

			switch (choice) {
				case 1:
					System.out.println("Enter the event type:\n" +
							"KIDS_STORY,\n" +
							" \tMOVIE_NIGHT,\n" +
							" \tWORKSHOP,\n" +
							"\tBOOK_LAUNCH ");

					String eventTypeInput = input.nextLine().trim();

					try {
						EventType eventType = EventType.valueOf(eventTypeInput.toUpperCase());
						Event event = eventManager.createAndStoreEvent(eventType);
						System.out.println("Successfully created a new event: " + event.getEventName());
					} catch (IllegalArgumentException e) {
						System.out.println("Invalid event type entered.");
					} catch (SQLException | IOException e) {
						System.out.println("Failed to create event: " + e.getMessage());
					}
					break;


				case 2://remove an event based on event ID
					// Retrieve all events and display them to the user
					List<Event> allEvents = eventManager.retrieveAllEvents();
					if (allEvents.isEmpty()) {
						System.out.println("No events found.");
						break;
					}
					System.out.println("Available events:");
					for (Event event : allEvents) {
						System.out.println("ID: " + event.getEventId() + ", Name: " + event.getEventName());
					}

					System.out.println("Enter the event ID to remove:");
					int eventIdToRemove = input.nextInt();
					input.nextLine(); // consume the newline

					try {
						eventManager.deleteEventById(eventIdToRemove);
						System.out.println("Successfully removed the event with ID: " + eventIdToRemove);
					} catch (Exception e) {
						System.out.println("Failed to remove event: " + e.getMessage());
					}
					break;

				case 3:
					System.out.println("Enter the keyword to identify the event to update:");
					String keyword = input.nextLine().trim();

					List<Event> eventsToUpdate = eventManager.retrieveEventsByNameKeyword(keyword);
					if (eventsToUpdate.isEmpty()) {
						System.out.println("No events found with the keyword: " + keyword);
						break;
					}

					System.out.println("Available events:");
					for (Event event : eventsToUpdate) {
						System.out.println("ID: " + event.getEventId()
								+ ", Name: " + event.getEventName()
								+ ", EventType: " + event.getEventType()
								+ ", Description: " + event.getEventDescription()
								+ "Activities: " + event.getEventActivities()
								+ "AdmissionFees: " + event.getAdmissionFees());
					}

					System.out.println("Enter the event ID to update:");
					int eventIdToUpdate = input.nextInt();
					input.nextLine(); // consume the newline

					Event eventToUpdate = null;
					for (Event event : eventsToUpdate) {
						if (event.getEventId() == eventIdToUpdate) {
							eventToUpdate = event;
							break;
						}
					}

					if (eventToUpdate == null) {
						System.out.println("Invalid event ID entered.");
						break;
					}

					System.out.println("Enter the new event name:");
					String newEventName = input.nextLine().trim();
					eventToUpdate.setEventName(newEventName);

					System.out.println("Enter the new event description:");
					String newEventDescription = input.nextLine().trim();
					eventToUpdate.setEventDescription(newEventDescription);

					try {
						eventManager.updateEventByNameKeyword(eventToUpdate, keyword);
						System.out.println("Successfully updated the event with ID: " + eventToUpdate.getEventId());
					} catch (Exception e) {
						System.out.println("Failed to update event: " + e.getMessage());
					}
					break;

				case 4:
					System.out.println("Enter the event name to search for events:");
					String searchWord = input.nextLine().trim();

					List<Event> events = eventManager.retrieveEventsByNameKeyword(searchWord);
					if (events.isEmpty()) {
						System.out.println("No events found with the keyword: " + searchWord);
					} else {
						System.out.println("Events found with the keyword '" + searchWord + "':");
						for (Event event : events) {
							System.out.println("ID: " + event.getEventId() + ", Name: " + event.getEventName());
						}
					}
					break;

				default:
					System.out.println("Please choose your operation ONLY NUMBER 1-4 are allowed. Exiting...");
			}
		}
	}
}