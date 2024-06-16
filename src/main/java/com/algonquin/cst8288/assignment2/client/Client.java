package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.event.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static com.algonquin.cst8288.assignment2.event.EventType.*;

public class Client {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		EventManager eventManager;

		try {
			eventManager = new EventManager();
		} catch (SQLException | IOException e) {
			System.out.println("Error occurred while initializing the EventManager.");
			return;
		}

		boolean isContinue = true;
		while (isContinue) {
			System.out.println("CHOOSE the operation by number:\n 1. Add 2. Remove 3. Update 4. Search\nAny other number: Exit");
			int choice = input.nextInt();
			input.nextLine(); // consume the newline

			switch (choice) {
				case 1:
					System.out.println("Enter the event type:\nKIDS_STORY\nMOVIE_NIGHT\nWORKSHOP\nBOOK_LAUNCH");
					String eventTypeStr = input.nextLine();
					EventType eventType;
					try {
						eventType = EventType.valueOf(eventTypeStr);
					} catch (IllegalArgumentException e) {
						System.out.println("Invalid event type. Please enter a valid event type.");
						break;
					}

					System.out.println("Enter the event name: ");
					String eventName = input.nextLine();
					System.out.println("Enter the event description: ");
					String eventDescription = input.nextLine();
					System.out.println("Enter the event activities: ");
					String eventActivities = input.nextLine();

					Event event;
					switch (eventType) {
						case KIDS_STORY:
							event = new KidsStoryTime();
							break;
						case MOVIE_NIGHT:
							event = new MovieNight();
							break;
						case WORKSHOP:
							event = new Workshop();
							break;
						case BOOK_LAUNCH:
							event = new BookLaunch();
							break;
						default:
							throw new IllegalArgumentException("Unexpected value: " + eventType);
					}

					event.setEventName(eventName);
					event.setEventDescription(eventDescription);
					event.setEventActivities(eventActivities);
					event.setEventType(eventType);
					event.calculateAdmissionFee();

					try {
						eventManager.storeEvent(event);
						System.out.println("Event successfully added.");
					} catch (SQLException e) {
						System.out.println("Error storing event: " + e.getMessage());
					}
					break;

				case 2:
					System.out.println("Enter the event ID to remove:");
					int eventIdToRemove = input.nextInt();
					input.nextLine(); // consume newline

					try {
						eventManager.deleteEventById(eventIdToRemove);
						System.out.println("Event successfully removed.");
					} catch (SQLException e) {
						System.out.println("Error removing event: " + e.getMessage());
					}
					break;


				case 3:
					System.out.println("Enter the keyword to search for the event to update:");
					String keyword = input.nextLine();
					List<Event> eventsToUpdate = null;

					try {
						eventsToUpdate = eventManager.retrieveEventByName(keyword);
						if (eventsToUpdate == null) {
							System.out.println("No events found or an error occurred while retrieving events.");
							break;
						}
					} catch (SQLException e) {
						System.out.println("Error retrieving events: " + e.getMessage());
						break;
					}

					if (eventsToUpdate.isEmpty()) {
						System.out.println("No events found with the keyword: " + keyword);
						break;
					}
					break;

				case 4:
					System.out.println("Enter the event name to search for events:");
					String searchWord = input.nextLine();

					List<Event> events;
					try {
						events = eventManager.retrieveEventByName(searchWord);
					} catch (SQLException e) {
						System.out.println("Error retrieving events: " + e.getMessage());
						break;
					}

					if (events.isEmpty()) {
						System.out.println("No events found with the keyword: " + searchWord);
					} else {
						System.out.println("Events found:");
						for (Event foundEvent : events) {
							System.out.println("ID: " + foundEvent.getEventId() + ", Name: " + foundEvent.getEventName());
						}
					}
					break;

				default:
					System.out.println("Exiting...");
					isContinue = false;
					break;
			}
		}
	}
}