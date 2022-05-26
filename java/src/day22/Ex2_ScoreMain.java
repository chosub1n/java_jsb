package day22;

import java.util.Scanner;

public class Ex2_ScoreMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		ScoreManager sm = new ScoreManager(scan);
		sm.run();
		scan.close();
		
	}
}
