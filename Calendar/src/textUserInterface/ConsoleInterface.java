package textUserInterface;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import logicLayer.EventNotifiactionPublisher;
import logicLayer.EventNotifiactionPublisher.NotificationReciver;
import logicLayer.LogicLayer;
import logicLayer.LogicLayerException;
import logicLayer.LogicLayerFactory;

/**
 * Class that represents TUI itself
 * 
 * @author plisik
 *
 */
public class ConsoleInterface implements NotificationReciver {

	/**
	 * Class that represents TUI Menu
	 * 
	 * @author plisik
	 *
	 */
	public class ConsoleMenu {
		List<String> menuEntries;

		public ConsoleMenu(List<String> menuEntries) {

			this.menuEntries = menuEntries;

		}

		private String menuList() {
			String out = "";
			int counter = 1;
			for (String entry : menuEntries) {
				out += "[" + counter + "] " + entry + "\n";
				counter++;
			}
			out += ConsoleInterfaceElements.innerBreak();
			return out;

		}

		/**
		 * Return which action was chosen
		 * 
		 * @return
		 */
		String getMenuOption() {
			System.out.println(menuList());
			Integer ans = null;
			while (true) {

				System.out.print("Menu option: ");
				ans = ConsoleInterfaceElements.getIntegerFromUser();
				if (ans < menuEntries.size() + 1 && ans > 0) {
					break;
				} else {
					System.out.println("Incorect number range");
				}

			}
			return menuEntries.get(ans - 1);
		}
	}

	LogicLayer ll = LogicLayerFactory.getLogicLayerSQL();
	ConsolePrinter printer = new BasicPrinter(ll);
	EventNotifiactionPublisher notifiactionSource = new EventNotifiactionPublisher(ll);
	Map<String, Runnable> actions = new TreeMap<String, Runnable>();

	public ConsoleInterface() {
		notifiactionSource.addReciver(this);
		ll.addEventNotificationPublisher(notifiactionSource);
		actions.put("Save to XML", new Runnable() {

			@Override
			public void run() {
				System.out.print("File name: ");
				String fileName = ConsoleInterfaceElements.getUserInput();
				try {
					ll.saveToXML(fileName);
				} catch (LogicLayerException e) {
					System.out.println("Cannot save " + e.getMessage());
					return;
				}
				System.out.println("SAVED to XML");

			}

		});

		actions.put("Save to binary", new Runnable() {

			@Override
			public void run() {
				System.out.print("File name: ");
				String fileName = ConsoleInterfaceElements.getUserInput();
				try {
					ll.saveToBianry(fileName);
				} catch (LogicLayerException e) {
					System.out.println("Cannot save" + e.getMessage());
				}
				System.out.println("Saved to bianry");

			}

		});

		actions.put("Import from XML", new Runnable() {

			@Override
			public void run() {
				System.out.print("File name: ");
				String fileName = ConsoleInterfaceElements.getUserInput();
				try {
					ll.importFromXML(fileName);
				} catch (Exception e) {
					System.out.print("Error occuerd" + e.getMessage());
					return;
				}
				System.out.println("Imported from XML");

			}

		});

		actions.put("Import from binary", new Runnable() {

			@Override
			public void run() {
				System.out.print("File name: ");
				String fileName = ConsoleInterfaceElements.getUserInput();
				try {
					ll.importFromBianry(fileName);
				} catch (Exception e) {
					System.out.print("Error occuerd: " + e.getMessage());
					return;

				}
				System.out.println("Imported from binary");

			}

		});

		actions.put("Show persons", new Runnable() {

			@Override
			public void run() {
				ConsolePrinter persons = new PersonPrinter(printer);
				System.out.print(persons.show());

			}

		});
		actions.put("Add persons to view", new Runnable() {

			@Override
			public void run() {
				printer = new PersonPrinter(printer);

			}

		});
		actions.put("Show events", new Runnable() {

			@Override
			public void run() {
				ConsolePrinter events = new EventsPrinter(printer);
				System.out.print(events.show());

			}

		});
		actions.put("Add events to view", new Runnable() {

			@Override
			public void run() {
				printer = new EventsPrinter(printer);

			}

		});
		actions.put("Add person", new Runnable() {

			@Override
			public void run() {
				ConsoleInterfaceElements.innerBreak();
				System.out.println("Person Creator");
				System.out.println("Name: ");
				String name = ConsoleInterfaceElements.getUserInput();
				System.out.println("Surname: ");
				String surname = ConsoleInterfaceElements.getUserInput();
				ll.createPerson(name, surname);

			}

		});

		actions.put("Add event", new Runnable() {

			@Override
			public void run() {
				
				ConsoleInterfaceElements.innerBreak();
				System.out.println("Event Creator");
				System.out.print("Description ");
				String desc = ConsoleInterfaceElements.getUserInput();
				System.out.print("Start date ");
				Date start = ConsoleInterfaceElements.getDateFromUser();
				System.out.print("End date ");
				Date end = ConsoleInterfaceElements.getDateFromUser();
				ll.createEvent(desc, start, end);
			}

		});
	}

	public void run() {
		List<String> entries = actions.keySet().stream().collect(Collectors.toList());
		ConsoleMenu menu = new ConsoleMenu(entries);
		while (true) {
			System.out.print(printer.show());
			String option = menu.getMenuOption();
			actions.get(option).run();
			ConsoleInterfaceElements.getUserInput();
		}

	}

	@Override
	public void reciveNotification(String message) {
		printer = new NotificationPrinter(printer).setNotification(message);

	}

}
