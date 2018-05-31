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
	public static LogicLayerImpl getLogicLayerNoSQL() {
		return new LogicLayerImpl(new DataServiceNoSQL());
	}
	
	public static LogicLayerSQLImpl getLogicLayerSQL() {
		return new LogicLayerSQLImpl(new DataServiceSQL());
	}

}
