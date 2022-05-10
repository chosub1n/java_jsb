package day11;

import java.util.Scanner;

public class Ex1_Class_Student {

	public static void main(String[] args) {
		/*다음 조건을 만족하는 학생 관리 프로그램을 작성하여 코드 및 결과화면을 캡처하여 제출하세요.
		조건1 > 학생(Student) 클래스
		 - 학생 이름, 학년, 반, 번호를 필드로 가짐
		 - 학생 정보를 출력하는 메소드를 가짐(print)
		 - 학생 이름, 학년, 반, 번호를 이용하여 필드를 초기화하는 생성자를 가짐
		조건2 > 메뉴
		 1. 학생 정보 입력
		 2. 학생 정보 출력
		 3. 프로그램 종료
		 <결과 예시>
		 1. 학생 정보 입력
		 2. 학생 정보 출력
		 3. 프로그램 종료
		 메뉴를 선택하세요 : 1
		 이름 : 홍길동
		 학년 : 1
		 반   : 1
		 번호 : 1
		 메뉴
		 1. 학생 정보 입력
		 2. 학생 정보 출력
		 3. 프로그램 종료
		 메뉴를 선택하세요 : 2
		 1학년 1반 1번 홍길동
		 메뉴
		 1. 학생 정보 입력
		 2. 학생 정보 출력
		 3. 프로그램 종료
		 메뉴를 선택하세요 : 3
		 프로그램을 종료합니다. */
		
		int menu = -1;
		Scanner scan = new Scanner(System.in);
		Student str = new Student("", 1, 1, 1);
		for(; menu !=3; ) {
			System.out.println("메뉴");
			System.out.println("1. 학생 정보 입력");
			System.out.println("2. 학생 정보 출력");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴를 선택하세요 : ");
			menu = scan.nextInt();		
			switch(menu) {
			case 1:        
				System.out.println("학생 정보 입력 :" );
				int grade = scan.nextInt();
				int classNumber = scan.nextInt();
				int number = scan.nextInt();
				String name = scan.next();
				str = new Student(name, grade, classNumber, number);
				break; 
			case 2:  
				str.print();
				break; 
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}
		scan.close();		
	}
}

class Student{
	//학생 이름, 학년, 반, 번호
	String name;
	int grade;
	int classNumber;
	int number;
	
	void print() {
		System.out.println(grade + "학년 " + classNumber + "반 " + number + "번 " + name);
	}	
	
	public Student(String name, int grade, int classNubmer, int number) {
		this.name = name;
		this.grade = grade;
		this.classNumber = classNubmer;
		this.number = number;	

	}

}
