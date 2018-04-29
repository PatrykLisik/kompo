package textUserInterface;

/**
 * Decorator that is going to print notification
 * Method setNotification is necessary to be invoked to this decorator to work 
 * @author plisik
 *
 */
public class NotificationPrinter extends CalendarPrinterDecorator {

	String notification="";
	public NotificationPrinter(ConsolePrinter printer) {
		super(printer);
		// TODO Auto-generated constructor stub
	}
	public NotificationPrinter setNotification(String notification) {
		this.notification = notification;
		return this;
	}
	public String show() {
		if(notification=="") {
			return super.tempPrinter.show();
		}
		String out="Notification";
		out+=ConsoleInterfaceElements.innerBreak();
		out+=notification;
		out+=ConsoleInterfaceElements.innerBreak();
		//Every notification is printed only once
		notification="";
		return super.tempPrinter.show()+out;
	}
}
