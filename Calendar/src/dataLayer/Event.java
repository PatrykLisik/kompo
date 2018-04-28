package dataLayer;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Event is class which represents event in calendar and contains information about
 * Persons whose are associated with event
 * Remainders date and descriptions
 * By default every event has two remainders one day before and on start 
 * 
 * @author plisik
 *
 */
public class Event implements Serializable {

	private static final long serialVersionUID = -4070684017733510355L;
	Date start;
	Date end;
	String name;
	/**
	 * associatedPersons stores IDs of Persons associated with event There is
	 * no reason to store duplicated associated persons, so set class is used
	 * 
	 */
	Set<Integer> associatedPersons = new TreeSet<Integer>();
	/**
	 * notification stores date when calendar should notify user about event
	 * There is no reason to store duplicated remainders date
	 * 
	 */
	public static class Notification implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = -1858674304681020987L;
		Date date;
		String descripton;
		long id;
		static long NotifiactionCounter=0;
		public Notification(Date date, String descripton) {
			super();
			this.date = date;
			this.descripton = descripton;
			this.id=NotifiactionCounter;
			NotifiactionCounter++;

		}

		/**
		 * @return the id
		 */
		public long getId() {
			return id;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getDescripton() {
			return descripton;
		}

		public void setDescripton(String descripton) {
			this.descripton = descripton;
		}

	
		
		
	}
	Map<Long,Notification> notification = new TreeMap<Long,Notification>();

	public Map<Long, Notification> getNotifications() {
		return notification;
	}

	public void setNotifications(Map<Long, Notification> remainders) {
		this.notification = remainders;
	}

	public void addNotification(Date date, String descripton) {
		Notification n=new Notification(date, descripton);
		this.notification.put(n.getId(),n);
	}

	public Event(String name, Date start, Date end, Set<Integer> associatedPersons) {
		this(name, start, end);
		this.associatedPersons = associatedPersons;
	}

	/**
	 * @param start
	 * @param end
	 */
	public Event(String name, Date start, Date end) {
		this.start = start;
		this.end = end;
		this.name = name;

		// Default Remainders
		this.addNotification(start,"is starting now");
		this.addNotification(this.subtractDay(start), "is going to start in one day");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param
	 */
	public void addAssociatedPerson(Integer personId) {
		associatedPersons.add(personId);
	}

	/**
	 * @return the start
	 */
	public Date getStart() {
		return start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(Date start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public Date getEnd() {
		return end;
	}

	/**
	 * @param end
	 *            the end to set
	 */
	public void setEnd(Date end) {
		this.end = end;
	}

	/**
	 * @return the associatedPersons
	 */
	public Set<Integer> getAssociatedPersons() {
		return associatedPersons;
	}

	/**
	 * @param associatedPersons
	 *            the associatedPersons to set
	 */
	public void setAssociatedPersons(Set<Integer> associatedPersons) {
		this.associatedPersons = associatedPersons;
	}

	private Date subtractDay(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}
}
