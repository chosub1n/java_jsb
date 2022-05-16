package day14;

import java.util.Scanner;

public class Ex2_BaseballGameMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BaseballGame1 game = new BaseballGame1(scan);
		game.run();
		scan.close();

	}

}
