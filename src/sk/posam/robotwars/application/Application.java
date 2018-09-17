package sk.posam.robotwars.application;

import sk.posam.robotwars.domain.config.RobotConfig;
import sk.posam.robotwars.domain.game.Game;

public class Application {

	public static void main(String[] args) {
		Game game = new Game();
		game.addRobot( new RobotConfig( "asimov") );
		game.addRobot( new RobotConfig( "isaac") );
		game.addRobot( new RobotConfig( "frank") );
		game.addRobot( new RobotConfig( "herbert") );
		game.addRobot( new RobotConfig( "dick") );
		game.play();
	}

}
