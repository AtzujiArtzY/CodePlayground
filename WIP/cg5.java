import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;

class cg5 extends JPanel implements Runnable {
	public static void main(String[] args) {
		cg5 m = new cg5();
		JFrame f = new JFrame();
		f.add(m);
		f.setTitle("Graphics");
		f.setSize(600,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		(new Thread(m)).start();
	}
	public double circleMove = 0;
	public double squareRotate = 0;

	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		//Frame 1
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, 600, 600);
		g2.setColor(Color.BLACK);
		g2.translate(circleMove, 20);
		g2.drawOval(0, 0, 100, 100);
		g2.translate(-circleMove, 10);
		g2.rotate(squareRotate, 300, 300);
		g2.drawRect(200, 200, 200, 200);
		
	}
	public void run() {
		double lastTime = System.currentTimeMillis();
		double currentTime, elapsedTime;
		double startTime = System.currentTimeMillis();
		while (true) {
			currentTime = System.currentTimeMillis();
			elapsedTime = currentTime - lastTime;
		//TODO: update logics
		//Display
			circleMove += 50.0 * elapsedTime / 1000;
			squareRotate += 100.0 * elapsedTime / 1000;
			repaint();
			lastTime = currentTime;
		//take a little nap: 60fps
			try {
				Thread.sleep(1000/60);
			}
			catch (InterruptedException e) {
				System.err.println(e);
			}
		}
	}
}