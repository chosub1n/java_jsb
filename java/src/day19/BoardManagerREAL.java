package day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardManagerREAL {
	
	public static void main(String[] args) {
		
		//게시글 리스트! 리스트를 활용해서 게시글들을 담을 공간을 만들어준다.
		List<Board> list = new ArrayList();
		//콘솔에서 입력받기 위해 스캐너를 불러옴
		Scanner scan = new Scanner(System.in);
		//프로그램 종료 번호
		int exictMenu = 4;
		//종료 메뉴를 선택할 때까지
		int menu;
		
		String title, content, writer, type;
		int num, view;
		do {
			System.out.println("메뉴");
			System.out.println("1. 게시글 등록");
			System.out.println("2. 게시글 확인");
			System.out.println("3. 게시글 수정");
			System.out.println("4. 프로그램 종료");
			System.out.println("메뉴를 선택하세요 : ");
			menu = scan.nextInt();
		
		switch(menu) {
		//게시글 등록!
		case 1:
			System.out.println("게시글 정보를 입력하세요.");
			System.out.print("[일반], [공지] : ");
			type = scan.next();
			scan.nextLine();
			//제목 입력
			System.out.print("제목 : ");
			title = scan.nextLine();
			
			// 내용 입력
			System.out.print("내용 : ");
			content = scan.nextLine();
			
			//작성자 입력
			System.out.print("작성자 : ");
			writer = scan.next();
			
			//게시글 생성 후 저장
			list.add(new Board(type, title, content, writer));
			
			break;
		
		case 2: //메뉴를 선택!!
			//우선 전체 게시글을 불러온다.
			System.out.println("번호\t타입 제목 \t 작성자 \t 작성일 \t 조회수");
			//향상된 for문을 사용.. 게시글확인이라서 전체값을 확인하기 위해 사용하는 건가??
			//두 변수에 담긴 값을 서로 바꾸려면 임시 저장소로 사용할 변수 'tmp'를 넣어주면 된다.
			for(Board tmp : list) {
				System.out.println(tmp);
			}
			//상세 게시글 선택
			System.out.println("게시글 선택하세요. 나가려면 -1을 입력하세요. : ");
			num = scan.nextInt();
			//게시글 상세 확인
			if(num >= 0) {
				Board tmp = list.get(num-1); //-1를 해서 0번지(1번)부터 가져오게!
				//조회수 증가
				view = tmp.getView();
				tmp.setView(view+1);
				//가져온 게시글 상세 내용 확인
				tmp.detailprint();
			}
			break;
		case 3: //게시글 수정 
			//전체 게시글 확인
			System.out.println("번호\t타입 제목 \t 작성자 \t 작성일 \t 조회수");
			for(Board tmp : list) {
				System.out.println(tmp);
			}
			System.out.println("게시글 선택 : ");
			num = scan.nextInt();
			scan.nextLine();
			
			//게시글 제목 입력
			System.out.print("제목 : ");
			title = scan.nextLine();
			
			//게시글 내용 입력
			System.out.print("내용 : ");
			content = scan.nextLine();
			
			//게시글 수정하기 위해 선택한 게시글을 가져옴
			Board tmp = list.get(num-1);
			//가져온 게시글 중 제목과 내용을 수정
			tmp.modify(title, content);
			break;
		case 4:
			break;
		default:
		}
	}while(menu != exictMenu);
		
	}
}
