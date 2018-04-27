/**
 * 
 */
package textUserInterface;

import logicLayer.LogicLayer;

/**
 * Base part of console printer, every part of printer should be build on that 
 * @author plisik
 *
 */
public class BasicPrinter implements ConsolePrinter {

	LogicLayer data;

	public BasicPrinter(LogicLayer data) {
		this.data = data;
	}

	public void setData(LogicLayer data) {
		this.data = data;
	}

	@Override
	public LogicLayer getData() {
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textUserInterface.ConsolePrinter#show()
	 */
	@Override
	public String show() {
		String out = ConsoleInterfaceElements.sectionBreak() + "		CALENDAR"
				+ ConsoleInterfaceElements.sectionBreak();
		return out;
	}

}
