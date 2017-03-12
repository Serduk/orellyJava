package seaBattleSimple;

public class SimpleDotComGameTestDrive {
	public static void main(String[] args) {
		boolean isAlive = true;
		int numOfGuesses = 0;
		int randomNum = (int) (Math.random() * 5);
		int[] locations = {randomNum, randomNum + 1, randomNum + 2};

		SimpleGameHelper helper = new SimpleGameHelper();
		SimpleDotComGame game = new SimpleDotComGame();

		game.setLocationCells(locations);

		while (isAlive) {
			String guess = helper.getUserInput("Insert Number");
			String result = game.checkYourSelf(guess);
			numOfGuesses++;

			if (result.equals("Kill")) {
				isAlive = false;

				System.out.println("You was need " + numOfGuesses + " Try");
			}
		}
	}
}