package exercise;

public class ex3 {

	public static void main(String[] args) {
		int dan, mul;
		for(dan = 1; dan <= 9; dan++) {
			for(mul = 1; mul <= 9; mul++) {
				if(dan < mul) {
					break;
				}
				System.out.println(dan + " X " + mul + " = " + dan * mul);
			}
			System.out.println();
		}
	}
}
