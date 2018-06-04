/**
 * 
 */
package textUserInterface;

import logicLayer.LogicLayerException;

/**
 * @author plisik
 *
 */
public class MainClass {
	public static void main(String[] args) throws LogicLayerException {

		ConsoleInterface ci = new ConsoleInterface();
		ci.run();

	}

}
