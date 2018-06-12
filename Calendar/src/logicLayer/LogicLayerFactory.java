/**
 * 
 */
package logicLayer;

import dataLayer.DataServiceNoSQL;
import dataLayer.DataServiceSQL;

/**
 * Factory that produces different versions of {@link logicLayer.LogicLayerImpl}
 * @author plisik
 *
 */
public class LogicLayerFactory {
	
	/**
	 * Empty Logic layer without database
	 * @return instance of {@link logicLayer.LogicLayerImpl}
	 * @throws LogicLayerException 
	 */
	public static LogicLayerImpl getLogicLayerNoSQL() throws LogicLayerException {
		return new LogicLayerImpl(new DataServiceNoSQL());
	}
	
	/**
	 * Logic layer with database
	 * @return instance of LogicLayerSQLImpl
	 */
	public static LogicLayerSQLImpl getLogicLayerSQL() {
		return new LogicLayerSQLImpl(new DataServiceSQL());
	}

}
