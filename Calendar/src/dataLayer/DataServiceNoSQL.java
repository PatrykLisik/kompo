/**
 * 
 */
package dataLayer;

import java.util.HashMap;


/**
 * Data service implementation of DataService without SQL queries Class which
 * contains data about events and persons.
 *
 * @author plisik
 */
public class DataServiceNoSQL implements DataService {

	private static final long serialVersionUID = -8592342610457018786L;

	/** The data. */
	// Structure which actually contains all data
	DataContext data = new DataContext();

	/** The person counter. */
	// number of person that will created next
	protected int personCounter = 0;

	/** The event counter. */
	// number of event that will be created next
	protected int eventCounter = 0;

	/* (non-Javadoc)
	 * @see dataLayer.DataService#getDataContext()
	 */
	@Override
	public DataContext getDataContext() {
		return data;
	}

	/* (non-Javadoc)
	 * @see dataLayer.DataService#createPerson(dataLayer.Person)
	 */
	@Override
	public void createPerson(Person p) {
		data.Persons.put(personCounter, p);
		personCounter++;

	}

	/* (non-Javadoc)
	 * @see dataLayer.DataService#getPerson(int)
	 */
	@Override
	public Person getPerson(int id) {
		return data.Persons.get(id);

	}

	/* (non-Javadoc)
	 * @see dataLayer.DataService#updatePerson(int, dataLayer.Person)
	 */
	@Override
	public void updatePerson(int id, Person p) {
		if (data.Persons.containsKey(id)) {
			data.Persons.put(id, p);
		} else {
			// TODO exception person not listed
		}

	}

	/* (non-Javadoc)
	 * @see dataLayer.DataService#deletePerson(dataLayer.Person)
	 */
	@Override
	public void deletePerson(Person p) {
		data.Persons.values().remove(p);
	}

	/* (non-Javadoc)
	 * @see dataLayer.DataService#deletePerson(int)
	 */
	@Override
	public void deletePerson(int id) {
		data.Persons.remove(id);

	}

	/* (non-Javadoc)
	 * @see dataLayer.DataService#getAllPersons()
	 */
	@Override
	public HashMap<Integer, Person> getAllPersons() {
		return new HashMap<Integer, Person>(data.Persons);
	}

	/* (non-Javadoc)
	 * @see dataLayer.DataService#createEvent(dataLayer.Event)
	 */
	@Override
	public void createEvent(Event ev) {
		data.Events.put(eventCounter, ev);
		eventCounter++;

	}

	/* (non-Javadoc)
	 * @see dataLayer.DataService#getEvent(int)
	 */
	@Override
	public Event getEvent(int id) {
		return data.Events.get(id);

	}

	/* (non-Javadoc)
	 * @see dataLayer.DataService#updateEvent(int, dataLayer.Event)
	 */
	@Override
	public void updateEvent(int id, Event ev) {
		if (data.Events.containsKey(id)) {
			data.Events.put(id, ev);
		} else {
			// TODO exception event not listed
		}

	}

	/* (non-Javadoc)
	 * @see dataLayer.DataService#deleteEvent(dataLayer.Event)
	 */
	@Override
	public void deleteEvent(Event ev) {
		data.Events.values().remove(ev);

	}

	/* (non-Javadoc)
	 * @see dataLayer.DataService#deleteEvent(int)
	 */
	@Override
	public void deleteEvent(int id) {
		data.Events.remove(id);

	}

	/* (non-Javadoc)
	 * @see dataLayer.DataService#getAllEvents()
	 */
	@Override
	public HashMap<Integer, Event> getAllEvents() {
		return new HashMap<Integer, Event>(data.Events);
	}

}
