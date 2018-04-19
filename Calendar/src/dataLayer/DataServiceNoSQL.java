/**
 * 
 */
package dataLayer;

import java.util.HashMap;

/**
 * @author plisik
 * Data service implementation of DataService without SQL queries 
 */
public class DataServiceNoSQL implements DataService {

	@Override
	public DataContext getDataContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createPerson(Person p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPerson(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePerson(int id, Person p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePerson(Person p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePerson(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<Integer, Person> getAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createEvent(Event ev) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getEvent(Event ev) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEvent(int id, Event ev) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEvent(Event ev) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEvent(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<Integer, Event> getAllEvents() {
		// TODO Auto-generated method stub
		return null;
	}


}
