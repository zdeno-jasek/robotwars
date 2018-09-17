package sk.posam.robotwars.domain.play;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Arena {
	private final static double TOLERANCE = 0.1;
	
	private final double width;
	private final double height;
	
	private List<Robot> robots;
	private ThreadGroup threadGroup;
	
	public Arena(double width, double height) {
		this.width = width;
		this.height = height;
		this.robots = Collections.emptyList();
	}

	public void setRobots(List<Robot> robots) {
		this.robots = new ArrayList<>( robots );
	}
	
	public boolean contains(Position position ) {
		return position.getX() < width && position.getY() < height && position.getX() > 0 && position.getY() > 0;
	}

	public boolean isEmpty() {
		return robots.size() <= 1;
	}
	
	public void remove( Robot robot ) {
		this.robots.remove( robot );
	}
	
	public void play() {
		threadGroup = new ThreadGroup( "roboti" );
		List<Thread> threads = robots.stream().map( robot -> new Thread( threadGroup, robot ) ).collect( Collectors.toList() );
		threads.forEach( Thread::start );
	}

	public void oneStep() {
		robots.forEach( Robot::oneStep );		
		// robots.forEach( System.out::println );
		robots = robots.stream().filter( Robot::isLive ).collect( Collectors.toList() );
	}

	public Position createRandomPosition() {
		return new Position( Math.random() * width, Math.random() * height );
	}

	public Collection<Robot> scan(Position position, double direction) {
		Collection<Robot> result = new ArrayList<>();
		for (Robot robot : robots) {
			if ( robot.getPosition() != position && robot.isLive() ) {
				double angle = robot.getPosition().angle( position );
				if ( angle > direction - TOLERANCE && angle < direction + TOLERANCE ) {
					result.add(robot);
				}
			}
		}
		return result;
	}

	public String getWinner() {
		return robots.iterator().next().getName();
	}
	
}
