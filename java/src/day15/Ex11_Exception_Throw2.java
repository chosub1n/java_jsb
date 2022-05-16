package day15;


public class Ex11_Exception_Throw2 {

	public static void main(String[] args) {
		try {
			throwException2();
		}catch(RuntimeException e) {
			System.out.println("런타임 예외");
		}catch(Exception e) {
			System.out.println("예외");
		}

	}
	public static void throwException1() throws Exception {
		/*Exception(예외)클래스는 런타입예외 클래스의 부모 클래스이지 자식 클래스가 아니기 때문에
		 * 런타임 예외 클래스가 아니다.
		 * => 예외는 런타임예외가 아니기 떄문에 throw에 적어줘야 한다.*/
		throw new Exception();
	}
	
	public static void throwException2()  {
		/*런타임 예외이기 때문에 throws를 적어도 되고 안 적어도 된다.*/
		throw new RuntimeException();
	}

}
