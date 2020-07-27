package class2Homework_answerKey;

import java.util.Scanner;

public class Class2Homework {

	public static void main(String[] args) {

		// Practice with variables
		int x = 300;
		double y;
		int a, b;
		double c = 0.1, d = 0.2;

		// Practice with user input
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter an integer: ");
		int value1 = scanner.nextInt();
		System.out.println("Please enter another integer: ");
		int value2 = scanner.nextInt();

		scanner.close();

		int sum = value1 + value2;
		System.out.println("The sum of your integers is " + sum + ".");
	}
}