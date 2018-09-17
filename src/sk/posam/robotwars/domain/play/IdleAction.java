package sk.posam.robotwars.domain.play;

enum IdleAction implements Action {
	INSTANCE;

	@Override
	public boolean doAction(Robot robot, Arena arena) {
		return true;
	}
	
	@Override
	public String toString() {
		return "IDLE";
	}

}
