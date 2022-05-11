package day12;

public class KumhoTire extends Tire {
	public final static String COMPANY ="금호타이어";
	
	public KumhoTire(int state, int pressure, String position) {
		super(state, pressure, position);
	}
	public KumhoTire() {
		//super(); => 생략. 써도 되고 안 써도 됨.
	}
}
