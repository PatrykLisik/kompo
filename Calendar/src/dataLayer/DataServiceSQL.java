package dataLayer;

import java.util.Properties;
import java.util.Vector;
import java.sql.*;
import java.text.MessageFormat;

@SuppressWarnings("serial")
public class DataServiceSQL extends DataServiceNoSQL {

	Connection conn = null;
	Vector<String> querryBuffer = new Vector<String>();
	private static final String MAX_POOL = "250";
	private static final String USERNAME = "calendar";
	private static final String DATABASE_URL = "jdbc:mysql://localhost/calendar_data?verifyServerCertificate=false&useSSL=true&autoReconnect=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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
		super();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DATABASE_URL, getProperties());
		} catch (ClassNotFoundException e) {
			System.out.println("Not connected " + e.getMessage());
			// e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL ext Not connected: " + e.getMessage());
			System.out.println("VendorError: " + e.getErrorCode());
			System.out.println("State: " + e.getSQLState());

			e.printStackTrace();
		}

	}

	public void syncWithDatabase() {
		for (String querry : querryBuffer) {
			try {
				Statement stm = conn.createStatement();
				stm.execute(querry);
			} catch (Exception e) {
				System.out.println(querry);
				System.out.println("DB error: " + e.getMessage());
			}
		}
	}

	@Override
	public void createPerson(Person p) {
		// order is important because person_counter in super class is incremented after
		// person creation
		String querry = MessageFormat.format("INSERT INTO persons VALUES({0},\"{1}\",\"{2}\");", super.personCounter,
				p.getName(), p.getSurname());
		querryBuffer.add(querry);
		super.createPerson(p);

	}

	@Override
	public void updatePerson(int id, Person p) {
		String querry = MessageFormat.format("UPDATE persons  SET id=0, name=\"{0}\", surname=\"{1}\" where id={2};",
				p.getName(), p.getSurname(), id);
		querryBuffer.add(querry);
		super.updatePerson(id, p);

	}

	@Override
	public void deletePerson(Person p) {
		String querry = MessageFormat.format("DELETE FROM persons WHERE name=\"{0}\" and surname=\"{1}\";", p.getName(),
				p.getSurname());
		querryBuffer.add(querry);
		super.deletePerson(p);

	}

	@Override
	public void deletePerson(int id) {
		String querry = MessageFormat.format("DELETE FROM persons WHERE id={0};", id);
		querryBuffer.add(querry);
		super.deletePerson(id);

	}

	@Override
	public void createEvent(Event ev) {
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
	public void addPersonsToEvent(int eventId, Person... persons) {
		// TODO Auto-generated method stub

	}

}
