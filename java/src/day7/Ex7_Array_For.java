package day7;

public class Ex7_Array_For {

	public static void main(String[] args) {
		int score[] = {100, 90, 30}; // 3개의 점수
		int sum = 0;
		double avg;
		
		for(int tmp : score) { // score를 tmp에 저장
			sum += tmp;
		}
		avg = sum / (double)score.length;
		System.out.println("총점 : " + sum + " , 평균 : " + avg);

	}

}
