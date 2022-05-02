package day6;

public class Ex6_Array4_Squared {

	public static void main(String[] args) {
		/*배열에 1의 제곱부터 10의 제곱까지 저장하고 출력하는 코드를 저장하세요.
		 * */
		/* 방법1 : 10개짜리 배열을 만들어서 활용
		 * 장점 : 배열을 10개 사용
		 * 단점 : i의 제곱을 하려면 약간의 작업이 필요
		 * */
		int [] arr1 = new int [10];
		for(int i = 1; i < arr1.length; i++) {
			arr1[i] = (i+1) * (i+1);
			System.out.println(i+1+"의 제곱 : " + arr1[i]);
		}
		
		/* 방법2 : 11개짜리 배열을 만들어서 0번지를 사용하지 않고 1번지부터 사용하는 방법
		 * 장점 : i의 제곱을 작업이 없이 확인할 수 있다.
		 * 단점 : 쓸모없는 공간(0번지)이 1개 추가*/
		
		int [] arr = new int [11];
		 for(int i = 1; i < arr.length; i++) { // 1의 제곱부터 10
			 arr[i] = i*i; //배열에 제곱 저장
			System.out.println(i+"의 제곱 :" + arr[i]); //출력
		 }

	}

}
