package __;

public class Ex2_Thread1 {

	public static void main(String[] args) {
		//Test1 t1 = new Test1();
		//Thread th1 = new Thread(t1);
		Thread th1 = new Thread(new Test1()); //위에 두 줄을 한 줄로 바꾼 코드!!
		th1.start();
		
		Thread th2 = new Test2();
		th2.start();
		
		//익명객체를 활용한 것
		Thread th3 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 10000; i++) {
					System.out.println("@");
				}
				
			}
		});
		
		th3.start();
		for(int i = 0; i < 10000; i++) {
			System.out.println("|");
		}
		

	}

}
//Runnable 인터페이스를 구현한 구현 클래스를 이용
class Test1 implements Runnable {
	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			System.out.println("-");
		}
		
	}
	
}
//Thread 클래스를 상속 받은 자식 클래스를 이용
class Test2 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			System.out.println("*");
		}
		
	}
}