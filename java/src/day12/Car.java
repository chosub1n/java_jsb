package day12;

public class Car {
	private Tire[] tire;
    // 필드의 다형성. 공통인 tire로 묶어줌!!
	public Car(Tire[] tire) {
		this.tire = tire;
	}
	public void print() {
		if(tire == null) {
			return;
		}
		for(Tire tmp : tire) {
			if(tmp instanceof HankookTire) {
				System.out.println(HankookTire.COMPANY + " : ");
			}else if (tmp instanceof KumhoTire) {
				System.out.println(KumhoTire.COMPANY + " : ");
			}
			System.out.println(tmp.getPosition() + ", 압력 : " + tmp.getPressure() + ", 상태 : " + tmp.getState());			
		}
	}
	public void repare(int index, Tire tire) {
		if(this.tire == null || this.tire.length <= index) {
			return;
		}
		this.tire[index] = tire;
	}
	// 아래 코드 필요없이 위에 tire로 묶은 코드 하나만 있으면 됨. => 다형성 매개변수
//	public void repare(int index, HankookTire tire) {
//		if(this.tire == null || this.tire.length <= index) {
//			return;
//		}
//		this.tire[index] = tire;
//	}
//	public void repare(int index, KumhoTire tire) {
//		if(this.tire == null || this.tire.length <= index) {
//			return;
//		}
//		this.tire[index] = tire;
//	}
}

