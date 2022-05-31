package day24;

import java.util.Scanner;

public class Ex1_PhoneMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PhoneManager pm = new PhoneManager(scan);
		pm.run();
		scan.close();
	}

}
