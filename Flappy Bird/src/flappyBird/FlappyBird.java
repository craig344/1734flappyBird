package flappyBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class FlappyBird implements ActionListener {
	public static FlappyBird flappyBird;
	public final int WIDTH = 1366, HEIGHT = 768;
	public Renderer renderer;
	public Rectangle bird;
	public ArrayList<Rectangle> columns;
	public Random rand;
	public int ticks, yMotion;
	public boolean gameOver, started = true;

	public FlappyBird() {
		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);

		renderer = new Renderer();
		rand = new Random();

		jframe.add(renderer);
		jframe.setResizable(false);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.setTitle("Flappy Bird");
		jframe.setVisible(true);

		bird = new Rectangle(WIDTH / 2 - 15, HEIGHT / 2 - 15, 30, 30);
		columns = new ArrayList<Rectangle>();

		addColumn(true);
		addColumn(true);
		addColumn(true);
		addColumn(true);

		timer.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int speed = 7;
		ticks++;

		if (started) {
			if (ticks % 2 == 0 && yMotion < 15) {
				yMotion += 2;
			}

			bird.y += yMotion;

			for (int i = 0; i < columns.size(); i++) {
				Rectangle column = columns.get(i);
				column.x -= speed;
				if (column.x + column.width < 0) {
					columns.remove(column);
					if (column.y == 0) {
						addColumn(false);
					}
				}
				if (column.intersects(bird)) {
					gameOver = true;
				}
			}
			if (bird.y > HEIGHT - 120 || bird.y < 0) {
				gameOver = true;
			}
		}

		renderer.repaint();

	}

	public void addColumn(boolean start) {
		int space = 300;
		int width = 100;
		int height = 50 + rand.nextInt(300);

		if (start) {
			columns.add(new Rectangle(WIDTH + width + columns.size() * 300, HEIGHT - height - 120, width, height));
			columns.add(new Rectangle(WIDTH + width + (columns.size() - 1) * 300, 0, width, HEIGHT - height - space));
		} else {
			columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, HEIGHT - height - 120, width, height));
			columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, HEIGHT - height - space));
		}

	}

	public void paintColumn(Graphics g, Rectangle column) {
		g.setColor(Color.green.darker());
		g.fillRect(column.x, column.y, column.width, column.height);
	}

	public void repaint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.orange.darker());
		g.fillRect(0, HEIGHT - 120, WIDTH, 120);

		g.setColor(Color.green);
		g.fillRect(0, HEIGHT - 120, WIDTH, 20);

		g.setColor(Color.yellow);
		g.fillRect(bird.x, bird.y, bird.width, bird.height);

		for (Rectangle column : columns) {
			paintColumn(g, column);
		}
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial", 1, 100));
		
		if(gameOver) {
			g.drawString("Game Over!", 400, HEIGHT / 2 - 50);
		}
	}

	public static void main(String[] args) {
		flappyBird = new FlappyBird();
	}

}
