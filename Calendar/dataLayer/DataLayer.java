package dataLayer;

public interface DataLayer {

	/* CRUD PERSON */
	public abstract void createPerson(Person p);

	public abstract void readPerson(Person p);

	public abstract void updatePerson(Person p);

	public abstract void updatePerson(int pos, Person p);

	public abstract void deletePerson(Person p);

	public abstract void deletePerson(int pos);

	/* CRUD EVENT */
	public abstract void createEvent(Event ev);

	public abstract void readEvent(Event ev);

	public abstract void updateEvent(Event ev);

	public abstract void updateEvent(int pos, Event ev);

	public abstract void deleteEvent(Event ev);

	public abstract void deleteEvent(int pos);

}
