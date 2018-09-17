package sk.posam.robotwars.domain.actions;

import sk.posam.robotwars.domain.config.RobotConfig;
import sk.posam.robotwars.domain.play.Action;
import sk.posam.robotwars.domain.play.Arena;
import sk.posam.robotwars.domain.play.Position;
import sk.posam.robotwars.domain.play.Robot;

final class ActionMove implements Action {
	
	private double speed;
	private int length;
	private int distance = 0;

	public ActionMove(RobotConfig robotConfig) {
		speed = 10;
		length = 30;
	}

	@Override
	public boolean doAction(Robot robot, Arena arena ) {
		Position newPosition = move( robot.getPosition(), robot.getDirection(), arena );
		
		if ( newPosition == null ) {
			// cant move
			return true;
		} else {
			robot.setPosition( newPosition );
		}
		distance += speed;
		return distance >= length;
	}

	private Position move(Position p, double direction, Arena arena) {
		double x = p.getX();
		double y = p.getY();
		
		Position result = new Position( x + speed * Math.cos(direction), y + speed * Math.sin(direction) );
		return ( arena.contains( result ) ? result : null );
	}
	
	@Override
	public String toString() {
		return "Moving: speed=" + speed;
	}

}
