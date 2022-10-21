package day19;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	private String type, title, content, writer;
	int num, view;
	private Date registerDate;
	
	private static int count = 0; //등록된 게시글 개수(게시글 등록 개수를 제어하기 위해 추가함)
	
	public Board(String type, String title, String content, String writer) {
		this.type = type;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.num = ++count;
		this.registerDate = new Date();
	}
	
	public Board(int i, String title2, Object object, Object object2, int j) {
		// TODO Auto-generated constructor stub
	}

	public String getRegisterDate() {
		if(registerDate == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(registerDate);
	}
	
	public void modify(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public void detailprint() {
		System.out.println("=================================");
		System.out.println("번호 : " + num);
		System.out.println("제목 : " + title);
		System.out.println("작성자 : " + writer);
		System.out.println("작성일 : " + getRegisterDate());
		System.out.println("조회수 : " + view);
		System.out.println("내용 : " + content);
		System.out.println("=================================");
	}


	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("000"); //자릿수 맞춰주는 기능
		return df.format(num) + "\t" + type + "\t" + title +  "\t" + writer + 
				getRegisterDate() + "\t" + view;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (num != other.num)
			return false;
		return true;
	}


	public void updateView() {
		view++;
		
	}

	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	
	
	
}
