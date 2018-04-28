/**
 * 
 */
package logicLayer;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dataLayer.Event;
import dataLayer.Person;
import dataLayer.Event.Notification;

/**
 * @author plisik
 *
 */
public interface LogicLayer {
 
	//All exports
	void saveToBianry(String fileName);
	void saveToXML(String fileName);
	void saveToEvolution(String fileName);
	void saveToTXT(String fileName);
	void saveToGoogleCalendar(String fileName);
	
	//All imports
	void importFromBianry(String fileName);
	void importFromXML(String fileName);
	void importFromEvolution(String fileName);
	void importFromTXT(String fileName);
	void importFromGoogleCalendar(String fileName);
	 
	//Operations on events
	List<Event> EventBetweenDate(Date start, Date end);
	List<Event> EventsByDate();
	List<Event> EventsByNumberOfParticipants();
	void DeleteEventsBetweenDates(Date start, Date end);
	
	/* CRUD PERSON */
	public abstract void createPerson(String _name, String _surNam);
	public abstract Person getPerson(int id);
	public abstract void updatePerson(int id, Person p);
	public abstract void deletePerson(Person p);
	public abstract void deletePerson(int id);	
	public abstract Map<Integer, Person> getAllPersons();

	/* CRUD EVENT */
	public abstract void createEvent(String name,Date start, Date end);
	public abstract Event getEvent(int id);
	public abstract void updateEvent(int id, Event ev);
	public abstract void deleteEvent(Event ev);
	public abstract void deleteEvent(int id);
	public abstract Map<Integer, Event> getAllEvents();
	
	//Event extension
	public abstract void addNotification(int eventId,Date date, String description);
	public abstract void removeNotification(int eventId,Long notificationId);
	public abstract Set<Integer> getAllAssociatedPersons(int eventId);
	public abstract Map<Long, Notification>  getAllNotification(int eventId);
	public abstract void addPersonToEvent(int eventId,int personId);
	public abstract void removePersonFromEvent(int eventId,int PersonId);

	
	
}
