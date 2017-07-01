package edu.mainRun;

import edu.workClasses.EnumExample;
import edu.workClasses.GuessGame;

public class GameLauncher {
	public static void main(String[] args) {
			GuessGame game = new GuessGame();

			game.startGame();
			if ("winne".equals(EnumExample.Bob)) {
				System.out.println("Bob Win");
			}
		}	
}