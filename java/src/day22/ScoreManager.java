package day22;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import day14.ConsoleProgram;

/*
 *  ####기능정리####
	1. 성적 추가
	- 성적 추가시 과목명, 중간성적, 기말성적, 수행평가 성적, 학년, 학기를 입력한다.
	- 과목명은 국어와 같은 문자열이다.
	- 기말, 중간, 수행평가는 0~100사이의 정수이다.
	- 학년은 1~3사이의 정수, 학기는 1~2사이의 정수
	- 입력된 성적 정보가 이미 있으면 추가하지 않고 없으면 입력된 성적 정보를 성적리트스에 추가한다.
	- 입력된 성적 정보가 있는지 확인 여부는 학년, 학기, 과목이 같으면 있다고 판별한다.

	2. 성적 확인
	- 서브 메뉴를 이용하여 다양한 방식으로 성적을 확인
	- 서브 메뉴는 1. 모든 성적 2. 학기 성적 3. 과목 성적이 있다
	- 모든 성적은 저장된 모든 성적을 출력
	- 학기 성적은 학년과 학기를 입력받아 해당 학년 - 학기에 맞는 모든 과목 성적을 출력
	- 과목 성적은 과목을 입력받으면 해당 과목의 모든 학기 성적을 출력
	- 각 성적은 학년, 학기, 과목, 중간, 기말, 수행평가, 총점으로 출력
    - 총점은 중간 40%, 기말 50%, 수행평가 10%가 반영된 점수 100점 만점이다.

	3. 성적 수정
	- 학년, 학기 과목명을 입력 받음
	- 입력받은 정보와 일치하는 성적이 있으면 중간성적, 기말성적, 수행평가 성적을 입력받아 수정한다.
	- 일치하는 성적이 없으면 수정할 수 없다고 출력한다.
 	* */

public class ScoreManager implements ConsoleProgram {

	private Scanner scan;
	private int exitMenu = 4;
	private List<Score> list = new ArrayList<Score>();

	public ScoreManager(Scanner scan) {
		if(scan == null)
			scan = new Scanner(System.in);
		this.scan = scan;
	}

	@Override
	public int selectMenu(Scanner scan) {
		System.out.println("-----------------------");		
		System.out.println("1. 성적 추가");
		System.out.println("2. 성적 확인");
		System.out.println("3. 성적 수정");
		System.out.println("4. 프로그램 종료");
		System.out.println("-----------------------");
		System.out.print("메뉴를 선택하세요 : ");
		return scan.nextInt();
	}

	@Override
	public void excute(int menu) {
		switch(menu) {
		case 1: //성적 추가 
			if(addScore()) {
				printMessage("성적을 추가했습니다.");
			}else {
				printMessage("이미 등록된 과목 성적입니다.");
			}
			break;
		case 2: //성적 확인 
			printScore();
			break;
		case 3: //성적 수정
			modifyScore();
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴를 선택했습니다.");
		}
		
	}


	private void printScore() {
		
		sort();
		
		System.out.println("-----------------------");
		System.out.println("성적 확인 메뉴");
		System.out.println("1.모든 성적 확인");
		System.out.println("2.학기 성적 확인");
		System.out.println("3.과목 성적 확인");
		System.out.println("-----------------------");
		System.out.println("메뉴를 선택하세요. : ");
		int menu = scan.nextInt();
		switch(menu) {
		case 1:
			printScoreList(s->true); //람다식
//			printScoreList(s->{  //이 코드를 줄여서 쓰면 위에 코드임.
//				return true;
//			});
			break;
		case 2:
			System.out.print("학년 : ");
			int grade = scan.nextInt();
			System.out.print("학기 : ");
			int term = scan.nextInt();
			printScoreList(s->s.getGrade() == grade && s.getTerm() == term); //람다식
			break;
		case 3:
			System.out.println("과목");
			String name = scan.next();
			printScoreList(s->s.getName().equals(name)); //람다식
			break;
		default:
			System.out.println("잘못된 메뉴를 선택했습니다.");
		}
		
	}
	private void sort() { //람다식을 이용한 정렬
		list.sort((Score s1, Score s2) -> {
			if(s1.getGrade() != s2.getGrade())
				return s1.getGrade() - s2.getGrade();
			if(s1.getTerm() != s2.getTerm())
				return s1.getTerm() - s2.getTerm();
			return s1.getName().compareTo(s2.getName());
		});
		
	}

