package textUserInterface;

import java.util.Map.Entry;

import dataLayer.Event;
import dataLayer.Event.Notification;
import logicLayer.LogicLayer;

/**
 * Events printer decorator
 * @basicPrinter is necessary because that part stores logic layer
 * @author plisik
 *
 */
public class EventsPrinter extends CalendarPrinterDecorator {

	public EventsPrinter(ConsolePrinter printer) {
		super(printer);
	}

	static String printNotification(Long id,Notification n) {
		String out = "";
		out += "["+id+"]"+n.getDate()+" "+n.getDescripton();
		return out;
	}

	static String printNotificationsOfEvent(Event ev, String offset) {
		String out = "";
		for (Entry<Long, Notification> entry : ev.getNotifications().entrySet()) {
			out += offset + printNotification(entry.getKey(), entry.getValue()) + '\n';
		}
		return out;
	}

	static String printPersonsOfEvent(Event ev, String offset,LogicLayer data) {
		String out = "";
		for (int i :ev.getAssociatedPersons()) {
			out+=offset+PersonPrinter.printPersonEntry(i,data.getPerson(i))+"\n";
		}
		return out;
	}

	static String printEventEntry(int id, Event ev,LogicLayer data) {
		String out = "";
		out += "[" + id + "] " + ev.getName() + "\n";
		out += "NOTIFICATIONS: \n";
		out += printNotificationsOfEvent(ev, "	");
		out += "PERSONS: \n";
		out += printPersonsOfEvent(ev,"	",data);
		return out;
	}

	static String printEvents(LogicLayer data) {
		String out = "";
		for (Entry<Integer, Event> entry : data.getAllEvents().entrySet()) {
			out += printEventEntry(entry.getKey(),entry.getValue(),data);
		}

		return out;
	}

	@Override
	public String show() {
		String out = "";
		out += ConsoleInterfaceElements.innerBreak();
		out += "Events:";
		out += ConsoleInterfaceElements.innerBreak();
		out += printEvents(super.getData());

		return super.tempPrinter.show() + out;
	}
}
