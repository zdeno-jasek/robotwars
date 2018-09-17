package sk.posam.robotwars.domain.actions;

import java.util.Collection;

import sk.posam.robotwars.domain.play.Action;
import sk.posam.robotwars.domain.play.Arena;
import sk.posam.robotwars.domain.play.Robot;

final class ActionFire implements Action {
	private int killed = -1;

	@Override
	public boolean doAction(Robot robot, Arena arena) {
		Collection<Robot> robots = arena.scan( robot.getPosition(), robot.getDirection() );
		robots.forEach( Robot::kill );
		killed = robots.size();
		if ( killed > 0 ) {
			System.out.println( robot.getName() + " killed " + robots.toString() );
		}

		return true;
	}
	
	@Override
	public String toString() {
		return ( killed == -1 ? "Fire" : "Fire: " + killed + " killed" );
	}
}
