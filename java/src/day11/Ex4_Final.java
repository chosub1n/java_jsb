package day11;

import java.util.Scanner; // java.util. => 패키지

public class Ex4_Final {

	public static void main(String[] args) {
		System.out.println(Math.PI);
		System.out.println(Integer.MAX_VALUE);
		Scanner scan;
	}

}

class Tv{
	private final static int MIN_CHANNEL = 1; 
	private int Channel;	
	public void print() {
		System.out.println("최소 채널 : " + MIN_CHANNEL);
		System.out.println("현재 채널 : " + Channel);
	}
	public Tv(int channel) {
		this.Channel = channel;
		//minChannel = 2; //에러 발생. final이 붙은 변수를 수정하려고 했기 때문에.
	}
	//변수의 기울기와 굵기가 다름!!
	int a;
	static int b;
	final static int c=1;
}