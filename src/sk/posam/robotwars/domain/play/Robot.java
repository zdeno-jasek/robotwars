package sk.posam.robotwars.domain.play;

import sk.posam.robotwars.domain.config.RobotConfig;

public class Robot implements Runnable {
	
	private final RobotConfig robotConfig;
	private final ActionGenerator actionGenerator;
	private final Arena arena;
	
	private Position position;
	private Action currentAction = null;
	private boolean live;
	private double direction;
	private boolean changeAction;
	
	public Robot( RobotConfig robotConfig, Position position, ActionGenerator actionGenerator, Arena arena ) {
		this.robotConfig = robotConfig;
		this.position = position;
		this.actionGenerator = actionGenerator;
		this.arena = arena;
		
		this.currentAction = IdleAction.INSTANCE;
		live = true;
		direction = 0.3;
		this.changeAction = true;
	}
	
	@Override
	public void run() {
		while ( live && ! arena.isEmpty() ) {
			if ( changeAction ) {
				currentAction = actionGenerator.getNextAction(robotConfig);				
			}
			changeAction = currentAction.doAction( this, arena );
			System.out.println( this );			
		}
	}


	public void oneStep() {
		if ( live ) {
			if ( changeAction ) {
				currentAction = actionGenerator.getNextAction(robotConfig);				
			}
			changeAction = currentAction.doAction( this, arena );
			System.out.println( this );
		}
	}
	
	public String getName() {
		return robotConfig.getName();
	}
	
	public Position getPosition() {
		return position;
	}
	
	public boolean isLive() {
		return live;
	}
	
	public void kill() {
		arena.remove( this );
		live = false;
	}

	public void setPosition(Position newPosition) {
		this.position = newPosition;
	}
	
	@Override
	public String toString() {
		return "Robot " + robotConfig.getName() + " [" + position + "], ACTION: "+currentAction +" STATUS: " + (live?"live":"dead");
	}

	public double getDirection() {
		return direction;
	}

	public void setDirection(double d) {
		this.direction = d;
	}

}
