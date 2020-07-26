package class4Homework_answerKey;

import java.util.Scanner;

public class Quadrants {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter the x value of your point: ");
		int x = scanner.nextInt();
		System.out.println("Please enter the y value of your point: ");
		int y = scanner.nextInt();

		scanner.close();
		
		String output = "(" + x + ", " + y + ") is ";

		if (x > 0 && y > 0) {
			output += "located in Quadrant I.";
		} else if (x < 0 && y > 0) {
			output += "located in Quadrant II.";
		} else if (x < 0 && y < 0) {
			output += "located in Quadrant III.";
		} else if (x > 0 && y < 0) {
			output += "located in Quadrant IV.";
		} else {
			output += "the origin.";
		}

		System.out.println(output);
	}

}
