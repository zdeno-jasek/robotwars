package sk.posam.robotwars.domain.actions;

import sk.posam.robotwars.domain.play.Action;
import sk.posam.robotwars.domain.play.Arena;
import sk.posam.robotwars.domain.play.Robot;

final class ActionRotate implements Action {
	private final double direction;

	public ActionRotate() {
		this.direction = Math.PI * 2 * Math.random();
	}

	@Override
	public boolean doAction(Robot robot, Arena arena) {
		robot.setDirection( direction );
		return true;
	}

	@Override
	public String toString() {
		return "Rotate: direction = " + direction;
	}
	
}
