package sk.posam.robotwars.domain.play;

import sk.posam.robotwars.domain.config.RobotConfig;

public interface ActionGenerator {

	Action getNextAction( RobotConfig robotConfig );
	
}
