package exercise;

public class ex5 {

	public static void main(String[] args) {
		int Total_line = 21;
		int Center_line = Total_line / 2 + 1;
		if((Total_line % 2) == 0) {
			System.out.println("홀수의 전체줄을 입력하시오.");
		}
		else {
			for(int i = 1; i <= Center_line; i++) {
				for(int j = 1; j <= Center_line - i; j++) {
					System.out.print(" ");
				}
				for(int k = 1; k <= 2 * i - 1; k++) {
					System.out.print("*");
				}
				System.out.println();
			}
			
			for(int l = Center_line + 1; l <= Total_line; l++) {
				for(int m = 1; m <= l - Center_line; m++) {
					System.out.print(" ");
				}
				for(int n = 1; n <= Total_line - 2 * (l - Center_line); n++) {
					System.out.print("*");
				}
				if(l == Total_line) {
					break;
				}
				System.out.println();
			}
		}
	}

}
