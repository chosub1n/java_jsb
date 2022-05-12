package day12;

public class SnackBox extends Product {

	private int count; 
	
	public SnackBox(String name, int price, int amount, int count) {
		super(name, price, amount);
		this.count = count;
	}
	public SnackBox(SnackBox product) { //마트 3번 코드을 짤 때 공유하면 안 되서 생성자를 하나 만듦.
		this(product.getName(), product.getPrice(), product.getAmount(), product.getCount());
	}
	@Override  //추상클래스를 받았음으로 오버라이딩 해주기
	public void print() {
		System.out.println(getName() + "[박스 당" + count + "개] : " + getPrice() + "원 - " 
			+ getAmount());
	
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	

}
