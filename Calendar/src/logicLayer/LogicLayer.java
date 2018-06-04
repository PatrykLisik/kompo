/**
 * 
 */
package logicLayer;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dataLayer.DataService;
import dataLayer.Event;
import dataLayer.Person;
import logicLayer.EventNotifiactionPublisher.NotifiactionSource;
import dataLayer.Event.Notification;


/**
 * Interface that generalize logic layer.
 *
 * @author plisik
 */
public interface LogicLayer extends NotifiactionSource{
 
	/**
	 * Save to bianry.
	 *
	 * @param fileName the file name
	 * @throws LogicLayerException the logic layer exception
	 */
	//All exports
	void saveToBianry(String fileName) throws LogicLayerException;
	
	/**
	 * Save to XML.
	 *
	 * @param fileName the file name
	 * @throws LogicLayerException the logic layer exception
	 */
	void saveToXML(String fileName) throws LogicLayerException;
	
	/**
	 * Save to ODT.
	 *
	 * @param fileName the file name
	 * @throws LogicLayerException the logic layer exception
	 */
	void saveToODT(String fileName) throws LogicLayerException;
	
	/**
	 * Import from bianry.
	 *
	 * @param fileName the file name
	 * @throws LogicLayerException the logic layer exception
	 */
	//All imports
	void importFromBianry(String fileName) throws LogicLayerException;
	
	/**
	 * Import from XML.
	 *
	 * @param fileName the file name
	 * @throws LogicLayerException the logic layer exception
	 */
	void importFromXML(String fileName) throws LogicLayerException;
	 
	/**
	 * Event between date.
	 *
	 * @param start the start
	 * @param end the end
	 * @return the list
	 */
	//Operations on events
	List<Event> EventBetweenDate(Date start, Date end);
	
	/**
	 * Events by date.
	 *
	 * @return the list
	 */
	List<Event> EventsByDate();
	
	/**
	 * Events on.
	 *
	 * @param start the start
	 * @return the list
	 */
	List<Event> EventsOn(Date start);
	
	/**
	 * Events by number of participants.
	 *
	 * @return the list
	 */
	List<Event> EventsByNumberOfParticipants();
	
	/**
	 * Delete events between dates.
	 *
	 * @param start the start
	 * @param end the end
	 */
	void DeleteEventsBetweenDates(Date start, Date end);
	
	/**
	 * Creates the person.
	 *
	 * @param _name the name
	 * @param _surNam the sur nam
	 */
	/* CRUD PERSON */
	public abstract void createPerson(String _name, String _surNam);
	
	/**
	 * Gets the person.
	 *
	 * @param id the id
	 * @return the person
	 */
	public abstract Person getPerson(int id);
	
	/**
	 * Update person.
	 *
	 * @param id the id
	 * @param p the p
	 */
	public abstract void updatePerson(int id, Person p);
	
	/**
	 * Delete person.
	 *
	 * @param p the p
	 */
	public abstract void deletePerson(Person p);
	
	/**
	 * Delete person.
	 *
	 * @param id the id
	 */
	public abstract void deletePerson(int id);	
	
	/**
	 * Gets the all persons.
	 *
	 * @return the all persons
	 */
	public abstract Map<Integer, Person> getAllPersons();

	/**
	 * Creates the event.
	 *
	 * @param name the name
	 * @param start the start
	 * @param end the end
	 */
	/* CRUD EVENT */
	public abstract void createEvent(String name,Date start, Date end);
	
	/**
	 * Gets the event.
	 *
	 * @param id the id
	 * @return the event
	 */
	public abstract Event getEvent(int id);
	
	/**
	 * Update event.
	 *
	 * @param id the id
	 * @param ev the ev
	 */
	public abstract void updateEvent(int id, Event ev);
	
	/**
	 * Delete event.
	 *
	 * @param ev the ev
	 */
	public abstract void deleteEvent(Event ev);
	
	/**
	 * Delete event.
	 *
	 * @param id the id
	 */
	public abstract void deleteEvent(int id);
	
	/**
	 * Gets the all events.
	 *
	 * @return the all events
	 */
	public abstract Map<Integer, Event> getAllEvents();
	
	/**
	 * Adds the notification.
	 *
	 * @param eventId the event id
	 * @param date the date
	 * @param description the description
	 */
	//Event extension
	public abstract void addNotification(int eventId,Date date, String description);
	
	/**
	 * Removes the notification.
	 *
	 * @param eventId the event id
	 * @param notificationId the notification id
	 */
	public abstract void removeNotification(int eventId,Long notificationId);
	
	/**
	 * Gets the all associated persons.
	 *
	 * @param eventId the event id
	 * @return the all associated persons
	 */
	public abstract Set<Integer> getAllAssociatedPersons(int eventId);
	
	/**
	 * Gets the all notification.
	 *
	 * @param eventId the event id
	 * @return the all notification
	 */
	public abstract Map<Long, Notification>  getAllNotification(int eventId);
	
	/**
	 * Adds the person to event.
	 *
	 * @param eventId the event id
	 * @param personId the person id
	 */
	public abstract void addPersonToEvent(int eventId,int personId);
	
	/**
	 * Removes the person from event.
	 *
	 * @param eventId the event id
	 * @param PersonId the person id
	 */
	public abstract void removePersonFromEvent(int eventId,int PersonId);
	
	/**
	 * Gets the data service.
	 *
	 * @return the data service
	 */
	DataService getDataService();
		
}
