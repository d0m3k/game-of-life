import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Point {
	private ArrayList<Point> neighbors;
	private int currentState;
	private int nextState;
	private int numStates = 6;
	
	public Point() {
		currentState = 0;
		nextState = 0;
		neighbors = new ArrayList<Point>();
	}

	public void clicked() {
		currentState=(++currentState)%numStates;	
	}
	
	public int getState() {
		return currentState;
	}

	public void setState(int s) {
		currentState = s;
	}

	public void calculateNewState() {
		//TODO: insert logic which updates according to currentState and
		//number of active neighbors
		int activeNeighbors = activeNeighbors();
		if(currentState > 0)
			nextState = currentState - 1;
		else if(currentState == 0 && intIn(activeNeighbors, 1))
			nextState = 6;
	}

	private boolean intIn(int toCompare, int... values) {
		return Arrays.stream(values).anyMatch(x -> x==toCompare);
	}

	public void changeState() {
		currentState = nextState;
	}
	
	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}
	
	//TODO: write method counting all active neighbors of THIS point
	public int activeNeighbors() {
		return Math.toIntExact(neighbors.stream().filter(x -> x.getState() > 0).count());
	}

	public void drop() {
		if (new Random().nextInt(30) % 12 == 1)
			setState(6);
	}
}
