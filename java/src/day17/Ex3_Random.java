package day17;

import java.util.Random;

public class Ex3_Random {

	public static void main(String[] args) {
		/* - Random생성자에 시드값을 입력 안 하면 현재시간을 시드값으로 랜덤한 수를 생성
		 * - Random생성자에 시드값을 입력하면 입력한 값을 이용하여 랜덤한 수를 생성하기 때문에 항상 같은 순서로 랜덤한 값이 고정*/
		Random r = new Random(/*시드값 입력하는 곳*/); 
		int num = 5;
		for(int i = 0 ; i < num; i++) {
			//0이상 1미만의 난수(랜덤한 수)
			System.out.println(r.nextDouble());
		}
		System.out.println("--------------------------");
		for(int i = 0 ; i < num; i++) {
			//int의 최소값에서 최대값 사이의 난수
			System.out.println(r.nextInt());
		}
		System.out.println("--------------------------");
		int min = 1, max = 9;
		for(int i = 0 ; i < num; i++) {
			//int의 최소값에서 최대값 사이의 난수
			System.out.println(r.nextInt(max - min + 1) + min);
		}
		/* Math.Random()은 객체를 생성 안 하고 호출할 수 있지만 식이 ()가 많아서 복잡하고,
		 * Random클래스의 nextInt(num)는 객체를 생성하고 호출해야 하지만 식이 간단함.
		 * 
		 * 
		 * 쓰고 싶은 식으로 쓰면 됨.*/
	}
}
