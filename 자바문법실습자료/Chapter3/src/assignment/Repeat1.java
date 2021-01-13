package assignment;

public class Repeat1 {

	public static void main(String[] args) {
		int mathScore = 90;
		int engScore = 70;
		int korScore = 90;
		int totalScore = mathScore + engScore + korScore;
		double avgScore = totalScore / 3.0;
		
		System.out.printf("점수의 합계는 %d, 평균은 %f입니다.", totalScore, avgScore);
	}

}
