/**
 * 
 */
package logicLayer;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import dataLayer.Event;
import dataLayer.Person;

/**
 * @author plisik
 *
 */
public interface LogicLayer {
 
	//All exports
	void saveToXML(String fileName);
	void saveToEvolution(String fileName);
	void saveToTXT(String fileName);
	void saveToGoogleCalendar(String fileName);
	
	//All imports 
	void importFromXML(String fileName);
	void importFromEvolution(String fileName);
	void importFromTXT(String fileName);
	void importFromGoogleCalendar(String fileName);
	 
	//Operations on events
	List<Event> EventBetweenDate(Date start, Date end);
	List<Event> EventsByDate();
	List<Event> EventsByNumberOfParticipants();
	
	/* CRUD PERSON */
	public abstract void createPerson(String _name, String _surNam);
	public abstract void getPerson(int id);
	public abstract void updatePerson(int id, Person p);
	public abstract void deletePerson(Person p);
	public abstract void deletePerson(int id);	
	public abstract HashMap<Integer, Person> getAllPersons();

	/* CRUD EVENT */
	public abstract void createEvent(Event ev);
	public abstract void getEvent(Event ev);
	public abstract void updateEvent(int id, Event ev);
	public abstract void deleteEvent(Event ev);
	public abstract void deleteEvent(int id);
	public abstract HashMap<Integer, Event> getAllEvents();

	
	
}
