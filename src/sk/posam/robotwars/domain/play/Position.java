package sk.posam.robotwars.domain.play;

public final class Position {

	private final double x;
	private final double y;
	
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

	@Override
	public String toString() {
		return "" + Math.round( x ) + "," + Math.round( y );
	}

	public double angle(Position position) {
		double deltaX = position.getX() - x;
		double deltaY = position.getY() - y;
		return Math.atan( deltaX / deltaY );
	}
	
}
