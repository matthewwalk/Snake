import java.awt.EventQueue;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Launch extends JFrame {
	
	Launch() {
		add(new SnakeWindow());
	    setResizable(false);
	    pack();

	    setTitle("Snake");
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    // Creates a new thread so our GUI can process itself
	    EventQueue.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	 	        JFrame frame = new Launch();
	            frame.setVisible(true);
	        }
	    });

	}

}
