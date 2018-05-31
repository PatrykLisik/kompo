package logicLayer;

import dataLayer.DataBaseService;
import dataLayer.DataService;

/**
 * LogicLayer implementation extended to include database operations 
 * --ex:
 * creation and save to database
 * 
 * <pre>
 * <code>
 * LogicLayer ll = LogicLayerFactory.getLogicLayerSQL();
 * ((DataBaseService) ll).saveToDatabase();
 * </code>
 * </pre>
 * @author plisik
 *
 */
public class LogicLayerSQLImpl extends LogicLayerImpl implements DataBaseService {

	public LogicLayerSQLImpl(DataService data) {
		super(data);
	}

	@Override
	public void loadFromDatabase() {
		if (super.data instanceof DataBaseService) {
			((DataBaseService) super.data).loadFromDatabase();
		}

	}

	@Override
	public void saveToDatabase() {
		if (super.data instanceof DataBaseService) {
			((DataBaseService) super.data).saveToDatabase();
		}

	}

}
