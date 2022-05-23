package day20;

public class Ex4_Thread3 {

	public static void main(String[] args) {
		/* - 한 계좌에 동시에 2명이 접근해서 천원을 빼갈 때 생길 수 있는 문제점
		 *   =>두 개 이상의 스레드가 하나의 자원을 같이 이용하는 경우 생길 수 있는 문제점*/
		
		BankBook book = new BankBook(10000);
		User user1 = new User(book);
		user1.start();
		
		User user2 = new User(book);
		user2.start();

	}

}
class User extends Thread{
	BankBook book;
	
	//유저의 통장을 만들어서
	public User(BankBook book) {
		this.book = book;
	}
	//1000원을 출금
	@Override
	public void run() {
		book.withdraw(1000); //withdraw2도 실행 가능!
		
	}
}

class BankBook{
	private int money; //통장 잔액

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	//출금
	//synchronized : 동기화
	/* 메소드를 동기화하면 
	 * 어떤 쓰레드가 동기화 메소들 실행하고 있으면
	 * 다른 쓰레드에서 해당 메소드를 접근할 때, 실행이 다 끝날 때까지 일시정지했다가(Blocked)
	 * 다 끝나면 그제서야 사용할 수 있다.
	 * */
	public synchronized void withdraw(int money) {
		this.money -= money;
		try {
			Thread.sleep(1000);
			System.out.println("남은 잔액 : " + this.money);
		} catch (InterruptedException e) {}
	}
	
	public void withdraw2(int money) {
		synchronized (this) {
			this.money -= money;
			try {
				Thread.sleep(1000);
				System.out.println("남은 잔액 : " + this.money);
			} catch (InterruptedException e) {}
		}
	}
	public BankBook(int money) {
		this.money = money;
	}
}
