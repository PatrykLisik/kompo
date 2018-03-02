package ex1;

import javax.swing.*;

public class PascalTriangle {

	public static void PrintIter(int numberOfRows) {
		int prev_len = 2;
		long prev[] = new long[prev_len];
		prev[0] = 1;
		prev[1] = 1;

		for (int i = 0; i < numberOfRows + 1; i++) {
			long ans[] = new long[prev_len + 1];
			ans[0] = 1;
			ans[prev_len] = 1;
			System.out.print("1 ");
			for (int j = 1; j < prev_len - 1; j++) {
				ans[j] = prev[j - 1] + prev[j];
				System.out.print(ans[j] + " ");
			}

			prev = ans;
			prev_len++;
			System.out.print("\n");
		}
	}

	public static void PrintRek(int numberOfRows) {
		for (int i = 0; i < numberOfRows+1; i++) {
			for (int j = 0; j<i+1; j++) {
				System.out.print(GenRekHelper(i, j)+" ");
			}
				
			System.out.println();
		}
	}

	public static int GenRekHelper(int row, int collumn) {
		if (collumn == 0 || row == collumn)
			return 1;
		return GenRekHelper(row - 1, collumn - 1) + GenRekHelper(row - 1, collumn);
	}

	public static void main(String[] args) {
		String txt;
		txt = JOptionPane.showInputDialog("Enter number of rows");
		int numberOfRows = Integer.parseInt(txt);
		PrintIter(numberOfRows);
		PrintRek(numberOfRows);
		//System.out.println("\n \n"+GenRekHelper(3,2));

	}

}
