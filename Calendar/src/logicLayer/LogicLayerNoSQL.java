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
 * Implementation of all operations on data in calendar 
 * @author plisik
 *
 */
public class LogicLayerNoSQL implements LogicLayer {

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#saveToXML(java.lang.String)
	 */
	@Override
	public void saveToXML(String fileName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#saveToEvolution(java.lang.String)
	 */
	@Override
	public void saveToEvolution(String fileName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#saveToTXT(java.lang.String)
	 */
	@Override
	public void saveToTXT(String fileName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#saveToGoogleCalendar(java.lang.String)
	 */
	@Override
	public void saveToGoogleCalendar(String fileName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#importFromXML(java.lang.String)
	 */
	@Override
	public void importFromXML(String fileName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#importFromEvolution(java.lang.String)
	 */
	@Override
	public void importFromEvolution(String fileName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#importFromTXT(java.lang.String)
	 */
	@Override
	public void importFromTXT(String fileName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#importFromGoogleCalendar(java.lang.String)
	 */
	@Override
	public void importFromGoogleCalendar(String fileName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#EventBetweenDate(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Event> EventBetweenDate(Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#EventsByDate()
	 */
	@Override
	public List<Event> EventsByDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#EventsByNumberOfParticipants()
	 */
	@Override
	public List<Event> EventsByNumberOfParticipants() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#createPerson(java.lang.String, java.lang.String)
	 */
	@Override
	public void createPerson(String _name, String _surNam) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#getPerson(int)
	 */
	@Override
	public void getPerson(int id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#updatePerson(int, dataLayer.Person)
	 */
	@Override
	public void updatePerson(int id, Person p) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#deletePerson(dataLayer.Person)
	 */
	@Override
	public void deletePerson(Person p) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#deletePerson(int)
	 */
	@Override
	public void deletePerson(int id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#getAllPersons()
	 */
	@Override
	public HashMap<Integer, Person> getAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#createEvent(dataLayer.Event)
	 */
	@Override
	public void createEvent(Event ev) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#getEvent(dataLayer.Event)
	 */
	@Override
	public void getEvent(Event ev) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#updateEvent(int, dataLayer.Event)
	 */
	@Override
	public void updateEvent(int id, Event ev) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#deleteEvent(dataLayer.Event)
	 */
	@Override
	public void deleteEvent(Event ev) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#deleteEvent(int)
	 */
	@Override
	public void deleteEvent(int id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see logicLayer.LogicLayer#getAllEvents()
	 */
	@Override
	public HashMap<Integer, Event> getAllEvents() {
		// TODO Auto-generated method stub
		return null;
	}

}
