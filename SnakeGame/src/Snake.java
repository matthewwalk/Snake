import java.awt.Point;
import java.util.ArrayList;

public class Snake {

	public enum Direction {
		RIGHT,
		LEFT,
		UP,
		DOWN;
	}
	
	private Direction direction;
	
	private ArrayList<Point> locations;
	
	private Point head, tail;
	
	private int size;
	
	//default constructor
	Snake(int x, int y) {
		this.setDirection(Direction.DOWN);
		this.locations = new ArrayList<Point>();
		this.locations.add(new Point(x,y));
		this.head = this.locations.get(0);
		this.tail = this.locations.get(this.locations.size()-1);
		this.addOne();
		this.move();
		this.addOne();
		this.move();
	}
	
	Snake() {
		this((SnakeWindow.WIDTH / SnakeWindow.PIXEL_SIZE)/2, 
			 (SnakeWindow.HEIGHT / SnakeWindow.PIXEL_SIZE)/4);
	}
	
	public void move() {
		for (int i = this.getSize(); i > 0; i--) {
			if (!this.getLocations().get(i).equals(this.getLocations().get(i-1))) {
				this.getLocations().get(i).setLocation(this.getLocations().get(i-1));
			}
		}
		switch(this.getDirection()) {
			case RIGHT:
				this.getHead().setLocation(this.getHead().getX()+1, this.getHead().getY());
				break;
				
			case DOWN:
				this.getHead().setLocation(this.getHead().getX(), this.getHead().getY()+1);
				break;
				
			case LEFT:
				this.getHead().setLocation(this.getHead().getX()-1, this.getHead().getY());
				break;
				
			case UP:
				this.getHead().setLocation(this.getHead().getX(), this.getHead().getY()-1);
				break;
		}
	}
	
	public void setDirection(Direction d) {
		this.direction = d;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	public void addOne() {
		Point newTail = new Point(this.locations.get(this.locations.size()-1));
		this.locations.add(newTail);
		this.size++;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public Point getHead() {
		return this.head;
	}
	
	public Point getTail() {
		return this.tail;
	}
	
	//shallow return of locations field
	public ArrayList<Point> getLocations() {
		return this.locations;
	}
}
