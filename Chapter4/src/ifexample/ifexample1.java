package ifexample;

public class ifexample1 {

	public static void main(String[] args) {
		int age = 25;
		int charge = 0;
		char dc = 0;
		
		if(age < 8) {
			System.out.println("미취학 아동이내요.");
			charge = 0;
			dc = 'A';
		}
		else if(age < 14) {
			System.out.println("초등학생이내요.");
			charge = 500;
			dc = 'B';
		}
		else if(age < 17) {
			System.out.println("중학생이내요.");
			charge = 1000;
			dc = 'C';
		}
		else if(age < 20) {
			System.out.println("고등학생이내요..");
			charge = 1500;
			dc = 'D';
		}
		else {
			System.out.println("성인이내요.");
			charge = 2000;
			dc = 'E';
		}
		System.out.printf("입장료는 %d 원 입니다.\n",charge);
		System.out.println("할인급수는 " + dc + "급 입니다.");
	}
}