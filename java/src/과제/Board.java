package 과제;

import java.util.Date;

public class Board implements Cloneable {
	//제목 내용 작성자 등록날짜 조회수
	private String title;
	private String content;
	private String username;
	private Date date;
	//private int views;
	
	@Override
	public Board clone() {
		Board obj = null;
		
		try {
			obj = (Board)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getdate() {
		return date;
	}
	public void setdate(Date date) {
		this.date = date;
	}
//	public int getViews() {
//		return views;
//	}
//	public void setViews(int views) {
//		this.views = views;
//	}
	
	@Override
	public String toString() {
		return "제목 [" + title + ", 내용: " + content + ", 작성자: " + username + ", 등록 날짜: " + date
				+ /*", 조회수: " + views +*/ "]";
	}
	
	//수정 기능
	public void modify(String title, String content, String username, Date date) {
		if(title != null) {
			this.title = title;
		}
		if(content != null) {
			this.content = content;
		}
		if(username != null) {
			this.username = username;
		}
		if(date != null) {
			this.date = date;
		}
//		if(views >= 0) { 
//			this.views = views;
//		}
		
	}
	
}

