package day18;

import java.util.Scanner;

public class Ex3_StudentMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StudentManager sm = new StudentManager(scan);
		sm.run();
		
//테스트 한 코드		
//		Student std1 = new Student(1, 1, 1, "홍길동", 0 ,0, 0);
//	    Student std2 = std1.clone();
//	    std1.modify("임꺽정", 0, 0, 0); //같은 객체를 사용하지 않음... 그래서 공유가 안 됨,, 
//	    System.out.println(std1);
//	    System.out.println(std2);
//	    if(std1 == std2) {
//	    	System.out.println("같다.");
//	    }else {
//	    	System.out.println("다르다");
//	    }
	}

}

