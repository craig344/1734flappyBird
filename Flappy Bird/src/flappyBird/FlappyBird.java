 package flappyBird;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class FlappyBird implements ActionListener {
	public static FlappyBird flappyBird;
	public final int WIDTH = 800, HEIGHT=800;
	public Renderer renderer;
	Timer timer = new Timer(20, this);
	
	
	public FlappyBird() {
		JFrame jframe = new JFrame();
		
		renderer = new Renderer();
		
		jframe.add(renderer);
		jframe.setResizable(false);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH,HEIGHT);
		jframe.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		renderer.repaint();
	}
	
	public static void main(String[] args) {
		flappyBird = new FlappyBird();
	}
	public void repaint(Graphics g) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
	}
	
}
