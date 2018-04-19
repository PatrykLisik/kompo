package dataLayer;

import java.util.HashMap;

public interface DataService {
	
	public abstract DataContext getDataContext();
	
	/* CRUD PERSON */
	public abstract void createPerson(Person p);
	public abstract Person getPerson(int id);
	public abstract void updatePerson(int id, Person p);
	public abstract void deletePerson(Person p);
	public abstract void deletePerson(int id);
	public abstract HashMap<Integer, Person> getAllPersons();

	/* CRUD EVENT */
	public abstract void createEvent(Event ev);
	public abstract Event getEvent(int id);
	public abstract void updateEvent(int id, Event ev);
	public abstract void deleteEvent(Event ev);
	public abstract void deleteEvent(int id);
	public abstract void addPersonsToEvent(int eventId,Person... persons);
	public abstract void addPersonsToEvent(int eventId,int... personIDs);
	public abstract HashMap<Integer, Event> getAllEvents();

}
