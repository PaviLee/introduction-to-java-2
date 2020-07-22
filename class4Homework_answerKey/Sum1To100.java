package class4Homework_answerKey;

public class Sum1To100 {

	public static void main(String[] args) {
		int sum = 0;

		for (int i = 1; i <= 100; i++) {
			sum += i;
		}

		System.out.println("The sum of all the numbers between 1 and 100 inclusive is " + sum + ".");
	}

}