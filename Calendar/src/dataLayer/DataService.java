package dataLayer;

import java.io.Serializable;
import java.util.HashMap;


/**
 * The Interface DataService.
 * 
 * @author dwojcik
 * 
 */
public interface DataService extends Serializable{
	
	/**
	 * Gets the data context.
	 *
	 * @return the data context
	 */
	public abstract DataContext getDataContext();
	
	/**
	 * Creates the person.
	 *
	 * @param p the person object
	 */
	/* CRUD PERSON */
	public abstract void createPerson(Person p);
	
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
	 * @param p the person object
	 */
	public abstract void updatePerson(int id, Person p);
	
	/**
	 * Delete person.
	 *
	 * @param p the person object
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
	public abstract HashMap<Integer, Person> getAllPersons();

	/**
	 * Creates the event.
	 *
	 * @param ev the ev event object
	 */
	/* CRUD EVENT */
	public abstract void createEvent(Event ev);
	
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
	 * @param ev the event object
	 */
	public abstract void updateEvent(int id, Event ev);
	
	/**
	 * Delete event.
	 *
	 * @param ev the event object
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
	public abstract HashMap<Integer, Event> getAllEvents();

}
