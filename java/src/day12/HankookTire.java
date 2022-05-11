package day12;

public class HankookTire extends Tire {
	public final static String COMPANY ="한국타이어";
	
	public HankookTire(int state, int pressure, String position) {
		super(state, pressure, position);
	}
	public HankookTire() {
		//super(); => 생략가능. 써도 되고 안 써도 됨.
	}
	
}
