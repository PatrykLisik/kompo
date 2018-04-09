package dataLayer;

import java.util.Date;
import java.util.Vector;

public class Event {
	Date start;
	Date end;
	Vector<Integer> associatedPersons = new Vector<Integer>();

	public Event(Date start, Date end, Vector<Integer> associatedPersons) {
		this.start = start;
		this.end = end;
		this.associatedPersons = associatedPersons;
	}

	/**
	 * @param start
	 * @param end
	 */
	public Event(Date start, Date end) {
		this.start = start;
		this.end = end;
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
	public Vector<Integer> getAssociatedPersons() {
		return associatedPersons;
	}

	/**
	 * @param associatedPersons
	 *            the associatedPersons to set
	 */
	public void setAssociatedPersons(Vector<Integer> associatedPersons) {
		this.associatedPersons = associatedPersons;
	}

}
