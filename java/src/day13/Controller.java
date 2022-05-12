package day13;

public interface Controller {
	int min = 1; //public static final이 앞에 자동으로 붙음. 선언과 동시에 초기화를 지정 해줘야 함.
	void run(); //public abstract가 앞에 자동으로 붙음.
	void stop();
	void print();
	default void test() {
		System.out.println("테스트 입니다.");
	}
		
}
