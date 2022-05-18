package day17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Ex7_List_Test1 {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>(); //제너릭타입을 지정하지 않으면 오브젝트 타입이 자동으로 들어감
		Vector<Integer> list2 = new Vector<Integer>();
		LinkedList<Integer> list3 = new LinkedList<Integer>();
		List<Integer> list4 = new ArrayList<Integer>();
		
		list1.add(10); //정수 10이 자동 박싱으로 Integer의 객체로 변환 후 리스트에 추가
		list1.add(20);
		list1.add(0,30);//0번지에 30을 추가 -> 기존에 0번지에 있던 10이 밀림
		list1.add(20);		
		list4.addAll(list1);
		
		list1.set(0, 3);
		
		System.out.println("list1 : " + list1);
		System.out.println("list1의 0번지 값 : " + list1.get(0)); //0번지에 있는 값을 가져오게 하는 메소드		
		System.out.println("list1에 30이 있는가? : " + list1.contains(30));// 있는지 없는지만 알려줌
		System.out.println("list1에 10이 있는가? : " + list1.indexOf(10) + "번지"); //어디에 있는지 위치까지 알려줌
		System.out.println("list1에 있는 원소 개수 : " + list1.size() + "개");
		System.out.println("list4 : " + list4);
		Integer num = list4.remove(0);
		System.out.println("list4에서 제거한 0번지의 값 : " + num);
		System.out.println("list4 : " + list4);
		System.out.println("list4에서 제거한 20을 제거했는가? : " + list4.remove((Integer)20));
		System.out.println("list4 : " + list4);
		list4.clear(); //list 다 비움
		System.out.println("list4 : " + list4);
	}

}
