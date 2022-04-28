package day4;

import java.util.Scanner;

public class Ex5_Break2 {

	public static void main(String[] args) {
		/* 양의 정수를 5번 입력하고, 입력한 정수를 콘솔에 출력하는 코드를 작성하세요.
		 * 입력받은 정수가 음수이면 반복문을 빠져나오게 수정해보세요.
		 * 반복횟수 : 무한대
		 * 규칙성 : Scanner를 이용하여 정수를 입력받아 num에 저장하고,
		 *        num가 음수이면 반복문을 빠져 나가고 아니면 num을 출력
		 * 반복문 종료 후: 없음
		 * */
		
		int num;
		Scanner scan = new Scanner (System.in);
		
		for(; ;) {
			System.out.println("양의 정수 입력 : ");
			 num = scan.nextInt(); // num가 음수이면 반복문을 빠져 나가고 아니면 num을 출력
			if(num < 0) { // num가 음수이면 반복문을 빠져 나가고
				 break;	
			}		
			System.out.println(num); // if문에 Break가 있어서 else 생략 가능
					
	    }
		  scan.close();
	}

}
