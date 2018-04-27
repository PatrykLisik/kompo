/**
 * 
 */
package textUserInterface;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import logicLayer.LogicLayer;
import logicLayer.LogicLayerNoSQL;

/**
 * @author plisik
 *
 */
public class MainClass {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		LogicLayer ll = new LogicLayerNoSQL();
		ll.createPerson("John", "Doe");
		ll.createPerson("Fizz", "Buzzz");
		String string = "January 2, 2010";
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date date = format.parse(string);
		System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010
		ll.createEvent("dadad",date,date);
		ll.addPersonToEvent(0,0);
		ll.addPersonToEvent(0,1);
		
		ConsolePrinter printer=new EventsPrinter(new PersonPrinter(new BasicPrinter(ll)));
		System.out.println(printer.show());
		/*
		System.out.println("Persons: ");
		for (HashMap.Entry<Integer, Person> entry : ll.getAllPersons().entrySet()) {
			Person p = entry.getValue();
			System.out.println("[" + entry.getKey() + "] " + p.getName() + " " + p.getSurname());
		}

		String xmlFile = "XMLSave.xml";
		System.out.println("SAVE");
		ll.saveToXML(xmlFile);
		ll.deletePerson(1);
		System.out.println("Delete\nPersons: ");
		for (HashMap.Entry<Integer, Person> entry : ll.getAllPersons().entrySet()) {
			Person p = entry.getValue();
			System.out.println("[" + entry.getKey() + "] " + p.getName() + " " + p.getSurname());
		}

		System.out.println("IMPORT");
		ll.importFromXML(xmlFile);

		System.out.println("Restore\nPersons: ");
		for (HashMap.Entry<Integer, Person> entry : ll.getAllPersons().entrySet()) {
			Person p = entry.getValue();
			System.out.println("[" + entry.getKey() + "] " + p.getName() + " " + p.getSurname());
		}
		*/
	}

}
