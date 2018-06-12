package dataLayer;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import dataLayer.Event.Notification;

import java.sql.*;

/**
 * Data service which has same functionality like DataServiceNoSQL version, but
 * with every action buffers query to data base use @method syncWithDatabase to
 * save changes to data base.
 *
 * @author plisik
 */

public class DataServiceSQL extends DataServiceNoSQL implements DataBaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4222814676917565076L;
	private static final String MAX_POOL = "250";
	private static final String USERNAME = "calendar";
	private static final String DATABASE_URL = "jdbc:mysql://localhost/calendar_data?verifyServerCertificate=false&useSSL=true&autoReconnect=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String PASSWORD = "Calendar1!";
	private transient Connection conn = null;
	// Statement that
	private transient Statement Gstmt = null;
	private Properties properties = null;

	/**
	 * Constructor tries to establish connection with data base.
	 */
	public DataServiceSQL() {
		super();

		// Establish connection with database
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DATABASE_URL, getProperties());
			conn.setAutoCommit(false);
			Gstmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("Not connected " + e.getMessage());
			// e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL ext Not connected: " + e.getMessage());
			System.out.println("VendorError: " + e.getErrorCode());
			System.out.println("State: " + e.getSQLState());

			e.printStackTrace();
		}

		loadFromDatabase();

	}

	/**
	 * Delete current data and load from database
	 */
	@Override
	public void loadFromDatabase() {
		super.data = this.pullFromDataBase();
	}

	/**
	 * Adds the notification.
	 *
	 * @param n
	 *            the notification
	 */
	public void addNotification(Notification n) {
		String querry = "INSERT INTO notifications VALUES(?, ?, ?);";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setInt(1, (int) n.getId());
			stmt.setString(2, n.getDescripton());
			stmt.setTimestamp(3, new java.sql.Timestamp(n.getDate().getTime()));
			this.Gstmt.addBatch(getSQL(stmt));
			System.out.println(getSQL(stmt));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create entry that connects event and notification in database
	 * 
	 * @param notificationId
	 *            the notification id
	 * @param eventId
	 *            the event id
	 */
	public void addNotificationToEvent(int notificationId, int eventId) {
		String querry = "INSERT INTO notifications_events VALUES(?, ?);";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setInt(1, notificationId);
			stmt.setInt(2, eventId);
			this.Gstmt.addBatch(getSQL(stmt));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create database entry with person and event
	 * 
	 * @param personId
	 *            id of person
	 * @param eventId
	 *            id of event
	 */
	public void addPersonToEvent(int personId, int eventId) {
		String querry = "INSERT INTO event_person VALUES(?, ?);";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setInt(1, personId);
			stmt.setInt(2, eventId);
			this.Gstmt.addBatch(getSQL(stmt));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Add event to database and local structure
	 */
	@Override
	public void createEvent(Event ev) {
		String querry = "INSERT INTO events VALUES(?, ?, ?, ? );";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setInt(1, super.eventCounter);
			stmt.setString(2, ev.getName());
			stmt.setTimestamp(3, new java.sql.Timestamp(ev.getStart().getTime()));
			stmt.setTimestamp(4, new java.sql.Timestamp(ev.getEnd().getTime()));
			this.Gstmt.addBatch(getSQL(stmt));
			System.out.println(getSQL(stmt));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		super.createEvent(ev);
		this.updateNotificationsOfEvent(ev);

	}

	/**
	 * Add person to database and local structure
	 */
	@Override
	public void createPerson(Person p) {
		// order is important because person_counter in super class is incremented after
		// person creation
		String querry = "INSERT INTO persons VALUES( ? , ? , ? );";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {

			stmt.setInt(1, super.personCounter);
			stmt.setString(2, p.getName());
			stmt.setString(3, p.getSurname());
			this.Gstmt.addBatch(getSQL(stmt));
			System.out.println(getSQL(stmt));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.createPerson(p);

	}

	/**
	 * Delete event from database and local structure
	 */
	@Override
	public void deleteEvent(Event ev) {

		this.delteNotificationsOfEvent(ev);

		String querry = "DELETE FROM events WHERE name= ? and start= ? and end = ?;";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setString(1, ev.getName());
			stmt.setTimestamp(2, new java.sql.Timestamp(ev.getStart().getTime()));
			stmt.setTimestamp(3, new java.sql.Timestamp(ev.getEnd().getTime()));
			this.Gstmt.addBatch(getSQL(stmt));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		super.deleteEvent(ev);

	}

	/**
	 * Delete event with particular id from database and local structure
	 * 
	 * @param id
	 *            id of event to delete
	 */
	@Override
	public void deleteEvent(int id) {

		this.delteNotificationsOfEvent(id);

		String querry = "DELETE FROM events WHERE id= ?;";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setInt(1, id);
			this.Gstmt.addBatch(getSQL(stmt));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		super.deleteEvent(id);

	}

	/**
	 * Delete person with particular id from database and local structure
	 * 
	 * @param id
	 *            id of person to delete
	 */
	@Override
	public void deletePerson(int id) {
		String querry = "DELETE FROM persons WHERE id= ?;";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setInt(1, id);
			this.Gstmt.addBatch(getSQL(stmt));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.deletePerson(id);

	}

	/**
	 * Delete person from database and local structure
	 * 
	 * @param p
	 *            id of person to delete
	 */
	@Override
	public void deletePerson(Person p) {
		String querry = "DELETE FROM persons WHERE name= ? and surname= ?;";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setString(1, p.getName());
			stmt.setString(2, p.getSurname());
			this.Gstmt.addBatch(getSQL(stmt));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.deletePerson(p);

	}

	/**
	 * 
	 * Notifications of particular event will be removed from database
	 * 
	 * @param ev
	 *            event to delete
	 */
	public void delteNotificationsOfEvent(Event ev) {
		String querry = "DELETE FROM notifications WHERE id IN "
				+ "(SELECT notification_id FROM  notifications_events WHERE event_id IN"
				+ " (SELECT id FROM events WHERE name= ? and start= ? and end = ? ));";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setString(1, ev.getName());
			stmt.setTimestamp(2, new java.sql.Timestamp(ev.getStart().getTime()));
			stmt.setTimestamp(3, new java.sql.Timestamp(ev.getEnd().getTime()));
			this.Gstmt.addBatch(getSQL(stmt));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Notifications of particular event will be removed from database
	 * 
	 * @param eventId
	 *            id of event
	 */
	public void delteNotificationsOfEvent(int eventId) {
		String querry = "DELETE FROM notifications WHERE id IN (SELECT notification_id FROM  notifications_events WHERE event_id= ?);";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setInt(1, eventId);
			this.Gstmt.addBatch(getSQL(stmt));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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

	/**
	 * Remove first part of PreparedStatement class name from toString
	 * 
	 * @param stmt
	 *            to extract SQL-query
	 * @return string with SQL-query
	 */
	private String getSQL(PreparedStatement stmt) {
		String parts[] = stmt.toString().split("com.mysql.cj.jdbc.ClientPreparedStatement:");
		return parts[1];

	}

	/**
	 * Save changes to database
	 */
	@Override
	public void saveToDatabase() {
		try {
			Gstmt.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("VendorError: " + e.getErrorCode());
			System.out.println("State: " + e.getSQLState());
		}

	}

	/**
	 * Create data context from database
	 * 
	 * @return
	 */
	private DataContext pullFromDataBase() {
		DataContext ret = new DataContext();
		ret.Events = this.pullEventFromDatabase();
		ret.Persons = this.pullPersonFromDatabase();
		if (ret.Persons.keySet().size() > 0) {
			super.personCounter = Collections.max(ret.Persons.keySet()) + 1;
		} else {
			super.personCounter = 1;
		}

		if (ret.Events.keySet().size() > 0) {
			super.eventCounter = Collections.max(ret.Events.keySet()) + 1;
		} else {
			super.eventCounter = 1;
		}

		return ret;
	}

	private HashMap<Integer, Event> pullEventFromDatabase() {

		String querry = "SELECT * FROM events;";
		HashMap<Integer, Event> ret = new HashMap<Integer, Event>();
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Integer EventID = rs.getInt("id");
				Event ev = new Event(rs.getString("name"), rs.getDate("start"), rs.getDate("end"));
				ev.setAssociatedPersons(this.getPersonsOfEvent(EventID));
				ev.setNotifications(this.getNotificationOfEvent(EventID));
				ret.put(EventID, ev);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	private Set<Integer> getPersonsOfEvent(Integer eventId) {
		String querry = "SELECT * FROM event_person WHERE  event_id = ?;";
		Set<Integer> ret = new HashSet<Integer>();
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setInt(1, eventId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ret.add(rs.getInt("person_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	private HashMap<Long, Notification> getNotificationOfEvent(Integer eventId) {
		String querry = "SELECT * FROM notifications WHERE id IN "
				+ "(SELECT notification_id FROM notifications_events WHERE event_id = ?);";
		HashMap<Long, Notification> ret = new HashMap<Long, Notification>();
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setInt(1, eventId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int notification_id = rs.getInt("notification_id");
				ret.put((long) notification_id,
						new Notification(rs.getDate("notify_date"), rs.getString("description"), notification_id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	private HashMap<Integer, Person> pullPersonFromDatabase() {
		String querry = "SELECT * FROM persons;";
		HashMap<Integer, Person> ret = new HashMap<Integer, Person>();
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ret.put(rs.getInt("id"), new Person(rs.getString("name"), rs.getString("surname")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dataLayer.DataServiceNoSQL#updateEvent(int, dataLayer.Event)
	 */
	@Override
	public void updateEvent(int id, Event ev) {
		String querry = "UPDATE events  SET name= ?, start= ?, end = ? where id= ? ;";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setString(1, ev.getName());
			stmt.setTimestamp(2, new java.sql.Timestamp(ev.getStart().getTime()));
			stmt.setTimestamp(3, new java.sql.Timestamp(ev.getEnd().getTime()));
			stmt.setInt(4, id);
			this.Gstmt.addBatch(getSQL(stmt));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.updateEvent(id, ev);
		updateNotificationsOfEvent(ev);

	}

	private Integer getIdOfEvent(Event ev) {

		for (Integer o : super.getAllEvents().keySet()) {
			if (super.getAllEvents().get(o).equals(ev)) {
				return o;
			}
		}
		return 0;
	}

	private void updateNotificationsOfEvent(Event ev) {
		this.delteNotificationsOfEvent(ev);
		System.out.print(ev.equals(ev));
		for (Notification n : ev.getNotifications().values()) {
			this.addNotification(n);
			this.addNotificationToEvent((int) n.getId(), getIdOfEvent(ev));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dataLayer.DataServiceNoSQL#updatePerson(int, dataLayer.Person)
	 */
	@Override
	public void updatePerson(int id, Person p) {
		String querry = "UPDATE persons  SET name= ?, surname= ? where id= ? ;";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setString(1, p.getName());
			stmt.setString(2, p.getSurname());
			stmt.setInt(3, id);
			this.Gstmt.addBatch(getSQL(stmt));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.updatePerson(id, p);

	}

}
