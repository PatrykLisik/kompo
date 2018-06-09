/**
 *
 */
package textUserInterface;

import java.util.Date;

import logicLayer.LogicLayerException;
import logicLayer.LogicLayerFactory;
import logicLayer.LogicLayerSQLImpl;

/**
 * @author plisik
 *
 */
public class MainClass {
	public static void main(String[] args) throws LogicLayerException {

		LogicLayerSQLImpl ll = LogicLayerFactory.getLogicLayerSQL();

		ll.createPerson("aaa", "adada");
		ll.createEvent("test1", new Date(), new Date());
		ll.saveToDatabase();
		System.out.println("END");

	}

}
