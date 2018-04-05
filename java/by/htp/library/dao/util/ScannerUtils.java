package by.htp.library.dao.util;

import java.util.Scanner;

public class ScannerUtils {
	private ScannerUtils() {
	}

	public static String inputString() {
		System.out.println("Input string please:");
		System.out.print("-> ");
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();

	}

}
