package dataLayer;

/**
 * Generalisation of database usage
 * @author plisik
 *
 */
public interface DataBaseService {

	/**
	 * inject data from data base
	 */
	void loadFromDatabase();

	/**
	 * save current state to dataBase
	 */
	void saveToDatabase();

}