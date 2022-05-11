package day12;

public class Ex5_polymorphism {

	public static void main(String[] args) {
		Tire tire [] = new Tire[4];
		tire[0] = new HankookTire(100, 100, "앞왼쪽");
		tire[1] = new HankookTire(100, 100, "앞오른쪽");
		tire[2] = new KumhoTire(100, 100, "뒤왼쪽");
		tire[3] = new KumhoTire(100, 100, "뒤오른쪽");
		Car car1 = new Car(tire);
		car1.print();
		//위 아래 두 개는 같은 코드. 다만 간단하게 테스트 하기에는 아래가 더 간략한 코드. 실제로 구현할 때는 위에 코드를 자주 쓴다.
		Tire tire2 [] = {
				new HankookTire(90, 100, "앞왼쪽"),
				new HankookTire(90, 100, "앞오른쪽"),
				new KumhoTire(90, 100, "뒤왼쪽"),
				new KumhoTire(90, 100, "뒤오른쪽")
		};	
		Car car2 = new Car(tire2);
		car2.print();
		System.out.println("-------------------------");
		car2.repare(3, new HankookTire(80, 70, "뒤오른쪽"));
		car2.print();
		System.out.println("-------------------------");
		car2.repare(3, new KumhoTire(80, 100, "뒤오른쪽"));
		car2.print();
		
		}
}
