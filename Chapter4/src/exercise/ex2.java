package exercise;

public class ex2 {

	public static void main(String[] args) {
		int dan, mul;
		for(dan = 1; dan <= 9; dan++) {
			if((dan % 2) != 0) {
				continue;
			}
			for(mul = 1; mul <= 9; mul++) {
				System.out.println(dan + " X " + mul + " = " + dan * mul);
			}
			System.out.println();
		}
	}

}
