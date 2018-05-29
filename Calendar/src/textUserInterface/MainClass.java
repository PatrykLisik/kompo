/**
 * 
 */
package textUserInterface;

import logicLayer.LogicLayer;
import logicLayer.LogicLayerException;
import logicLayer.LogicLayerImpl;

/**
 * @author plisik
 *
 */
public class MainClass {
	public static void main(String[] args) throws LogicLayerException {

		LogicLayer ll=new LogicLayerImpl();
		
		ll.createPerson("aaa", "adada");
		ll.saveToODT("plik.odt");
		System.out.println("END");

	}

}
