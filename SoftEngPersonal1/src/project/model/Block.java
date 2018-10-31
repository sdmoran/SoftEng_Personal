package project.model;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class Block extends JPanel {
	int x;
	int y;
	int width;
	int height;
	boolean selected;
	ArrayList<Point> points; //list of points occupied by this block.
	
	public Block(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
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
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void move(int val) {
		switch(val) { 
	       case KeyEvent.VK_UP:
	           if(this.y - 100 >= 2) {
	        	   this.y -= 100;
	           }
	           break;
	       case KeyEvent.VK_DOWN:
	    	   if(this.y + height <= 500) {
	    		   this.y += 100;
	    	   }
	           break;
	       case KeyEvent.VK_LEFT:
	    	   if(this.x - 100 >= 0) {
	        	   this.x -= 100;
	        	   for(int i = 0; i < points.size(); i++) {
	        		   Point p = points.get(i);
	        		   points.set(i, new Point((int) p.getX() - 100, (int) p.getY()));
	        	   }
	    	   }
	           break;
	       case KeyEvent.VK_RIGHT :
	    	   if(this.x + width <= 400) {
	        	   this.x += 100;
	        	   for(int i = 0; i < points.size(); i++) {
	        		   Point p = points.get(i);
	        		   points.set(i, new Point((int) p.getX() + 100, (int) p.getY()));
	        	   }
	    	   }
	           break;
	     }
	}
	

	
}
