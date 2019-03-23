package pojo;

import java.awt.Graphics;

import javax.swing.JPanel;

import flappyBird.App;

public class Renderer extends JPanel {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		App.flappyBird.repaint(g);
	}
}
