/**
 * 
 */
package textUserInterface;

import logicLayer.LogicLayer;
import logicLayer.LogicLayerException;
import logicLayer.LogicLayerFactory;
import logicLayer.LogicLayerImpl;

/**
 * @author plisik
 *
 */
public class MainClass {
	public static void main(String[] args) throws LogicLayerException {

		LogicLayerFactory lf=new LogicLayerFactory();
		LogicLayerImpl ll = lf.getLogicLayerNoSQL();
		
		ll.createPerson("aaa", "adada");
		ll.saveToODT("plik.odt");
		System.out.println("END");

	}

}
