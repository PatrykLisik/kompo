package textUserInterface;

/**
 * Repeatable parts of console interface packed up in one place 
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

}
