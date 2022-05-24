package day21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex3_Lamda3 {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(12);
		list.add(60);
		list.add(25);
		list.add(10);
		list.add(100);
		list.add(30);
		list.add(26);
		
		list.sort(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return a-b;
			}
		});
		
		//람다식을 이용해서 정렬 (return, 중괄호 생략)
		list.sort((Integer a, Integer b)-> a-b);
		
		System.out.println(list);
	}
}
