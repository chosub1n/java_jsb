package day24;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day14.ConsoleProgram;

public class PhoneManager implements ConsoleProgram{
	
	private Scanner scan;
	private int exitMenu = 4;
	private List<PhoneNumber> list = new ArrayList<PhoneNumber>();

	public PhoneManager(Scanner scan) {
		this.scan = scan != null ? scan : new Scanner(System.in);
		//아래 코드 간결한게 만든 것이 위 조건연산자 코드!
		if(scan != null)
			this.scan = scan;
		else
			this.scan = new Scanner(System.in);
	}

	@Override
	public int selectMenu(Scanner scan) {
		System.out.println("메뉴");
		System.out.println("1. 전화번호 추가");
		System.out.println("2. 전화번호 확인");
		System.out.println("3. 전화번호 검색");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴를 선택하세요 : ");
		return scan.nextInt();
	}

	@Override
	public void excute(int menu) {
		switch(menu) {
		case 1: 
			insertPhoneNumber();
			break;
		case 2: 
			printPhoneNumber();
			break;
		case 3:
			searchPhoneNumber();
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴를 선택했습니다.");
		}
		
	}

	@Override
	public void run() {
		int menu;
		do {
			menu = selectMenu(scan);
			excute(menu);
		}while(menu != exitMenu);
		
	}

	private void insertPhoneNumber() {
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("번호 : ");
		String number = scan.next();
		list.add(new PhoneNumber(name, number));
	}
	
	private void printPhoneNumber() {
		for(PhoneNumber tmp : list) {
			System.out.println(tmp);
		}
		
	}
	private void searchPhoneNumber() {
		System.out.print("이름 : ");
		String name = scan.next();
		for(PhoneNumber tmp : list) {
			if(tmp.getName().contains(name))
			System.out.println(tmp);
		}
		
	}
	
}
