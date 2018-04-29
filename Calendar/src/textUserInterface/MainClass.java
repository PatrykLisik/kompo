/**
 * 
 */
package textUserInterface;

import java.text.ParseException;

/**
 * @author plisik
 *
 */
public class MainClass {
	static final long ONE_MINUTE_IN_MILLIS=60000;//millisecs
	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		
		ConsoleInterface ci=new ConsoleInterface();
		ci.run();
		/*LogicLayer ll = new LogicLayerNoSQL();
		ll.createPerson("John", "Doe");
		ll.createPerson("Fizz", "Buzzz");
		String string = "January 2, 2010";
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date date = format.parse(string);
		System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010
		ll.createEvent("dadad",date,date);
		ll.addPersonToEvent(0,0);
		ll.addPersonToEvent(0,1);
		ConsolePrinter printer=new MenuPrinter(new BasicPrinter(ll));
		Timer timeer=new Timer();
		TimerTask timerTask = new TimerTask() {
			public void run() {
				System.out.println(new Date() + " printer update");
			}
		};
		Calendar date2 = Calendar.getInstance();
		long t= date2.getTimeInMillis();
		Date afterAddingTenMins=new Date(t + (1 * ONE_MINUTE_IN_MILLIS));
		timeer.schedule(timerTask,afterAddingTenMins);
		*/
	
	
	}

}
