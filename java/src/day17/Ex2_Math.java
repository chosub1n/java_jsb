package day17;

public class Ex2_Math {

	public static void main(String[] args) {
		/* 주어진 정수를 소수점 둘째자리에서 반올림하는 코드를 작성하세요.*/
		int num = 2;
		double pi = 3.141592;
		//x를 곱해서 반올림
		double pi2 = pi * Math.pow(10, num-1);
		//반올림한 값에서 x로 나눔
		double pi3 = Math.round(pi2) / Math.pow(10, num-1);
		
		double pi4 = Math.round(pi * Math.pow(10, num-1))/Math.pow(10, num-1); // 위에 두 개의 코드를 합친 거
		System.out.println(pi3);
		System.out.println(pi4);
		
		//내가 짠 코드
		System.out.println(Math.round(pi*10)/10.0);
	}

}
