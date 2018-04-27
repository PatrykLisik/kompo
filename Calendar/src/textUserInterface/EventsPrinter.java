package textUserInterface;

import java.util.Date;
import java.util.Map.Entry;

import dataLayer.Event;
import logicLayer.LogicLayer;

public class EventsPrinter extends CalendarPrinterDecorator {

	public EventsPrinter(ConsolePrinter printer) {
		super(printer);
		// TODO Auto-generated constructor stub
	}

	static String printRemainder(Date date, String description) {
		String out = "";
		out += date + " " + description;
		return out;
	}

	static String printRemaindersOfEvent(Event ev, String offset) {
		String out = "";
		for (Entry<Date, String> entry : ev.getRemainders().entrySet()) {
			out += offset + printRemainder(entry.getKey(), entry.getValue()) + '\n';
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
		out += "REMAINDERS: \n";
		out += printRemaindersOfEvent(ev, "	");
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
