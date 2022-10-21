package day20;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
//시험봤던 예제에서 예외처리 해보기!
	public class meee {
		
	public static void main(String[] args) {
		//파일들을 관리할 리스트
		List<String> list = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		int menu;
		do {
			System.out.println("메뉴");
			System.out.println("1. 파일 저장");
			System.out.println("2. 파일 확인");
			System.out.println("3. 파일 검색");
			System.out.println("4. 프로그램 종료");
			System.out.print("메뉴를 선택하세요 : ");
			menu = scan.nextInt();
				
			switch(menu) {
			case 1: 
				System.out.print("파일명 : ");
				String inputString = scan.next();
				list.add(inputString);
				System.out.println("파일 저장이 완료되었습니다.");
				break;
			case 2: 
				for(String tmp : list) {
					System.out.println(tmp);
				}
				break;
			case 3: 
				System.out.print("검색어 : ");
				String search = scan.next();
				for(String tmp : list) {
					if(tmp.contains(search)) {
					System.out.println(tmp);						
					}
				}
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}while(menu != 4);
		
		scan.close();
	}
}
