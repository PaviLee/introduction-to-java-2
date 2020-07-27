package class6Homework_answerKey;

public class TestPlant {

	public static void main(String[] args) {
		Plant plant1 = new Plant();

		plant1.health = 100;
		plant1.hasFlowers = true;
		plant1.hasWater = false;

		plant1.getHealth();
		plant1.water();
		plant1.flower();

		Plant plant2 = new Plant();

		plant2.health = 50;
		plant2.hasFlowers = false;
		plant2.hasWater = false;

		plant2.getHealth();
		plant2.water();
		plant2.flower();
	}
}