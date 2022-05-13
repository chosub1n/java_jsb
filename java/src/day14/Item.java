package day14;

//내역
public class Item implements Cloneable{
	//날짜, 구분(수입/지출), 구분(결제방식), 상세항목, 금액
	private String date; //날짜
	private boolean income; //구분(수입/지출)
	private String payment; //구분(결제방식)
	private String content; //상세항목
	private int price; //금액
	
	@Override
	public Item clone() {
		Item obj = null;
		
		try {
			obj = (Item)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	//수정 기능
	public void modify(String date, boolean income, String payment, String content, int price) {
		if(date != null) {
			this.date = date;
		}
		if(payment != null) {
			this.payment = payment;
		}
		if(content != null) {
			this.payment = content;
		}
		if(price >= 0) { //정수라서 null로 초기화 불가능.
			this.price = price;
		}
		this.income = income; //참 혹은 거짓이기 때문에 무조건 수정 설정!
	}
	
	@Override
	public String toString() {
		return "내역 [" + date + " | " + (income?"수입" : "지출") + " | " + payment + " | " + content
				+ " | " + price + "원]";
	}

	public Item(String date, boolean income, String payment, String content, int price) {
		this.date = date;
		this.income = income;
		this.payment = payment;
		this.content = content;
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isIncome() {
		return income;
	}

	public void setIncome(boolean income) {
		this.income = income;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
