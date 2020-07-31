package objectDesign_2048Template;

public class Main {

	public static void main(String[] args) {
		GameBoard gameBoard = new GameBoard();

		while (gameBoard.continueGame()) {
			gameBoard.update();
			gameBoard.draw();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
		}
	}
}