package class3Homework_answerKey;

public class IcyHot {

	public static void main(String[] args) {
		System.out.println(icyHot(120, -1));
		System.out.println(icyHot(-1, 120));
		System.out.println(icyHot(2, 120));
	}

	public static boolean icyHot(int temp1, int temp2) {
		// Solution 1
		return (temp1 < 0 || temp2 < 0) && (temp1 > 100 || temp2 > 100);
		// Solution 2
		// return temp1 < 0 && temp2 > 100 || temp1 > 100 && temp2 < 0;
	}
}
