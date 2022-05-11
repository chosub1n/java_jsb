package day12;

public class Ex4_Final {

	public static void main(String[] args) {
		FinalTest ft = new FinalTest();
		ft.print();

	}

}
//String은 final 클래스이기 때문에 상속이 불가능
//class KoreanString extends String{} => 에러 발생

class FinalTest{
	private final int max = 30;
	public final void print () {
		//max = 20; //수정할 수 없음 => max는 final이 붙어있기 때문에.
		System.out.println(max);
	}
}
class FinalTestChild extends FinalTest{
	//print()를 오버라이드 할 수 없다 => print()에 final이 붙어있기 때문에
	//public final void print() {}
}
