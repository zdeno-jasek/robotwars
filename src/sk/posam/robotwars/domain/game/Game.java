package sk.posam.robotwars.domain.game;

import java.util.ArrayList;
import java.util.List;

import sk.posam.robotwars.domain.actions.BalancedActionGenerator;
import sk.posam.robotwars.domain.config.RobotConfig;
import sk.posam.robotwars.domain.play.ActionGenerator;
import sk.posam.robotwars.domain.play.Arena;
import sk.posam.robotwars.domain.play.Robot;

public class Game {
	
	private final Arena arena;
	private final List<Robot> robots;
	private final ActionGenerator actionGenerator;
	
	public Game() {
		arena = new Arena( 1000, 1000 );
		robots = new ArrayList<>();
		actionGenerator = new BalancedActionGenerator();
	}
	
	public void addRobot( RobotConfig robotConfig ) {
		Robot robot = new Robot(robotConfig, arena.createRandomPosition(), actionGenerator , arena);
		robots.add( robot );
	}
	
	public void play() {
		System.out.println( "START");
		arena.setRobots(robots);
		arena.play();
		try {
			while ( !arena.isEmpty() ) {
				Thread.sleep(1000);
			}
			// arena.oneStep();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println( "Winner: " + arena.getWinner() );
		System.out.println( "GAME OVER");
	}

}
