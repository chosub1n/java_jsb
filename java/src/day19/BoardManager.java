package day19;

import java.util.Scanner;

import day18.Student;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class BoardManager implements ConsoleProgram  {

	private Scanner scan;
	private List<Board> list;
	private final int exitMenu = 4; //종료 메뉴 번호
	private Object registerDate;
	private int view;
	
	public BoardManager(Scanner scan) {
		this.scan = scan;
		list = new ArrayList<Board>();
	}
	
	public BoardManager(Scanner scan, int size) {
		this.scan = scan;
		list = new ArrayList<Board>(size);
	}

	@Override
	public int selectMenu(Scanner scan) {
		System.out.println("=======메뉴=======");
		System.out.println("1. 게시글 등록"); //게시글 타입, 제목, 내용, 작성자
		System.out.println("2. 게시글 확인"); //게시글 번호, 제목, 작성자, 작성일, 조회수
		System.out.println("3. 게시글 수정");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴를 선택하세요 : ");
		int menu = scan.nextInt();
		System.out.println("=================");
		return menu;
	}

	@Override
	public void excute(int menu) {
		switch(menu) {
		case 1: //게시글 등록
			//게시글을 생성
			Board bm = inputBoard();	
			//list에 게시글을 추가하고 불러오기를 해야 함.!!
			list.add(bm);
			break;
		case 2: //게시글 확인
			//printBoard();
			Board tmp = insertBoard();
			//상세 게시글을 위해 tmp의 디테일프린트를 호출
			tmp.detailprint();
			break;
		case 3: //게시글 수정
			Board modbm = inputSearchBoard();
			//Board modbm = inputAdditionBoard(modbm);
			//리스트에 있으면
			if(modbm != null) {
				inputSearchBoard();
			}else {
				System.out.println("등록되지 않은 게시글입니다. 게시글을 입력하세요.");
			}
			break;
		case 4:
			break;
		default:
			System.out.println("잘못된 메뉴를 선택했습니다.");		
		}
	}

//	private void printBoard() {
//		if(list.size() == 0) {
//			System.out.println("저장된 게시글 정보가 없습니다.");
//			return;
//		}
//		for(Board tmp : list) {
//			System.out.println(tmp);
//		}
//	}

	@Override
	public void run() {
		int menu;
		do {
			try {
				menu = selectMenu(scan);
				excute(menu);
			}catch(Exception e) {
				menu = 0;
				System.out.println("잘못된 형태의 메뉴를 입력했습니다.");
				scan.nextLine();
			}
		}while(menu != exitMenu);	
	}
	
	private Board inputBoard() {
	try {
		System.out.println("게시글을 등록하시겠습니까?");
		//글쓰기 타입
		System.out.print("[공지], [일반] : ");
		String type = scan.next();
		scan.nextLine();
		//제목 입력
		System.out.print("제목 : ");
		String title = scan.nextLine();
		// 내용 입력
		System.out.print("내용 : ");
		String content = scan.nextLine();
		//작성자 입력
		System.out.print("작성자 : ");
		String writer = scan.next();
		return new Board(type,title, content, writer);
	}catch(Exception e) {
		System.out.println("잘못된 값을 입력했습니다.");
		scan.nextLine();
		return null;
	}
}
	
	private Board insertBoard() {
	try {
		System.out.println("번호\t타입 \t 제목 \t작성자 \t작성일 \t조회수");
		for(Board tmp : list) { //향상된 for문 사용
			System.out.println(tmp);
		}
		System.out.println("게시글 선택 [나가기 : -1] : ");
		int num = scan.nextInt();
		if(num >= 0) {
			Board tmp = list.get(num-1);
			view = tmp.getView();
			tmp.setView(view+1);
			tmp.detailprint();	//조회수 증가가 안 됨! ㅜㅜ
		}
		return null;
	}catch(Exception e) {
	 	 System.out.println("잘못된 값을 입력했습니다.");
		scan.nextLine();
		return null;
		}
	}
	
	private Board inputSearchBoard() { 
		try {
		System.out.println("검색할 게시글 정보를 입력하세요.");
		System.out.print("제목 : ");
		String title = scan.nextLine();
		return new Board (null, title, null, null);
	}catch(Exception e) {
	 	 System.out.println("잘못된 값을 입력했습니다.");
		scan.nextLine();
		return null;
		}
	}
	
	private void inputAdditionBoard() {
	try {
		System.out.println("번호\t타입 제목 \t 작성자 \t 작성일 \t 조회수");
		for(Board tmp : list) { 
			System.out.println(tmp);
		}
		//게시글 선택
		System.out.print("게시글 선택 : ");
		int num = scan.nextInt();
		scan.nextLine();
		
		//게시글 제목 입력
		System.out.print("제목 : ");
		String title = scan.nextLine();
		
		//게시글 내용 입력
		System.out.print("내용 : ");
		String content = scan.nextLine();
		
		//게시글 수정
		//선택한 게시글 가져옴
		Board tmp = list.get(num-1);
		
		//가져온 게시글 수정: modify를 호출
		tmp.modify(title, content);
	}catch(Exception e) {
		System.out.println("잘못된 값을 입력했습니다.");
		scan.nextLine();
		return;
	}
	}
}
	
	
		
	
	
