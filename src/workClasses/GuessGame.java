package workClasses;

public class GuessGame {

	public void startGame() {
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();

		int guess1, guess2, guess3;

		boolean p1IsRight = false;
		boolean p2IsRight = false;
		boolean p3IsRight = false;

		while (true) {

			int targetNumber = (int) (Math.random() * 10);
			System.out.println("I set number...");

			guess1 = p1.guess();
			guess2 = p2.guess();
			guess3 = p3.guess();

			if (targetNumber == guess1) {
				p1IsRight = true;
			}
			if (targetNumber == guess2) {
				p2IsRight = true;
			}
			if (targetNumber == guess3) {
				p3IsRight = true;
			}

			if (p1IsRight || p2IsRight || p3IsRight) {
				System.out.println("We Have a winner!");
				System.out.println("First Player is win? " + p1IsRight);
				System.out.println("Second Player is win? " + p2IsRight);
				System.out.println("Third Player is win? " + p3IsRight);
				System.out.println("Game Over");
				break;
			} else {
				System.out.println("More one Game");
			}
		}

	}
}