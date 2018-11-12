package project.view;
import javax.swing.*;

import java.awt.*;
import javax.swing.border.LineBorder;

import project.model.Block;
import project.model.Model;

public class PuzzleView extends JPanel {
	Model model;
	
	public PuzzleView(Model model) {
		this.model = model;
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setBackground(Color.WHITE);
		this.setBounds(15, 16, 405, 555);
		this.setLayout(null);
		this.drawBlocks();
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	public void drawBlocks() {
		if(!model.isWon()) {
			for(Block b : model.getBlockList()) {
				b.setBounds(b.getx(), b.gety(), b.getWidth(), b.getHeight());
				this.add(b);
			}
			repaint();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(model.isWon()) {
			g.clearRect(0, 0, 405, 505);
			g.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
			Color c = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
			g.setColor(c);
			g.drawString("You are win!1!!", 50, 545);
		}
		else {
			drawBlocks();
			g.setColor(Color.BLACK);
			g.fillRect(0, 502, 103, 60);
			g.fillRect(300, 502, 200, 60);
			g.drawString("Total moves: " + model.getMoveNum(), 150, 550);
		}
		repaint();
	}
	
	public void redraw() {
		drawBlocks();
		repaint();
	}
}
