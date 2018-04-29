package textUserInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Repeatable parts of console interface packed up in one place
 * 
 * @author plisik
 *
 */
public class ConsoleInterfaceElements {

	public static String sectionBreak() {
		return "\n***************************\n";
	}

	public static String innerBreak() {
		return "\n---------------------------\n";
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	static String getUserInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		try {
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}

	static Integer getIntegerFromUser() {

		Integer ans = null;
		while (true) {
			String number = getUserInput();
			try {
				ans = Integer.parseInt(number);
			} catch (NumberFormatException e) {
				System.out.println("Incorect number");
				continue;
			}
			break;
		}
		return ans;
	}

	static Date getDateFromUser() {
		String target = "27-09-1991 20:29:30";
		String format="dd-MM-yyyy HH:mm:ss";
		DateFormat df = new SimpleDateFormat(format);
		Date result;
		System.out.println("Give date in format "+format);
		System.out.println("Example "+target);
		while (true) {

			target = getUserInput();
			try {
				result = df.parse(target);
			} catch (ParseException e) {
				System.out.println("Incorect date");
				continue;
			}
			break;
		}
		return result;
	}

}
