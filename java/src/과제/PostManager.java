package 과제;

import java.util.Date;
import java.util.Scanner;

import day14.AccountBook;


public class PostManager implements ConsoleProgram {
	private Scanner scan;
	private Post post; //게시글
	private final int exitMenu = 4; //종료 메뉴 번호
	private Object title;
	
	public PostManager (Scanner scan) {
		this.scan = scan;
		post = new Post();
		//샘플 데이터(테스트용)
		Board board = new Board();
		post.insertBoard(board);
	}

	@Override
	public int selectMenu(Scanner scan) {
		System.out.println("=======메뉴=======");
		System.out.println("1. 게시글 등록(공지/일반)"); //제목 내용 작성자 등록날짜
		System.out.println("2. 게시글 확인"); // 조회수 증가
		System.out.println("3. 게시글 수정");
		System.out.println("4. 프로그램 종료");
		System.out.println("메뉴 선택 : ");
		int menu = scan.nextInt();
		System.out.println("=================");
		return menu;
	}

	@Override
	public void excute(int menu) {
		Object subMenu;
		switch(menu) {
		case 1:
			//게시글 등록(공지글/일반글)
			if(insertPost()) {
				System.out.println("게시물을 추가했습니다.");
			}else {
				System.out.println("게시물 추가에 실패했습니다.");
			}
			System.out.println("=====================");
			break;
		case 2:
			//게시글 확인
			readPost();
			break;
		case 3:
			//게시글 수정
			if(modifyPost()) {
				System.out.println("수정에 성공했습니다");
			}else {
				System.out.println("수정에 실패했습니다.");
			}
			System.out.println("====================");
			break;
		case 4:
			break;
			default:
				System.out.println("잘못된 메뉴입니다.");
				System.out.println("====================");
		}
		
	}


	private boolean modifyPost() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean insertPost() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void run() {
		int menu;
		do {
			menu = selectMenu(scan);
			excute(menu);
		} while (menu != exitMenu);
		System.out.println("게시글이 종료되었습니다.");
		System.out.println("======================");
	}

	public void readPost() {
		System.out.println("=====================");
		System.out.println("게시글을 확인합니다. (1.공지, 2.일반) 선택 : ");
		int subMenu = scan.nextInt();
		switch(subMenu) {
		case 1:
			System.out.print("공지를 확인하세요 : ");
			String title = scan.next();
			//post.readBoards("title" ,title);
			break;
		case 2:
			post.readBoard();
			break;
		default:
			System.out.println("잘못 선택했습니다.");
		}	
		System.out.println("====================");
	}
	 //게시글 수정
	public boolean modifyPost1() {
		post.readBoard();
		System.out.print("수정할 항목(정수) : ");
		int modIndex = scan.nextInt();
		System.out.println("====================");
		//게시글에서 수정하려고 한 내역을 출력
		Board tmp = post.getBoard(modIndex-1);
		if(tmp != null) {
			System.out.println(modIndex + ". " + tmp);
		}else {
			return false;
		}
		System.out.println("====================");
		System.out.print("선택한 항목은 위 내역입니다. 수정하시겠습니까?[예:true/아니오:false] :");
		boolean ok = scan.nextBoolean();
		if(!ok) {
			return false;
		}
		System.out.print("날짜를 수정하겠습니까?[예:true/아니오:false] : ");
		ok = scan.nextBoolean();
		String date2 = null;
		if(ok) {
			System.out.println("날짜 : ");
			date2 = scan.next();
		}
		System.out.print("제목을 수정하겠습니까?[예:true/아니오:false] :");
		ok = scan.nextBoolean();
		String title2 = null;
		if(ok) {
			System.out.print("제목 : ");
			title2 = scan.next();
		}
		System.out.print("내용을 수정하겠습니까?[예:true/아니오:false] :");
		ok = scan.nextBoolean();
		String content2 = null;
		if(ok) {
			System.out.println("내용 : ");
			content2 = scan.next();
		}
		System.out.print("작성자 이름을 수정하겠습니까?[예:true/아니오:false] :");
		ok = scan.nextBoolean();
		String username = null;
		if(ok) {
			System.out.print("작성자 : ");
			username = scan.next();
		}
		return post.modifyBoard(modIndex-1, date2, title2, content2, username);
	}

	


		
	
	

}
