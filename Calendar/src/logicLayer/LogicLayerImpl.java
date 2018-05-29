/**
 * 
 */
package logicLayer;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import dataLayer.DataService;
import dataLayer.DataServiceNoSQL;
import dataLayer.Event;
import dataLayer.Event.Notification;
import dataLayer.Person;

/**
 * Implementation of all operations on data in calendar without SQL queries 
 * 
 * @author plisik
 *
 */
public class LogicLayerImpl implements LogicLayer {
	DataService data;
	
	public LogicLayerImpl() {
		data = new DataServiceNoSQL();
	}

	public LogicLayerImpl(DataService data) {
		super();
		this.data = data;
	}

	/**
	 * Generic method to save 
	 * @param fileName
	 * @param saver
	 * @throws LogicLayerException 
	 */
	private void save(String fileName, Saver saver) throws LogicLayerException {
		saver.save(fileName,data);
	}

	/**
	 * Generic method to import
	 * 
	 * @param fileName
	 * @param saver
	 * @throws LogicLayerException 
	 */
	private void importData(String fileName, Importer importer) throws LogicLayerException {
		data = importer.importData(fileName);
	}

	@Override
	public void saveToBianry(String fileName) throws LogicLayerException {
		this.save(fileName, new BinarySaver());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#saveToXML(java.lang.String)
	 */
	@Override
	public void saveToXML(String fileName) throws LogicLayerException {
		this.save(fileName, new XMLSaver());

	}
	
	@Override
	public void saveToODT(String fileName) throws LogicLayerException {
		this.save(fileName,new OpenOfficeSaver());
		
	}

	
	@Override
	public void importFromBianry(String fileName) throws LogicLayerException {
		Importer imp = new BinaryImporter();
		data = imp.importData(fileName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logicLayer.LogicLayer#importFromXML(java.lang.String)
	 */
	@Override
	public void importFromXML(String fileName) throws LogicLayerException {
		this.importData(fileName,new XMLImporter());

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
	
	
	@Override
	public List<Event> EventsOn(Date start) {
		return SortingAndSearchPolicies.eventsOn(data, start);
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
	public void addNotification(int EventId, Date date, String description) {
		Event ev=data.getEvent(EventId);
		ev.addNotification(date,description);
		data.updateEvent(EventId,ev);
		
	}

	@Override
	public void removeNotification(int EventId, Long NotificationId) {
		Event ev=data.getEvent(EventId);
		Map<Long,Notification> notifications=this.getAllNotification(EventId);
		notifications.remove(NotificationId);
		ev.setNotifications(notifications);
		data.updateEvent(EventId,ev);
		
	}

	@Override
	public Set<Integer> getAllAssociatedPersons(int eventId) {
		return data.getEvent(eventId).getAssociatedPersons();
	}

	@Override
	public Map<Long, Notification> getAllNotification(int eventId) {
		return data.getEvent(eventId).getNotifications();
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

	@Override
	public List<Notification> getAllNotifications() {
		//the following example shows that loops in java are redundant and should be removed 
		List<Event> eventList=getAllEvents().values().stream().collect( Collectors.toList());
		List<Notification> ans=eventList.stream()
				.map(event->
						event.getNotifications(). //gets map<integer,Notification>
						values().stream(). // stream of Notifications
						collect( Collectors.toList())
					) //conversion to List of List of Notification
				.flatMap(notification->notification.stream()) //convert from list of list to list
				.collect( Collectors.toList());
		
		return ans;
	}

	@Override
	public DataService getDataService() {
		return data;
	}





}
