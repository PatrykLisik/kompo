/**
 * 
 */
package logicLayer;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dataLayer.DataService;
import dataLayer.DataServiceNoSQL;
import dataLayer.Event;
import dataLayer.Person;

/**
 * Implementation of all operations on data in calendar without SQL queries 
 * 
 * @author plisik
 *
 */
public class LogicLayerNoSQL implements LogicLayer {
	DataService data = new DataServiceNoSQL();

	/**
	 * Generic method to save 
	 * @param fileName
	 * @param saver
	 */
	private void save(String fileName, Saver saver) {
		saver.save(fileName,data);
	}

	/**
	 * Generic method to import
	 * 
	 * @param fileName
	 * @param saver
	 */
	private void importData(String fileName, Importer importer) {
		data = importer.importData(fileName);
	}

	@Override
	public void saveToBianry(String fileName) {
		this.save(fileName, new BianrySaver());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#saveToXML(java.lang.String)
	 */
	@Override
	public void saveToXML(String fileName) {
		this.save(fileName, new XMLSaver());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#saveToEvolution(java.lang.String)
	 */
	@Override
	public void saveToEvolution(String fileName) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#saveToTXT(java.lang.String)
	 */
	@Override
	public void saveToTXT(String fileName) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#saveToGoogleCalendar(java.lang.String)
	 */
	@Override
	public void saveToGoogleCalendar(String fileName) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#importFromBianry(java.lang.String)
	 */
	@Override
	public void importFromBianry(String fileName) {
		Importer imp = new BinaryImporter();
		data = imp.importData(fileName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#importFromXML(java.lang.String)
	 */
	@Override
	public void importFromXML(String fileName) {
		this.importData(fileName,new XMLImporter());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#importFromEvolution(java.lang.String)
	 */
	@Override
	public void importFromEvolution(String fileName) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#importFromTXT(java.lang.String)
	 */
	@Override
	public void importFromTXT(String fileName) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#importFromGoogleCalendar(java.lang.String)
	 */
	@Override
	public void importFromGoogleCalendar(String fileName) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#EventBetweenDate(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Event> EventBetweenDate(Date start, Date end) {
		return SortingAndSearchPolicies.eventsBetweenDates(data,start,end);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#EventsByDate()
	 */
	@Override
	public List<Event> EventsByDate() {
		return SortingAndSearchPolicies.eventsByDate(data);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#EventsByNumberOfParticipants()
	 */
	@Override
	public List<Event> EventsByNumberOfParticipants() {
		return SortingAndSearchPolicies.eventsByNumberOfAssociatedPersons(data);
	}

	@Override
	public void DeleteEventsBetweenDates(Date start, Date end) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#createPerson(java.lang.String, java.lang.String)
	 */
	@Override
	public void createPerson(String name, String surname) {
		Person p = new Person(name, surname);
		data.createPerson(p);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#getPerson(int)
	 */
	@Override
	public Person getPerson(int id) {
		return data.getPerson(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#updatePerson(int, dataLayer.Person)
	 */
	@Override
	public void updatePerson(int id, Person p) {
		data.updatePerson(id, p);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#deletePerson(dataLayer.Person)
	 */
	@Override
	public void deletePerson(Person p) {
		data.deletePerson(p);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#deletePerson(int)
	 */
	@Override
	public void deletePerson(int id) {
		data.deletePerson(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#getAllPersons()
	 */
	@Override
	public Map<Integer, Person> getAllPersons() {
		return data.getAllPersons();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#createEvent(dataLayer.Event)
	 */
	@Override
	public void createEvent(String name,Date start, Date end) {
		Event ev = new Event(name,start, end);
		data.createEvent(ev);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#getEvent(dataLayer.Event)
	 */
	@Override
	public Event getEvent(int id) {
		return data.getEvent(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#updateEvent(int, dataLayer.Event)
	 */
	@Override
	public void updateEvent(int id, Event ev) {
		data.updateEvent(id, ev);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#deleteEvent(dataLayer.Event)
	 */
	@Override
	public void deleteEvent(Event ev) {
		data.deleteEvent(ev);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#deleteEvent(int)
	 */
	@Override
	public void deleteEvent(int id) {
		data.deleteEvent(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#getAllEvents()
	 */
	@Override
	public Map<Integer, Event> getAllEvents() {
		return data.getAllEvents();
	}


	@Override
	public void addRemainder(int EventId, Date date, String description) {
		Event ev=data.getEvent(EventId);
		ev.addRemainder(date,description);
		data.updateEvent(EventId,ev);
		
	}

	@Override
	public void removeRemainder(int EventId, Date date) {
		Event ev=data.getEvent(EventId);
		Map<Date, String> remainders=this.getAllRemainders(EventId);
		remainders.remove(date);
		ev.setRemainders(remainders);
		data.updateEvent(EventId,ev);
		
	}

	@Override
	public Set<Integer> getAllAssociatedPersons(int eventId) {
		return data.getEvent(eventId).getAssociatedPersons();
	}

	@Override
	public Map<Date, String> getAllRemainders(int eventId) {
		return data.getEvent(eventId).getRemainders();
	}

	@Override
	public void addPersonToEvent(int EventId, int PersonId) {
		Event event=data.getEvent(EventId);
		event.addAssociatedPerson(PersonId);
		data.updateEvent(EventId,event);
		
	}

	@Override
	public void removePersonFromEvent(int EventId, int PersonId) {
		Event event=data.getEvent(EventId);
		Set<Integer> persons=event.getAssociatedPersons();
		persons.remove(PersonId);
		event.setAssociatedPersons(persons);
		data.updateEvent(EventId,event);
		
	}



}
