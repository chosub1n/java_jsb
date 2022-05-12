package day12;

public class Drink extends Product {

	private int capacity; //용량 ml
	
	public Drink(String name, int price, int amout, int capacity) {
		super(name, price, amout);
		this.capacity = capacity;
	}
	public Drink(Drink product) { //마트 3번 코드을 짤 때 공유하면 안 되서 생성자를 하나 만듦.
		this(product.getName(), product.getPrice(), product.getAmount(), product.getCapacity());
	}
	@Override //추상클래스를 받았음으로 오버라이딩 해주기
	public void print() {
		if(capacity < 1000) {
			System.out.println(getName()+ "[" + capacity + "ml] : " + getPrice() + "원 - " 
					+ getAmount());			
		}
		else {
			System.out.println(getName()+ "[" + capacity/1000.0 + "l] : " + getPrice() + "원 - " 
					+ getAmount());
		}
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
