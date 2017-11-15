
import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;

public class Food {
	
	static int height, width;
	
	private Point food;
	
	private Snake snake;
	
	Food(Snake s) {
		snake = s;
		food = new Point(10,10);
		moveFood();
	}
	
	public void moveFood() {
		while (snake.getLocations().contains(food)) {
			int randomX = ThreadLocalRandom.current().nextInt(1, SnakeGame.BOARD_WIDTH-1);
			int randomY = ThreadLocalRandom.current().nextInt(1, SnakeGame.BOARD_HEIGHT-1);
			food.setLocation(randomX, randomY);
		}
	}
	
	public Point getFood() {
		return this.food;
	}
	
	
}
