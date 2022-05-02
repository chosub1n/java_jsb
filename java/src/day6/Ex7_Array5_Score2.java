package day6;

import java.util.Scanner;

public class Ex7_Array5_Score2 {
	
	public static void main(String[] args) {
		/* 최대 10명 학생의 성적을 저장하기 위한 배열을 선언하고,
		 * 입력할 학생 수를 입력을 받아 입력 받은 학생 수 만큼 성적을 입력받고 총점과 평균을 출력하는 코드를 작성하세요.
		 * 예1>
		 * 학생 수를 입력하세요 : 3
		 * 1번 학생 : 90
		 * 2번 학생 : 80
		 * 3번 학생 : 70
		 * 총점 : 240점, 평균 80점
		 * 
		 * 예2>
		 * 학생 수를 입력하세요 : 11
		 * 최대 10명까지 입니다.
		 * 
		 * 예3>
		 * 학생 수를 입력하세요 : 9
		 * 최소 1명부터 입니다.
		 * */
		//scan 선언
		Scanner scan = new Scanner(System.in);
		//배열 선언 10개짜리
		int max = 10;
		int [] score = new int [max];
		//학생 수 입력
		System.out.print("학생의 수를 입력하세요.");
		int count = scan.nextInt(); // 변수 자리에 count가 굳이 안 와도 됨. num가 와도 됨. 상관없음.
		//입력받은 학생 수가 10보다 크면 최대 10명까지 입니다. 라고 출력
		if(count > 10) {
			System.out.println("최대 10명까지 입니다.");
		}
		//(입력받은 학생 수가 10보다 크지 않고) 0보다 작거나 같으면 최소 1명 부터 입니다. 라고 출력
		else if(count <= 0) {
			System.out.println("최소 1명부터 입니다.");
		}
		//(입력받은 학생 수가 10보다 크지 않고 0보다 작거나 같지 않으면) 입력받은 학생 수만큼 성적 입력 후 총점 계산
		else {
			int sum = 0;
			double avg = 0.0;
			for(int i = 0; i < count; i++) {
				System.out.print(i+1+"번 학생 : ");
				score[i] = scan.nextInt();
				sum += score[i];
		}
		//평균 계산
			avg = (double)sum/count;
		//총점과 평균 출력
			System.out.println("총점 : " + sum + "점 , 평균 : " + avg + "점 입니다.");
		
			
			// 아래는 내가 짠 코드...
//		// 최대 10명 학생의 성적을 저장하기 위한 배열을 선언하고,
//		int [] score = new int [11];
//		Scanner scan = new Scanner(System.in);
//		System.out.println("학생의 수를 입력하세요.");
//		int sum = 0;
//		double avg = 0;
//		// 입력할 학생 수를 입력을 받아
//		for(int i = 1; i < score.length; i++) {
//			System.out.print(i+"번 학생 : ");
//			score[i] = scan.nextInt();
//			sum += score[i];
//		}
//		// 입력 받은 학생 수 만큼 성적을 입력받고
//		int i = 0;
//		
//		if(i > 10) {
//			System.out.println("최대 10명까지 입니다.");
//		}
//		else if(i < 10 || i >= 0) {
//			System.out.println("최소 1명부터 입니다.");
//		}
//		else {
//			System.out.println(i + "번 학생의 성적 : ");
//		}
//		// 총점과 평균을 출력하는 코드를 작성
//		for (int i1 = 1; i1 < score.length; i1++) {
//			sum += score[i1];
//		}
//		 avg = sum/(double)score.length;
//		System.out.println("총점 : " + sum + "점 , 평균 : " + avg + "점 입니다.");
//		
//	
		}
	}
}
