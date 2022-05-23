package day20;

import java.awt.Toolkit;

public class Ex3_Thread2_1 {
	//단일 스레드. 스레드 없이 한 예제
	public static void main(String[] args) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		for(int i = 0; i < 5; i++) {
			tk.beep();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		for(int i = 0; i < 5; i++) {
			System.out.println("띵");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}

	}

}
