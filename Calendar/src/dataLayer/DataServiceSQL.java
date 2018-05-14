package dataLayer;

import java.util.HashMap;
import java.util.Properties;
import java.sql.*;
@SuppressWarnings("serial")
public class DataServiceSQL implements DataService {

	Connection conn=null;
	private static final String MAX_POOL = "250";
	private static final String USERNAME = "calendar";
	private static final String DATABASE_URL="jdbc:mysql://localhost/calendar_data?verifyServerCertificate=false&useSSL=true&autoReconnect=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String PASSWORD = "Calendar1!";
    private Properties properties;
    // create properties
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }
	public DataServiceSQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn = DriverManager.getConnection(DATABASE_URL, getProperties());
		} catch (ClassNotFoundException e) {
			System.out.println("Not connected " + e.getMessage());
			//e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL ext Not connected: " + e.getMessage());
			System.out.println("VendorError: " + e.getErrorCode());
			System.out.println("State: " + e.getSQLState());

			e.printStackTrace();
		}

	}

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
	public Person getPerson(int id) {
		// TODO Auto-generated method stub
		return null;
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
	public Event getEvent(int id) {
		// TODO Auto-generated method stub
		return null;
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
	public void addPersonsToEvent(int eventId, Person... persons) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPersonsToEvent(int eventId, int... personIDs) {
		// TODO Auto-generated method stub

	}

	@Override
	public HashMap<Integer, Event> getAllEvents() {
		// TODO Auto-generated method stub
		return null;
	}

}
