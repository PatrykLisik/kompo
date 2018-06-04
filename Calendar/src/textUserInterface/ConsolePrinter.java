package textUserInterface;

import logicLayer.LogicLayer;

/**
 * The Interface ConsolePrinter.
 * 
 *  @author dwojcik
 */
public interface ConsolePrinter {
	
	/**
	 * Show.
	 *
	 * @return the string
	 */
	public String show();
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	LogicLayer getData();
}
