package day15;

public class Ex2_Anonymous {
	//익명 객체는 인터페이스를 이용해서 만드는 경우. 한 번 밖에 못 만듦.
	public static void main(String[] args) {
		//구현 클래스의 생성 후 객체를 생성
		Test test = new TestA();
		test.test();
		//구현 클래스 생성 없이 이름 없는 클래스를 바로 만들어서 객체를 생성 --> 이 코드부터가 익명객체 생성하는 코드
		Test test2 = new Test() {

			@Override
			public void test() {
				System.out.println("테스트2");
				
			}
			
		};
		test2.test();
	}

}

interface Test{
	void test();
}

class TestA implements Test{

	@Override
	public void test() {
		System.out.println("테스트");
		
	}
	
}