package class4Homework_answerKey;

public class MakeBricks {

	public static void main(String[] args) {
		System.out.println(makeBricks(3, 1, 8));
		System.out.println(makeBricks(3, 1, 9));
		System.out.println(makeBricks(3, 2, 10));
	}

	public static boolean makeBricks(int small, int big, int goal) {
		if (big < goal / 5) {
			goal -= 5 * big;
		} else {
			goal -= 5 * (goal / 5);
		}

		return small >= goal;
	}
}
