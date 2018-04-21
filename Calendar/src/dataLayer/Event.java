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
	 * remainders stores date when calendar should notify user about event
	 * There is no reason to store duplicated remainders date
	 * 
	 */
	Map<Date, String> remainders = new TreeMap<Date, String>();

	public Map<Date, String> getRemainders() {
		return remainders;
	}

	public void setRemainders(Map<Date, String> remainders) {
		this.remainders = remainders;
	}

	public void addRemainder(Date date, String descripton) {
		this.remainders.put(date, descripton);
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

		// Deafult Remainders
		this.addRemainder(start, "Event: " + name + "is starting now");
		this.addRemainder(this.subtractDay(start), "Event: " + name + "is starting now");
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
