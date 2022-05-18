package day17;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex4_Date {

	public static void main(String[] args) {
		//new Date()는 실행 시간을 기준으로 날짜 객체를 생성
		Date date = new Date();
		System.out.println(date);
		//new Date(num)1970년 1월 1일 00:00:00을 기준으로 num밀리 세컨드가 흐른 날짜 객체를 생성
		Date date2 = new Date(1000);
		System.out.println(date2);
		
		//yyyy-mm-dd hh:mm:ss
		//Date클래스의 객체를 원하는 포맷의 문자열로 바꾸는 예제 - 알아둬야 할 예제!!!!!!!!!!!!
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss E요일");
		String strDate = format.format(date);
		System.out.println(strDate);
		
		//문자열은 Date클래스의 객체로 바꾸는 예제 - 알아둬야 할 예제!!!!!!!!!!!!!
		Date date3;
		try {
			format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			date3 = format.parse("2022-05-13 13:22:13");
			System.out.println(date3);
		}catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
