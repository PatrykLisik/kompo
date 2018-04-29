package ex1;

import java.util.*;

public class Tablice {

	public static int[] arrayInit(int size, int range) {
		int[] ans = new int[size];
		for (int i = 0; i < ans.length; i++)
			ans[i] = (int) (Math.random() * range);
		return ans;
	}
	public static int[] bubleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		return arr; 
	}

	public static void main(String[] args) {
		int[] arry = arrayInit(99999900, 50000);
		System.out.println(Arrays.toString(arry));
		int[] arryCp2 = arry;
		Date before1 = new Date();
		//arry=bubleSort(arryCp);
		Date after1 = new Date();
		Arrays.sort(arry);
		Date after2 = new Date();
		Arrays.parallelSort(arryCp2);
		Date after3 = new Date();
		//System.out.println(Arrays.toString(arryCp));
		System.out.println("Buble sort - time: "+(after1.getTime()-before1.getTime()) + "ms");
		System.out.println("Java sort - time: "+(after2.getTime()-after1.getTime()) + "ms");
		System.out.println("JavaparallelSort - time: "+(after3.getTime()-after3.getTime()) + "ms");

	}

}
