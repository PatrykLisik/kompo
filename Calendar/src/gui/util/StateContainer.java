package gui.util;

import java.util.List;

import dataLayer.Person;
import logicLayer.LogicLayer;
import logicLayer.LogicLayerNoSQL;

public class StateContainer {
	
	private LogicLayer logicLayer;

	public StateContainer(LogicLayer logicLayer) {
		super();
		this.logicLayer = logicLayer;
	}
	
	//TODO: Remove
	public StateContainer() {
		super();
		this.logicLayer = new LogicLayerNoSQL();
	}
	
	public LogicLayer getLogic() {
		return logicLayer;
	}

}
