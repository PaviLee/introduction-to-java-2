package class5Homework_answerKey;

public class PracticeWIthMethods {

	public static void main(String[] args) {
		System.out.println(bothGreaterThan100(10, 101));
		System.out.println(bothGreaterThan100(101, 10));
		System.out.println(bothGreaterThan100(101, 101));

		System.out.println();

		System.out.println(sumBetween(2, 5));
		System.out.println(sumBetween(100, 105));
		System.out.println(sumBetween(1, 15));

		System.out.println();

		System.out.println(petNames("Charlie", "Wilson"));
		System.out.println(petNames("Joe", "Chris"));
		System.out.println(petNames("Sophie", "Frank"));

		System.out.println();

		goodGardener(1);
		goodGardener(5);
		goodGardener(20);
		goodGardener(40);
	}

	// a
	public static boolean bothGreaterThan100(int x, int y) {
		return x > 100 && y > 100;
	}

	// b
	public static int sumBetween(int x, int y) {
		int sum = 0;

		for (int i = x; i <= y; i++) {
			sum += i;
		}

		return sum;
	}

	// c
	public static String petNames(String dogName, String catName) {
		return "Your dog's name is " + dogName + ", and your cat's name is "
				+ catName + ".";
	}

	// d
	public static void goodGardener(int numPlants) {
		if (numPlants < 5) {
			System.out.println("You are a bad gardener.");
		} else if (numPlants < 20) {
			System.out.println("You are okay with plants.");
		} else if (numPlants < 40) {
			System.out.println("You are great with plants.");
		} else {
			System.out.println("You are the god of plants.");
		}
	}
}