/**
 * 
 */
package dataLayer;

import java.util.HashMap;

/**
 * Data service implementation of DataService without SQL queries Class which
 * contains data about events and persons
 * 
 * @author plisik
 */
public class DataServiceNoSQL implements DataService {

	private static final long serialVersionUID = -8592342610457018786L;

	// Structure which actually contains all data
	DataContext data = new DataContext();

	// number of person that will created next
	int personCounter = 0;

	// number of event that will be created next
	int eventCounter = 0;

	@Override
	public DataContext getDataContext() {
		return data;
	}

	@Override
	public void createPerson(Person p) {
		data.Persons.put(personCounter, p);
		personCounter++;

	}

	@Override
	public Person getPerson(int id) {
		return data.Persons.get(id);

	}

	@Override
	public void updatePerson(int id, Person p) {
		if (data.Persons.containsKey(id)) {
			data.Persons.put(id, p);
		} else {
			// TODO exception person not listed
		}

	}

	@Override
	public void deletePerson(Person p) {
		data.Persons.values().remove(p);
	}

	@Override
	public void deletePerson(int id) {
		data.Persons.remove(id);

	}

	@Override
	public HashMap<Integer, Person> getAllPersons() {
		return new HashMap<Integer, Person>(data.Persons);
	}

	@Override
	public void createEvent(Event ev) {
		data.Events.put(eventCounter, ev);
		eventCounter++;

	}

	@Override
	public Event getEvent(int id) {
		return data.Events.get(id);

	}

	@Override
	public void updateEvent(int id, Event ev) {
		if (data.Events.containsKey(id)) {
			data.Events.put(id, ev);
		} else {
			// TODO exception event not listed
		}

	}

	@Override
	public void deleteEvent(Event ev) {
		data.Events.values().remove(ev);

	}

	@Override
	public void deleteEvent(int id) {
		data.Events.remove(id);

	}

	@Override
	public HashMap<Integer, Event> getAllEvents() {
		return new HashMap<Integer, Event>(data.Events);
	}

	@Override
	public void addPersonsToEvent(int eventId, Person... persons) {
		for (Person p : persons) {
			int personId = -1;
			for (HashMap.Entry<Integer, Person> entry : data.Persons.entrySet()) {
				if (p.equals(entry.getValue())) {
					personId = entry.getKey();
				}
			}
			if (personId == -1) {
				// TODO exception person not listed in data
			}
			data.Events.get(eventId).addAssociatedPerson(personId);
		}
	}

	@Override
	public void addPersonsToEvent(int eventId, int... personIDs) {
		if (!data.Events.containsKey(eventId)) {
			// TODO exception event don't exist
		}
		for (int id : personIDs) {
			if (data.Persons.containsKey(id)) {
				data.Events.get(id).addAssociatedPerson(id);
			} else {
				// TODO exception person not listed
			}
		}

	}

}
