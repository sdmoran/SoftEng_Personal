package project.model;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class Block extends JPanel {
	int x;
	int y;
	int startx;
	int starty;
	int width;
	int height;
	boolean selected;
	ArrayList<Point> points; //list of points occupied by this block.
	
	public Block(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.startx = x;
		this.starty = y;
		this.width = width;
		this.height = height;
		this.selected = false;
		this.points = new ArrayList<Point>();
		points.add(new Point(x, y));
		if(height == 200) {
			points.add(new Point(x, y + 100));
		}
		if(width == 200) {
			points.add(new Point(x + 100, y));
		}
		if(width == 200 && height == 200) {
			points.add(new Point(x + 100, y + 100));
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawRect(0, 0, width, height);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);

		g.drawRect(2, 2, width - 4, height - 4);
		
		if(selected)
			g.setColor(Color.YELLOW);
		else
			g.setColor(Color.RED);
		g.fillRect(2, 2, width - 4, height - 4);
	}
	
	public void select() {
		this.selected = true;
	}
	
	public void deSelect() {
		this.selected = false;
	}
	
	public int getx() {
		return this.x;
	}
	
	public int gety() {
		return this.y;
	}
	
	public void movex(int x) {
		this.x += x;
	}
	
	public void movey(int y) {
		this.y += y;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void revertBlock() {
		this.x = startx;
		this.y = starty;
	}
}
