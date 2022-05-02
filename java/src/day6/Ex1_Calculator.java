package day6;

import java.util.Scanner;

public class Ex1_Calculator {

	public static void main(String[] args) {
		/* 문자를 콘솔에서 입력받아 입력받은 문자를 출력하는 코드를 작성하세요.
		 * 단, q가 입력될 때까지 입력을 계속적으로 받습니다.
		 * 이때, q를 입력받으면 q를 출력하고 종료합니다.
		 * 메뉴를 선택하면 정수 2개를 입력받아 입력받은 값에 맞는 산술 연산결과를 출력하는
		 * 코드를 작성하세요.
		 * 
		 * 산술 연산자 메뉴
		 * 1. 더하기
		 * 2. 빼기
		 * 3. 곱하기
		 * 4. 나누기
		 * 5. 나머지
		 * q. 종료
		 * 메뉴를 선택하세요 :
		 * 정수1 입력 : 1
		 * 정수2 입력 : 2
		 * 1 + 2 = 3
		 * 산술 연산자 메뉴
		 * 1. 더하기
		 * 2. 빼기
		 * 3. 곱하기
		 * 4. 나누기
		 * 5. 나머지
		 * q. 종료
		 * 메뉴를 선택하세요 : q
		 * 프로그램을 종료합니다.
		 * 
		 * */
		
		Scanner scan = new Scanner(System.in);
		/* 
		//방법1.
		 */
		for(; ;) {
			System.out.println("산술 연산자 메뉴 "); // 문자를 입력받아
			System.out.println("1. 더하기"); // 문자를 입력받아
			System.out.println("2. 빼기"); // 문자를 입력받아
			System.out.println("3. 곱하기"); // 문자를 입력받아
			System.out.println("4. 나누기"); // 문자를 입력받아
			System.out.println("5. 나머지"); // 문자를 입력받아
			System.out.println("q. 종료"); // 문자를 입력받아
			System.out.print("메뉴를 선택하세요 : "); // 문자를 입력받아
			char ch = scan.next().charAt(0); // 입력받아
			if(ch == 'q') { //ch가 q인지 확인
				break;		
			} 
			if(ch < '1' || ch > '5') {
				System.out.println("잘못된 연산자 입니다.");
				continue;
			}
			System.out.print("두 정수를 입력하세요. (예 : 1 2) : ");
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();
			double res = 0.0;
			switch(ch) {
			case '1' : res = num1 + num2; 
			 		System.out.println(""+num1 + '+' + num2 + "=" + res);
					break;
			case '2' : res = num1 - num2;
			 		System.out.println(""+num1 + '-' + num2 + "=" + res);
					break;
			case '3' : res = num1 * num2; 
			 		System.out.println(""+num1 + '*' + num2 + "=" + res);
			 		break;
			case '4' : res = num1 / (double)num2; 
			 		System.out.println(""+num1 + '/' + num2 + "=" + res);
					break;
			case '5' : res = num1 % num2; 
			 		System.out.println(""+num1 + '%' + num2 + "=" + res);
					break;
			}
			
			// 아래는 내가 짠 코드
			
//			System.out.print("산술 연산자를 입력하세요. : ");
//			char op = scan.next().charAt(0);
//			if (op == '+') {       
//			  System.out.println(""+num1 + op + num2 + "=" + (num1 + num2));		
//			  } else{ 
//			  System.out.println("프로그램을 종료합니다.");
//		    }
//        }
		
		/*
		 //방법2.
		 * 
		char ch = 'a'; 
		for ( ; ch != 'q';) {
			System.out.print("문자를 입력 : "); // 문자를 입력받아
			ch = scan.next().charAt(0); // 입력받아
			System.out.println(ch); // 입력받은 문자를 출력
		}
		*/
		/*
		 //방법3.
	    char ch = 'w'; // 알파벳 아무거나 와도 실행 가능
	    do {
	    	System.out.print("문자를 입력 : "); // 문자를 입력받아
			ch = scan.next().charAt(0); // 입력받아
			System.out.println(ch); // 입력받은 문자를 출력
	    }while(ch != 'q');
	    */
		//scan.close(); //필수는 아님
	   }
	}
}
