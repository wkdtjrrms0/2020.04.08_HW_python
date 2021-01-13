package assignment;

public class OperationEx5 {

	public static void main(String[] args) {
		int num3 = 5;  //00000101
		System.out.println(num3 << 1);  //00001010
		System.out.println(num3);
		System.out.println(num3 << 2);  //00010100
		System.out.println(num3 << 3);  //00101000
		
		System.out.println(num3 >> 1);  //00000010
		
		int num = 0B11111111111111111111111111110011;
		int num1 = 0B00001101;
		System.out.println(num);
	}
}
