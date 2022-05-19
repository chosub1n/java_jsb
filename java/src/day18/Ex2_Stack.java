package day18;

public class Ex2_Stack {

	public static void main(String[] args) {
		test();

	}

	/*재귀메소드는 메소드 안에서 자기 자신을 호출하는 메소드*/
	public static void test() {
		test();
	}
}
//StackOverflowError - Stack이 메모리에 계속 쌓여서 흘러 넘침.
