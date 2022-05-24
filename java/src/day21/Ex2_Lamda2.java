package day21;

public class Ex2_Lamda2 {

	public static void main(String[] args) {
		//매개변수가 하나인 경우는 타입과 괄호를 생략 가능 (int a) -> a
		//실행문이 한 줄이면 중괄호도 생략 가능
	
//		Test1 t1 = (int a) -> {
//			System.out.println("테스트 : " + a);
//		};
//	t1.test(10);
		
		//얘가 생략한 코드
		Test1 t1 = a -> System.out.println("테스트 : " + a);
		t1.test(10);
		
		
//		Test2 t2 = (int a, int b) -> {
//			return a+b;
//			System.out.println(t2.sum(10,20));
//		};
		
		//얘가 생략한 코드 리턴이랑 중괄호 생략 가능
		Test2 t2 = (int a, int b) -> a+b;
			System.out.println(t2.sum(10,20));
		}
}

@FunctionalInterface 
interface Test1{
	void test(int a);
	//void test(); //주석 해제하면 추상메소드가 2개가 되서 에러 발생
}
@FunctionalInterface
interface Test2{
	int sum(int a, int b);
}
