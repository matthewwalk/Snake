import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeWindow extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static final int HEIGHT = 1000;
	
	static final int WIDTH =  1000;
	
	static final int PIXEL_SIZE = 50;
	
	public SnakeGame game;
	
	private Timer time;
	
	private final int speed = 85; //milli seconds

	SnakeWindow() {
		game = new SnakeGame();
		this.addKeyListener(new Keys());
		setBackground(Color.WHITE);
	    setFocusable(true);

	    setPreferredSize(new Dimension(SnakeWindow.WIDTH, SnakeWindow.HEIGHT));
	    time = new Timer(speed,this);
	    time.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    draw(g);
	}
	
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillOval(game.food.getFood().x*PIXEL_SIZE, game.food.getFood().y*PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE); // food

        for (Point p : SnakeGame.player.getLocations()) {
        	if (p.equals(SnakeGame.player.getHead())) {
        		g.setColor(Color.RED);
        		g.fillOval(p.x*PIXEL_SIZE, p.y*PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);

        	}
        	else {
        		g.setColor(Color.GREEN);
        		g.fillRoundRect(p.x*PIXEL_SIZE, p.y*PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE/2, PIXEL_SIZE/2);
        	}
        }

        // Sync our graphics together
        Toolkit.getDefaultToolkit().sync();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		game.update();
		repaint();
	}
	
	private class Keys extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			switch (key) {
			case KeyEvent.VK_LEFT:
				if (SnakeGame.player.getDirection() != Snake.Direction.RIGHT) {
					SnakeGame.player.setDirection(Snake.Direction.LEFT);
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (SnakeGame.player.getDirection() != Snake.Direction.LEFT) {
					SnakeGame.player.setDirection(Snake.Direction.RIGHT);
				}
				break;
			case KeyEvent.VK_UP:
				if (SnakeGame.player.getDirection() != Snake.Direction.DOWN) {
					SnakeGame.player.setDirection(Snake.Direction.UP);
				}
				break;
			case KeyEvent.VK_DOWN:
				if (SnakeGame.player.getDirection() != Snake.Direction.UP) {
					SnakeGame.player.setDirection(Snake.Direction.DOWN);
				}
				break;
			case KeyEvent.VK_ENTER:
				//SnakeGame.gameState = !SnakeGame.gameState;
				break;
			}
		}
	}//end of keys class
	
}
