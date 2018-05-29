/**
 * 
 */
package logicLayer;

import dataLayer.DataServiceNoSQL;
import dataLayer.DataServiceSQL;

/**
 * @author plisik
 *
 */
public class LogicLayerFactory {
	public static LogicLayer getLogicLayerNoSQL() {
		return new LogicLayerImpl(new DataServiceNoSQL());
	}
	
	public static LogicLayer getLogicLayerSQL() {
		return new LogicLayerImpl(new DataServiceSQL());
	}

}
