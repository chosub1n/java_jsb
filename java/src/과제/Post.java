package 과제;

import java.util.Date;

//게시글
public class Post {
	//게시글 최대 개수
	public static final int MAX = 5;
	//게시글을 최대 5개까지 작성 가능
	private Board boards[] = new Board[MAX];
	private int count; //현재 기록된 게시글의 개수
	
	/* 기능 : 게시글에 공지글/일반글을 추가하는 메소드
	 * 		새 내역(Board)이 주어지면 boards에 추가하여 추가 됐는지 알려주는 메소드
	 * 매개변수 : 새 내역 => Board board
	 * 리턴타입 : 추가 여부 => 성공/실패 => boolean
	 * 메소드명 : insertBoard
	 * */
	public boolean insertBoard(Board board) {
		//게시글에 쓸 공간이 없는 경우
		if(count == MAX) {
			return false;
		}
		//추가해야하는 내역이 비었을 때
		if(board == null) {
			return false;
		}
		boards[count++] = board;
		return true;	
	}
	
	/* 기능 : 현재까지 작성된 게시글을 확인하는 메소드
	 * 		Board에 있는 게시글들을 count에 출력하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : readBoard	
	 * */
	public void readBoard() {
		if(count == 0) {
			System.out.println("입력된 게시글이 없습니다.");
			System.out.println("====================");
			return;
		}
		for(int i = 0; i<count; i++) {
			System.out.println(i+1+". "+boards[i]);
			
		}
	}
	
	/* 기능 : 게시글에서 기존 내역을 수정하여 수정 여부를 알려주는 메소드
	 * 매개변수 : 수정할 번지, 수정할 내용들 => int modIndex, String title, String content, String username, Date date
	 * 리턴타입 : 수정 여부 => boolean 
	 * 메소드명 : modifyBoard
	 * */
	public boolean modifyBoard(int modIndex, String title, String content, String username, Date date) {
		if(modIndex >= count || modIndex < 0) {
			return false;
		}
		//수정
		boards[modIndex].modify(title, content, username, date);
		return true;
	}
	public Board getBoard(int index) {
		if(index < 0 || index >= count) {
			return null;
		}
		return boards[index].clone();
		}
	public void readItems(String type, String date) {
		switch (type) {
		case "date" :
			for(int i = 0; i < count; i++) {
				if(boards[i].getdate().equals(date)) {
					System.out.println(i+1+". " + boards[i]);
				}
			}
			break;
		}
	}

	public boolean modifyBoard(int modIndex, String date2, String title2, String content2, String username) {
		// TODO Auto-generated method stub
		return false;
	}
}
