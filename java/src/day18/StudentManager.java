package day18;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import day14.ConsoleProgram;

public class StudentManager implements ConsoleProgram {
	
	private Scanner scan;
	private List<Student> list;
	private int exitMenu = 5;
	
	//여러 종류의 생성자을 만들어 봄.
	public StudentManager() {
		scan = new Scanner(System.in);
		list = new ArrayList<Student>();
	}
	public StudentManager(Scanner scan) {
		this.scan = scan;
		list = new ArrayList<Student>();
	}
	public StudentManager(Scanner scan, int size) {
		this.scan = scan;
		list = new ArrayList<Student>(size);
	}	

	@Override
	public int selectMenu(Scanner scan) {
		System.out.println("----------메뉴----------");
		System.out.println("1. 학생 정보 입력");
		System.out.println("2. 학생 정보 출력");
		System.out.println("3. 학생 정보 수정");
		System.out.println("4. 학생 정보 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴를 선택하세요 : ");
		int menu = scan.nextInt();
		System.out.println("-----------------------");
		return menu;	
	}

	@Override
	public void excute(int menu) {
		switch(menu) {
		case 1:
			//학생 정보를 Scanner로 입력받아서 입력받은 정보로 이루어진 학생 객체를 받아오는 메소드
			Student std = inputStudent();
			//학생정보를 추가
			insertStudent(std);
			break;
		case 2:
			printStudent();
			break;
		case 3:
			//학년 반 번호 => 학생 객체(A)를 생성
			Student modStd = inputSearchStudent();

			int index = list.indexOf(modStd);
			//학생 객체가 리스트에 있으면
			if(index >= 0) {
				//수정할 이름, 국어, 영어, 수학을 입력받아 학생객체(A)를 수정
				inputAddtionStudent(modStd);
				//리스트에서 학생객체(A)로 수정	
				list.set(index, modStd);
			}			
			//없으면 학생이 없다고 알려줌
			else {
				 printMessage("등록되지 않은 학생입니다. 학생 정보 입력을 이용하세요.");
			}
			break;
		case 4:
			Student delStd = inputSearchStudent();
			if(list.remove(delStd)) {
				printMessage("학생 정보를 삭제했습니다");
			}else {
				printMessage("등록되지 않은 학생입니다. 삭제할 수 없습니다.");
			}
			break;
		case 5:
			break;
		default:
			 printMessage("잘못된 메뉴를 선택했습니다!!!!");
		}
	}
	@Override
	public void run() {
		int menu;
		do {
			try {
				menu = selectMenu(scan);
				excute(menu);
			}catch(Exception e) {
				menu = 0;
				printMessage("잘못된 형태의 메뉴를 입력했습니다.");
				scan.nextLine();
			}
		}while(menu != exitMenu);	
	}
	
	private Student inputStudent() { //트라이캐치로 예외처리
	 try {
		 System.out.println("학생 정보를 입력하세요.");
		 System.out.print("학년 반 번호 이름 입력 : ");
		 int grade = scan.nextInt();
		 int classNum = scan.nextInt();
		 int num = scan.nextInt();
		 String name = scan.next();
		 System.out.print("국어 영어 수학 성적 입력 : ");
		 int kor = scan.nextInt();
		 int eng = scan.nextInt();
		 int math = scan.nextInt();
		 return new Student (grade, classNum, num, name, kor, eng, math);
	 }catch(Exception e) {
		  printMessage("입력에서 잘못된 값을 입력했습니다. 입력이 취소됩니다.");
		 //입력을 잘못했을 때 입력 버퍼에 있는 내용들을 문자열로 가져옴 (입력버퍼를 비우는 역할)
		 scan.nextLine();
		 return null;
		}
	}//inputStudent 
	
	private void insertStudent(Student std) {
		if(std == null) {
			return;
		}
		if(list.contains(std)) {
			 printMessage("이미 추가된 학생입니다. 학생 정보 수정을 이용하세요.");
			 return;
		}	
		list.add(std);
		list.sort(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.getGrade() != o2.getGrade()) {
					return o1.getGrade() - o2.getGrade();
				}
				if(o1.getClassNum() != o2.getClassNum()) {
					return o1.getClassNum() - o2.getClassNum();
				}
				if(o1.getNum() != o2.getNum()) {
					return o1.getNum() - o2.getNum();
				}
				return 0;
			}
		});
		printMessage("학생 정보 추가가 완료되었습니다.");
	}//insertStudent
	
	private void printStudent() {
		if(list.size() == 0) {
			printMessage("저장된 학생 정보가 없습니다.");
			return;
		}
		System.out.println("-----------------------");
		for(Student tmp : list) {
			System.out.println(tmp);
		}
		System.out.println("-----------------------");
	}//printStudent
	
	private Student inputSearchStudent() { 
		try {
		System.out.println("검색할 학생 정보를 입력하세요.");
		System.out.print("학년 반 번호 입력 : ");
		int grade = scan.nextInt();
		int classNum = scan.nextInt();
		int num = scan.nextInt();
		return new Student (grade, classNum, num, null, 0, 0, 0);
	}catch(Exception e) {
	 	 printMessage("입력에서 잘못된 값을 입력했습니다. 입력이 취소됩니다.");
		//입력을 잘못했을 때 입력 버퍼에 있는 내용들을 문자열로 가져옴 (입력버퍼를 비우는 역할)
		scan.nextLine();
		return null;
		}
	}//inputSearchStudent
	
	private void inputAddtionStudent(Student std) {
		if(std == null) {
		 printMessage("학생 정보가 없습니다.");
		 return;
	 }
	 try {
		 System.out.println("수정할 학생 정보를 입력하세요.");
		 System.out.print("이름 국어 영어 수학 입력 : ");
		 String name = scan.next();
		 int kor = scan.nextInt();
		 int eng = scan.nextInt();
		 int math = scan.nextInt();
		 std.modify(name, kor, eng, math);
	 }catch(Exception e) {
		 printMessage("입력에서 잘못된 값을 입력했습니다. 입력이 취소됩니다.");
		 //입력을 잘못했을 때 입력 버퍼에 있는 내용들을 문자열로 가져옴 (입력버퍼를 비우는 역할)
		 scan.nextLine();
		 return;
	   }
	}//inputAdditionStudent 
		
	private void printMessage(String message) {
		 System.out.println("-----------------------");
		 System.out.println(message);
		 System.out.println("-----------------------");
	   }
}
