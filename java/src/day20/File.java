package day20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class File {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		int exitMenu = 4;
		int menu;
		
		String fileName;
		do {
			System.out.println("메뉴");
			System.out.println("1. 파일 저장");
			System.out.println("2. 파일 확인");
			System.out.println("3. 파일 검색");
			System.out.println("4. 프로그램 종료");
			System.out.print("메뉴를 선택하세요 : ");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1: //파일 저장
				System.out.print("파일명 : ");
				fileName = scan.next();
				list.add(new String(fileName));
				System.out.println("파일 저장이 완료되었습니다.");
				break;
			
			case 2: //파일 확인
				for(String tmp : list) {
					System.out.println(tmp);
				}
				break;
			
			case 3: //파일 검색
				System.out.print("검색어 : ");
				fileName = scan.next();
				for(String tmp : list) {
					if(tmp.contains(fileName)) {
						System.out.println("검색 결과");
						System.out.println(tmp);						
					}
				}
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
			}
		}while(menu != exitMenu);
		
		scan.close();
	}
}
