package day22;

public class Ex1_Recursivemethod {

	public static void main(String[] args) {
		try {
			System.out.println(factorial1(4)); 
			System.out.println(factorial2(-4));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/* 팩토리얼 메소드를 반복문으로 구현*/ //반복문은 예외처리를 안 해도 구할 수 있음.
	public static int factorial1(int n) {
		if(n < 0) {
			throw new RuntimeException("음수 팩토리얼은 구할 수 없습니다."); //음수 예외처리
		}
		int res = 1;
		for(int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}
	
	/* 팩토리얼 메소드를 재귀메소드로 구현*/
	public static int factorial2(int n) {
		if(n < 0) {
			throw new RuntimeException("음수 팩토리얼은 구할 수 없습니다.");
		}
		if(n == 1 || n == 0) {
			return 1;			
		}
		System.out.println(n);
		return n * factorial2(n-1);
	}

}
