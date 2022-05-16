package day15;

public class Ex7_Exception_TryCatchFinally {

	public static void main(String[] args) {
		int num1 = 1, num2 = 0;
		int res = 0;
		try {
			/* -예외가 발생했을 때 예외 처리를 안 하면 프로그램이 중단 되지만
			 *  예외를 처리하면 프로그램이 중단되지 않고 예외처리를 한 후에 이어서 시작
			 * -예외가 발생하면 밑에 코드가 있던 없던 상관없이 예외를 처리할 수 있는 catch로 이동을 해서
			 *  (예외를 처리할 수 있는 catch가 없는 경우 처리할 수 없어서 프로그램 중단) 예외처리를 함
			 * - catch는 여러 개가 올 수 있고(1개 이상),Exception을 처리한다면 Exception은 무조건 마지막 catch에 배치해야 함.*/
			res = num1 % num2;
			System.out.println(res);
		}
		//RuntimeException은 ArrayIndexOutOfBoundsException 위에 추가하면 에러 발생.
		//ArrayIndexOutOfBoundsException가 발생해도 RuntimeException에서 걸리기 때문에
		//ArrayIndexOutOfBoundsException에 올 일이 없음.
		//catch (RuntimeException e) {}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		//Exception을 사용할 거면 제일 마지막에 써주기! 
		}catch(Exception e) {
			System.out.println("예외 발생");
			return ;
		} finally {
			/* 예외처리 후 메소드가 종료되도 무조건 finally는 실행*/
			System.out.println("finally입니다.");
		}
		//예외 발생. 위에 Exception e 때문에 ArithmeticException까지 올 일이 절대 없기 때문
		//catch(ArithmeticException e) {}
		System.out.println("프로그램 종료"); 
	}

}
