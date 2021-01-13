package exercise;

public class ex1 {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 2;
		int result = 0;
		int result1 = 0;
		char operator = '+';
		
		if(operator == '+') {
			result = num1 + num2;
		}
		else if(operator == '-') {
			result = num1 - num2;
		}
		else if(operator == '*') {
			result = num1 * num2;
		}
		else if(operator == '/') {
			result = num1 / num2;
		}
		System.out.println(result);
		
		switch(operator) {
			case '+': result1 = num1 + num2;
				break;
			case '-': result1 = num1 - num2;
				break;
			case '*': result1 = num1 * num2;
				break;
			case '/': result1 = num1 / num2;
				break;
		}
		System.out.println(result1);
	}

}
