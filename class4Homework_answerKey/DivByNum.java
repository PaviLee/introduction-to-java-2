package class4Homework_answerKey;

import java.util.Scanner;

public class DivByNum {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter a divisor: ");
		int divisor = scanner.nextInt();

		scanner.close();
		
		System.out.println("List of all numbers divisible by " + divisor + " between 1 and 100: ");
		for (int i = 1; i <= 100; i++) {
			if (i % divisor == 0) {
				System.out.println(i);
			}
		}
	}

}
