
package dataLayer;

import java.io.Serializable;
import java.util.HashMap;
/**
 * Class that contains data for data service 
 * @author plisik
 *
 */
public class DataContext implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3887628138371244519L;
	public HashMap<Integer, Person> Persons = new HashMap<Integer, Person>();
	public HashMap<Integer, Event> Events = new HashMap<Integer, Event>();

}