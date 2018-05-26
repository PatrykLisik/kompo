package dataLayer;

import java.util.Properties;
import dataLayer.Event.Notification;

import java.sql.*;

@SuppressWarnings("serial")
public class DataServiceSQL extends DataServiceNoSQL {

	private static final String MAX_POOL = "250";
	private static final String USERNAME = "calendar";
	private static final String DATABASE_URL = "jdbc:mysql://localhost/calendar_data?verifyServerCertificate=false&useSSL=true&autoReconnect=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String PASSWORD = "Calendar1!";
	private Connection conn = null;
	private Statement Gstmt = null;
	private Properties properties = null;

	public DataServiceSQL() {
		super();
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

	}

	public void addNotification(Notification n) {
		String querry = "INSERT INTO notifications VALUES(?, ?, ?);";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setInt(1, (int) n.getId());
			stmt.setString(2, n.getDescripton());
			stmt.setTimestamp(3, new java.sql.Timestamp(n.getDate().getTime()));
			this.Gstmt.addBatch(getSQL(stmt));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

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

	public void addPersonToEvent(int personId, int eventId) {
		String querry = "INSERT INTO event_person VALUES(?, ?);";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setInt(1, personId);
			stmt.setInt(2, eventId);
			System.out.println(getSQL(stmt));
			this.Gstmt.addBatch(getSQL(stmt));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createEvent(Event ev) {
		String querry = "INSERT INTO events VALUES(?, ?, ?, ? );";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setInt(1, super.eventCounter);
			stmt.setString(2, ev.getName());
			stmt.setTimestamp(3, new java.sql.Timestamp(ev.getStart().getTime()));
			stmt.setTimestamp(4, new java.sql.Timestamp(ev.getEnd().getTime()));
			System.out.println(getSQL(stmt));
			this.Gstmt.addBatch(getSQL(stmt));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.updateNotificationsOfEvent(ev);
		super.createEvent(ev);

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
			System.out.println(getSQL(stmt));
			this.Gstmt.addBatch(getSQL(stmt));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.createPerson(p);

	}

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
	 * @return
	 */
	private String getSQL(PreparedStatement stmt) {
		String parts[] = stmt.toString().split("com.mysql.cj.jdbc.ClientPreparedStatement:");
		return parts[1];

	}

	public void syncWithDatabase() {
		try {
			Gstmt.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateEvent(int id, Event ev) {
		String querry = "\\UPDATE events  SET name= ?, start= ?, end = ? where id= ? ;";
		try (PreparedStatement stmt = conn.prepareStatement(querry)) {
			stmt.setString(1, ev.getName());
			stmt.setTimestamp(2, new java.sql.Timestamp(ev.getStart().getTime()));
			stmt.setTimestamp(3, new java.sql.Timestamp(ev.getEnd().getTime()));
			stmt.setInt(4, id);
			this.Gstmt.addBatch(getSQL(stmt));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Delete previous notifications and add present

		updateNotificationsOfEvent(ev);
		super.updateEvent(id, ev);

	}

	private void updateNotificationsOfEvent(Event ev) {
		this.delteNotificationsOfEvent(ev);
		for (Notification n : ev.getNotifications().values()) {
			this.addNotification(n);

		}
	}

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
