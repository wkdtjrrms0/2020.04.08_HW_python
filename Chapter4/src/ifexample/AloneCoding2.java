package ifexample;

public class AloneCoding2 {

	public static void main(String[] args) {
		int building_h = 5;
		String facillity = "Null";
		
		switch(building_h) {
			case 1: facillity = "�౹"; break;
			case 2: facillity = "�����ܰ�"; break;
			case 3: facillity = "�Ǻΰ�"; break;
			case 4: facillity = "ġ��"; break;
			case 5: facillity = "�ｺŬ��"; break;
		}
		System.out.println(building_h + "�� ��� " + building_h + "�� " + facillity + "�Դϴ�.");
	}

}