	private void printScoreList(Predicate<Score> p) {
		List<Score> tmpList = new ArrayList<Score>();
		
		for(Score tmp : list) {
			if(p.test(tmp)) {
				tmpList.add(tmp);
			}
		}
		
		if(tmpList.size() == 0) {
			printMessage("출력할 성적이 없습니다.");
		}else {
			System.out.println("-----------------------");
			for(Score tmp : tmpList) {
				System.out.println(tmp);
			}
			System.out.println("-----------------------");
		}
	}

	private boolean addScore() {
		System.out.println("-----------------------");
		System.out.println("추가할 학생 정보를 입력하세요.");
		//학년, 학기, 과목을 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학기 : ");
		int term = scan.nextInt();
		System.out.print("과목 : ");
		String name = scan.next();
		
		//학년, 학기 과목이 같은 성적이 성적 리스트에 있으면 있다고 알림
		Score tmp = new Score(grade, term, name);
		if(list.contains(tmp)) {
			System.out.println("-----------------------");
			return false;	
		}
		//중간, 기말, 수행평가을 입력
		System.out.print("중간 : ");
		int midterm = scan.nextInt();
		System.out.print("기말 : ");
		int finals = scan.nextInt();
		System.out.print("수행평가 : ");
		int pa = scan.nextInt();
		
		//성적 정보를 성적 리스트에 추가
		tmp = new Score(grade, term, name, midterm, finals, pa);
		list.add(tmp);
		return true;
	}

	@Override
	public void run() {
		//샘플 데이터 추가
		list.add(new Score(1, 1, "국어", 100, 100, 90));
		list.add(new Score(1, 2, "국어", 90, 100, 90));
		list.add(new Score(1, 1, "영어", 100, 80, 90));
		list.add(new Score(1, 1, "수학", 70, 100, 90));
		
		int menu = -1;
		do {
			try {
				menu = selectMenu(scan);
				excute(menu);
			}catch(InputMismatchException e) {
				printMessage("올바른 값을 입력하세요.");
				scan.nextLine();
			}catch(RuntimeException e) {
				printMessage(e.getMessage());
			}catch(Exception e) {
				printMessage("예외 발생 : " + e.getMessage());
			}
		}while(menu != exitMenu);	
	}
	
	private boolean modifyScore() {
		System.out.println("-----------------------");
		System.out.println("수정할 학생 정보를 입력하세요.");
		//학년, 학기, 과목을 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학기 : ");
		int term = scan.nextInt();
		System.out.print("과목 : ");
		String name = scan.next();
		
		//학년, 학기 과목이 같은 성적이 성적 리스트에 있으면 있다고 알림
		Score tmp = new Score(grade, term, name);
		int index = list.indexOf(tmp);
		if(index < 0) {
			System.out.println("-----------------------");
			return false;	
		}
		//중간, 기말, 수행평가을 입력
		System.out.print("중간 : ");
		int midterm = scan.nextInt();
		System.out.print("기말 : ");
		int finals = scan.nextInt();
		System.out.print("수행평가 : ");
		int pa = scan.nextInt();
		
		/* 이 코드는 중간에 잘못 입력하면 잘못 입력되기 전까지의 정보만 수정됨
		//리스트에서 학년, 학기, 과목이 같은 성적 정보를 가져옴
		tmp = list.get(index);
		//가져온 성적 정보를 수정 //수정 메소드를 미리 만들지 않아서 set을 이용함.
		tmp.setMidterm(midterm);
		tmp.setFinals(finals);
		tmp.setPerfomanceAssessmant(pa);
		return true;
		*/
		
		//정보 수정하는 두 번째 방법.
		//이 코드는 중간에 잘못 입력하면 정보 자체가 수정되지 않음
		tmp =  new Score(grade, term, name, midterm, finals, pa);
		list.remove(tmp); //기존에 있던 학생 정보를 삭제
		list.add(tmp); //수정한 학생 정보를 추가
		return true;
	}

	
	private void printMessage(String str) {
		System.out.println("-----------------------");
		System.out.println(str);
		System.out.println("-----------------------");
		
	}
}

