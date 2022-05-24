package day21;

import java.util.function.Supplier;

public class Ex5_Lamda_Supplier {

	public static void main(String[] args) {
		//랜덤한 값 구할 때만 가끔 쓰임.
		int min = 1, max = 10;
		Supplier<Integer> su = ()->(int)(Math.random()*(max - min +1) + min);
		
		for(int i = 0; i < 10; i++) {
			System.out.println(su.get());
		}

	}
	public static int randim(int min, int max) {
		return (int)(Math.random()*(max-min+1)+min);
	}

}
