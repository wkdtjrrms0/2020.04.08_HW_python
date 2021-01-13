package loopexample;

public class breakExample {

	public static void main(String[] args) {
		int sum = 0;
		int num = 1;
		
		while(true) {
			sum += num;
			if(sum > 100)
				break;
			num++;
		}
		System.out.println(sum);
		System.out.println(num);
	}
}
