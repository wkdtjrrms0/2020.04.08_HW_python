package ifexample;

public class AloneCoding2 {

	public static void main(String[] args) {
		int building_h = 5;
		String facillity = "Null";
		
		switch(building_h) {
			case 1: facillity = "약국"; break;
			case 2: facillity = "정형외과"; break;
			case 3: facillity = "피부과"; break;
			case 4: facillity = "치과"; break;
			case 5: facillity = "헬스클럽"; break;
		}
		System.out.println(building_h + "인 경우 " + building_h + "층 " + facillity + "입니다.");
	}

}
