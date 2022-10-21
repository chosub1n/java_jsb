package 과제;

import java.util.Scanner;

public class PostMain {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		PostManager postManager  = new PostManager(scan);
		postManager.run();
		scan.close();
	}
}
