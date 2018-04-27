package textUserInterface;

import logicLayer.LogicLayer;

public class CalendarPrinterDecorator implements ConsolePrinter {

	protected ConsolePrinter tempPrinter;
	public CalendarPrinterDecorator(ConsolePrinter printer) {
		this.tempPrinter = printer;
	}

	@Override
	public String show() {
		return "\n"+tempPrinter.show();
	}

	@Override
	public LogicLayer getData() {
		return tempPrinter.getData();
	}

}
