/**
 * 
 */
package logicLayer;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import dataLayer.DataService;
import dataLayer.Event;
import logicLayer.comparator.DateComparator;

/**
 * Implementation of sorting and searching algorithms to perform operations on {@link dataLyer.DataService} object
 * 
 * @author plisik
 *
 */
public class SortingAndSearchPolicies {
	/**
	 * 
	 * @param data 
	 * @param start date
	 * @param end date
	 * @return Inclusive list of events from start to end
	 */
	static public List<Event> eventsBetweenDates(DataService data, Date start, Date end) {
		return data.getAllEvents().values().stream()
				.filter(ev -> ev.getStart().compareTo(start) <= 0 && ev.getStart().compareTo(end) >= 0)
				.collect(Collectors.toList());
	}
	
	/**
	 * 
	 * @param data
	 * @return events list sorted by start date 
	 */
	static public List<Event> eventsByDate(DataService data) {
		List<Event> events = data.getAllEvents().values().stream().collect(Collectors.toList());
		events.sort(Comparator.comparing(Event::getStart));
		return events;
	}
	
	static public List<Event> eventsOn(DataService data, Date day) {
		return data.getAllEvents().values().stream()
				.filter(ev -> DateComparator.isDateBetween(ev.getStart(), day, ev.getEnd()))
				.collect(Collectors.toList());
	}

	/**
	 * 
	 * @param data
	 * @return events list sorted by number of associated persons
	 */
	static public List<Event> eventsByNumberOfAssociatedPersons(DataService data) {
		List<Event> events = data.getAllEvents().values().stream().collect(Collectors.toList());
		events.sort(
				(evLHS, evRHS) -> Integer.compare(evLHS.getAssociatedPersons().size(),
						evRHS.getAssociatedPersons().size()));
		return events;
	}

}
