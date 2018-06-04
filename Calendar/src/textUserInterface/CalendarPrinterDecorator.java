package textUserInterface;

import logicLayer.LogicLayer;


/**
 * The Class CalendarPrinterDecorator.
 * 
 *  @author dwojcik
 *  
 */
public class CalendarPrinterDecorator implements ConsolePrinter {

	/** The temp printer. */
	protected ConsolePrinter tempPrinter;
	
	/**
	 * Instantiates a new calendar printer decorator.
	 *
	 * @param printer the printer
	 */
	public CalendarPrinterDecorator(ConsolePrinter printer) {
		this.tempPrinter = printer;
	}

	/* (non-Javadoc)
	 * @see textUserInterface.ConsolePrinter#show()
	 */
	@Override
	public String show() {
		return "\n"+tempPrinter.show();
	}

	/* (non-Javadoc)
	 * @see textUserInterface.ConsolePrinter#getData()
	 */
	@Override
	public LogicLayer getData() {
		return tempPrinter.getData();
	}

}
