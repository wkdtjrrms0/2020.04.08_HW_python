package ifexample;

public class Repeat2 {

	public static void main(String[] args) {
		int dan;
		int mul;
		
		for(dan = 3; dan <= 7; dan++) {
			for(mul = 1; mul <= 9; mul++) {
				System.out.println(dan + " X " + mul + " = " + dan*mul);
			}
		}
	}
}
