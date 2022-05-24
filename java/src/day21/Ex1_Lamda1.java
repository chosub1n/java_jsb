package day21;

public class Ex1_Lamda1 {

	public static void main(String[] args) {
		//람다식을 안 쓰고 쓰레드 생성 후 테스트
		Thread th1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("안녕");
			}
		});
		th1.start();
		
		//람다식을 이용하여 쓰레드 생성 후 코드. 위에 코드랑 아래 코드랑 같은 기능을 하지만 람다식을 활용해서 훨씬 간결해짐.
		Thread th2 = new Thread(() -> System.out.println("Hi"));
		th2.start();
		
		//위 코드의 기본적인 코드 {} 을 사용함. 중괄호를 생략할 때에는 ;을 쓰면 안 됨.
		Thread th3 = new Thread(() -> {	
			System.out.println("Hello");
		});
		th3.start();

	}

}
