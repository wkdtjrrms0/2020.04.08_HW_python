package ifexample;

public class ifexample1 {

	public static void main(String[] args) {
		int age = 25;
		int charge = 0;
		char dc = 0;
		
		if(age < 8) {
			System.out.println("������ �Ƶ��̳���.");
			charge = 0;
			dc = 'A';
		}
		else if(age < 14) {
			System.out.println("�ʵ��л��̳���.");
			charge = 500;
			dc = 'B';
		}
		else if(age < 17) {
			System.out.println("���л��̳���.");
			charge = 1000;
			dc = 'C';
		}
		else if(age < 20) {
			System.out.println("����л��̳���..");
			charge = 1500;
			dc = 'D';
		}
		else {
			System.out.println("�����̳���.");
			charge = 2000;
			dc = 'E';
		}
		System.out.printf("������ %d �� �Դϴ�.\n",charge);
		System.out.println("���α޼��� " + dc + "�� �Դϴ�.");
	}
}