package day21;

import java.util.function.*;

public class Ex4_Lamda_Consumer {

	public static void main(String[] args) {
		Consumer<String> consumer = (String str)->System.out.println(str);
		consumer.accept("안녕");
		
		//toString을 만들어주면 아래 sysout코드랑 값이 똑같아서 굳이 잘 사용하지 않음..
		Point pt = new Point();
		Consumer<Point> ptConsumer = (Point pt1)->System.out.println(pt1.x + ", " + pt1.y);
		ptConsumer.accept(pt);
		
		System.out.println(pt);

	}

}

class Point{
	int x, y;

	@Override
	public String toString() {
		return x + ", " + y;
	}
	
}