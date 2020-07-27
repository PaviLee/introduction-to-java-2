package class6Homework_answerKey;

public class Plant {

	public int health;
	public boolean hasFlowers;
	public boolean hasWater;

	public int getHealth() {
		return health;
	}

	public void water() {
		hasWater = true;
	}

	public void flower() {
		if (hasFlowers) {
			System.out.println("I have flowers.");
		} else {
			System.out.println("I do not have flowers.");
		}
	}
}