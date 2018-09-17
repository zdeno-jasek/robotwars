package sk.posam.robotwars.domain.actions;

import sk.posam.robotwars.domain.config.RobotConfig;
import sk.posam.robotwars.domain.play.Action;
import sk.posam.robotwars.domain.play.ActionGenerator;

public final class BalancedActionGenerator implements ActionGenerator {
	
	private int i = 0;
	
	@Override
	public Action getNextAction(RobotConfig robotConfig) {
		Action result = null;
		switch ( i++ % 3) {
		case 0:
			result = new ActionMove(robotConfig);
			break;
		case 1:
			result = new ActionRotate();
			break;
		case 2:
			result = new ActionFire();
			break;
		}
		
		return result;
	}
	
}
