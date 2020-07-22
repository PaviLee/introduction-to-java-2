package class4Homework_answerKey;

public class TeenSum {

	public static void main(String[] args) {
		System.out.println(teenSum(3, 4));
		System.out.println(teenSum(10, 13));
		System.out.println(teenSum(13, 2));
	}

	public static int teenSum(int a, int b) {
		if (a >= 13 && a <= 19 || b >= 13 && b <= 19) {
			return 19;
		} else {
			return a + b;
		}
	}
}