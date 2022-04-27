package day3;

import java.util.Scanner;

public class Ex4_If1 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 코드를 작성하세요.
		 * 
		 * op가 +이면 num1 + num2를 출력하고,
		 * op가 -이면 num1 - num2를 출력하고,
		 * op가 *이면 num1 * num2를 출력하고,
		 * op가 /이면 num1 / num2를 출력하고,
		 * op가 %이면 num1 % num2를 출력하고,
		 * op가 산술연산자가 아니면 op은 산술연산자가 아니라고 출력.
		 * 
		 * Ex3_Scanner3의 방법2.로 예제를 써도 된다.
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수1를 입력하세요. : ");
		int num1 = scan.nextInt();
		System.out.print("정수2를 입력하세요. : ");
		int num2 = scan.nextInt();
		System.out.print("산술 연산자를 입력하세요. : ");
		char op = scan.next().charAt(0);
		
		if(op == '+') {       
			 System.out.println(""+num1 + op + num2 + "=" + (num1 + num2));		
			} else if (op == '-') { 
			 System.out.println(""+num1 + op + num2 + "=" + (num1 - num2));
			} else if (op == '*') { 
			System.out.println(""+num1 + op + num2 + "=" + (num1 * num2));
			} else if (op == '/') { 
			System.out.println(""+num1 + op + num2 + "=" + (num1 / (double)num2));
			} else if (op == '%') { 
		    System.out.println(""+num1 + op + num2 + "=" + (num1 % num2));} 
			else { 
		    System.out.println(op+"는 산술 연산자가 아닙니다.");
	        }
		
		scan.close();
			
		}

}
