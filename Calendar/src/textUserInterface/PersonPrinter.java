/**
 * 
 */
package textUserInterface;

import java.util.HashMap;

import dataLayer.Person;
import logicLayer.LogicLayer;

/**
 * @author plisik
 *
 */
public class PersonPrinter extends CalendarPrinterDecorator {

	/**
	 * @param printer
	 */
	public PersonPrinter(ConsolePrinter printer) {
		super(printer);
	}

	static String printPersons(LogicLayer data) {
		String out = "";
		for (HashMap.Entry<Integer, Person> entry : data.getAllPersons().entrySet()) {
			out += printPersonEntry(entry.getKey(),entry.getValue()) +"\n";
		}

		return out;
	}

	static String printPersonEntry(int id, Person p) {
		String out = "";
		out += "[" + id + "]" + p.getName() + " " + p.getSurname();

		return out;
	}

	@Override
	public String show() {
		String out = "";
		out += ConsoleInterfaceElements.innerBreak();
		out += "Persons:";
		out += ConsoleInterfaceElements.innerBreak();
		out += printPersons(super.getData());

		return super.tempPrinter.show() + out;
	}

}
