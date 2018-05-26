package dataLayer;

import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import java.util.stream.Collectors;

import dataLayer.Event.Notification;

import java.sql.*;
import java.text.MessageFormat;

@SuppressWarnings("serial")
public class DataServiceSQL extends DataServiceNoSQL {

	Connection conn = null;
	Vector<PreparedStatement> querryBuffer = new Vector<PreparedStatement>();
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
		for (PreparedStatement querry : querryBuffer) {
			try {
				querry.execute();
			} catch (SQLException e) {
				System.out.println(querry);
				e.printStackTrace();
			}
		}
	}

	@Override
	public void createPerson(Person p) {
		// order is important because person_counter in super class is incremented after
		// person creation
		String querry = "INSERT INTO persons VALUES( ? , ? , ? );";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setInt(1, super.personCounter);
			stmt.setString(2, p.getName());
			stmt.setString(3, p.getSurname());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.createPerson(p);

	}

	@Override
	public void updatePerson(int id, Person p) {
		String querry = "UPDATE persons  SET name= ?, surname= ? where id= ? ;";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setString(1, p.getName());
			stmt.setString(2, p.getSurname());
			stmt.setInt(3, id);
			querryBuffer.add(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.updatePerson(id, p);

	}

	@Override
	public void deletePerson(Person p) {
		String querry = "DELETE FROM persons WHERE name= ? and surname= ?;";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setString(1, p.getName());
			stmt.setString(2, p.getSurname());
			querryBuffer.add(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.deletePerson(p);

	}

	@Override
	public void deletePerson(int id) {
		String querry = "DELETE FROM persons WHERE id= ?;";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setInt(1, id);
			querryBuffer.add(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.deletePerson(id);

	}

	@Override
	public void createEvent(Event ev) {
		String querry = "INSERT INTO events VALUES(?, ?, ?, ?);";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setInt(1, super.eventCounter);
			stmt.setString(2, ev.getName());
			stmt.setDate(3, new java.sql.Date(ev.getStart().getTime()));
			stmt.setDate(4, new java.sql.Date(ev.getEnd().getTime()));
			querryBuffer.add(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.createEvent(ev);

	}

	@Override
	public void updateEvent(int id, Event ev) {
		String querry = "UPDATE events  SET name= ?, start= ?, end = ? where id= ? ;";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setString(1, ev.getName());
			stmt.setDate(2, new java.sql.Date(ev.getStart().getTime()));
			stmt.setDate(3, new java.sql.Date(ev.getEnd().getTime()));
			stmt.setInt(4, id);
			querryBuffer.add(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String deleteNotifications = "DELETE FROM "
		for(Notification n: ev.getNotifications().values() ) {
			this.addNotification(n);
			
		}
		super.updateEvent(id, ev);

	}

	@Override
	public void deleteEvent(Event ev) {
		String querry = "DELETE FROM events WHERE name= ? and start= ? and end = ?;";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setString(1, ev.getName());
			stmt.setDate(2, new java.sql.Date(ev.getStart().getTime()));
			stmt.setDate(3, new java.sql.Date(ev.getEnd().getTime()));
			querryBuffer.add(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.deleteEvent(ev);

	}

	@Override
	public void deleteEvent(int id) {
		String querry = "DELETE FROM events WHERE ?;";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setInt(1, id);
			querryBuffer.add(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.deleteEvent(id);

	}

	public void addPersonToEvent(int personId, int eventId) {
		String querry = "INSERT INTO event_person VALUES(?, ?);";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setInt(1, personId);
			stmt.setInt(2, eventId);
			querryBuffer.add(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void addNotification(Notification n) {
		String querry = "INSERT INTO event_person VALUES(?, ?, ?);";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setInt(1, (int) n.getId());
			stmt.setString(2, n.getDescripton());
			stmt.setDate(3, new java.sql.Date(n.getDate().getTime()));
			querryBuffer.add(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
