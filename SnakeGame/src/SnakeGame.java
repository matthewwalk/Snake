import java.awt.Point;
import java.util.Collections;

public class SnakeGame {

	static Snake player;
	
	Food food;
	
	static final int BOARD_HEIGHT = SnakeWindow.HEIGHT / SnakeWindow.PIXEL_SIZE;
	
	static final int BOARD_WIDTH = SnakeWindow.WIDTH / SnakeWindow.PIXEL_SIZE;
	
	SnakeGame() {
		player = new Snake();
		food = new Food(player);
	}
	
	public void update() {
		//if on self
		Point head = player.getHead();
		if ((Collections.frequency(player.getLocations(), head)) > 1) {
			player = new Snake();
			food = new Food(player);
		}
		//if on food
		else if (head.equals(food.getFood())) {
			food.moveFood();
			player.addOne();
			player.move();
		}
		//if outsize
		else if (head.x < 0) {
			head.setLocation(BOARD_WIDTH-1, head.y);
		}
		else if (head.x > BOARD_WIDTH-1) {
			head.setLocation(0, head.y);
		}
		else if (head.y < 0) {
			head.setLocation(head.x, BOARD_HEIGHT-1);
		}
		else if (head.y > BOARD_HEIGHT-1) {
			head.setLocation(head.x, 0);
		}
		else {
			player.move();
		}
	}
	
}

