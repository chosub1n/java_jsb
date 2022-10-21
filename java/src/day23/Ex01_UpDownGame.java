package day23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01_UpDownGame {

	public static void main(String[] args) {
		
		/* - 1~100사이의 랜덤한 수를 맞추는 Up Down 게임 프로그램을 작성하세요.
		 * - 기록을 저장하는 기능을 추가
		 * - 기록은 최대 5등까지
		 * - 5등 이내의 기록은 이름을 기록하여 저장
		 * - 한 사람이 여러 기록을 가질 수 있다.
		 * - 같은 기록인 경우 기록된 순서대로 정렬
		 * - 잘못된 정수를 입력해도 시도한 걸로 인정
		 * 
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * */
		
		List<Record> list = new ArrayList<Record>();
		Scanner scan = new Scanner(System.in);
		int exitMenu = 3;
		int menu;
		int min = 1, max = 100;
		
		
		do {
			System.out.println("--UpDownGame--");
			System.out.println("1. 플레이");
			System.out.println("2. 기록 확인");
			System.out.println("3. 종료");
			System.out.print("메뉴를 선택하세요 : ");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1: //플레이
				int r = (int)(Math.random() * (max-min+1) + min); //플레이 할 때마다 랜덤한 수 한 번만 나오게
				System.out.println("랜덤으로 생성한 수 : " + r);
				int count = 0;
				while(true) {
					System.out.print("1~100사이의 수를 입력하세요. : " );
					int num = scan.nextInt();
					count++;
					
					if(num < 1 || num > 100) {
						continue;
					}if(num > r) {
		    			System.out.println("DOWN");
			 		}else if (num < r){
						System.out.println("UP");
			 		}else
						break;
					}	
					System.out.println("정답입니다.");
					//사용자도 입력, 몇 번만에 맞췄는지.. 몇 번만에 끝냈는지.. 
					//기록을 저장. 관리하는 기능
					/* 1. 1 홍길동
					 * 2. 1 임꺽정
					 * 3. 2 홍길동
					 * 4. 3 유관순
					 * 5. 4 고길동
					 * 
					 * 5개 이상인 경우는 횟수를 비교해서 더 작으면 넣어줌
					 * 5개 보다 작으면 이름 입력 받아서 그냥 추가
					 * 
					 * //저장된 기록이 6이상인 경우 5번지를 삭제 
					 * //if(list.size () > 5) {
						//list.remove(5);  //저장된 기록이 6이상인 경우 5번지를 삭제
						//}	
					 *
					 *정렬도 해줘야 됨
					 * 
					 * */		
				
			
			case 2: //기록 확인 //기록 5등 이내는 이름을 넣어줌.
				
				break;
			
			case 3: 
				System.out.println("게임이 종료되었습니다.");
				break;
			default:
			}
		}while(menu != exitMenu);
		scan.close();		
	}
}
//클래스로 기록 관리
class Record{
	private int count;
	private String name;
	
	public Record(int count, String name) {
		this.count = count;
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "[ " + name + " : " + count + "]";
	}
	
}
