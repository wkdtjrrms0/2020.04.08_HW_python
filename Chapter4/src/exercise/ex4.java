package exercise;

public class ex4 {

	public static void main(String[] args) {
		int Total_line = 4;
		for(int i = 1; i <= Total_line; i++) {
			for(int j = 1; j <= Total_line - i; j++) {
				System.out.print(" ");
			}
			for(int k = 1; k <= 2 * i - 1; k++) {
				System.out.print("*");
			}
			if(Total_line == i) {
				break;
			}
			System.out.println();
		}
	}
}