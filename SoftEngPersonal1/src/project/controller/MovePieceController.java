package project.controller;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import project.model.*;
import project.view.*;

public class MovePieceController {
	PuzzleApp app;
	Model model;
	
	public MovePieceController(PuzzleApp app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	public void moveBlock(int index, KeyEvent k, Model model) {
		this.model = model;
		int val = k.getKeyCode();
		Block b = model.getBlock(index);
		ArrayList<Point> points;	
		
		//WORKING as far as I can tell.
		if(val == KeyEvent.VK_UP) {
			if(b.gety() - 100 < 2) {
	        	   return;
	        }
			//if going up, check top left and right corner.
			points = new ArrayList<Point>();
			points.add(new Point(b.getx(), b.gety() - 100));
			
			//If a long or square block, check all segments.
			if(b.getWidth() > 100) {
				points.add(new Point(b.getx() + 100, b.gety() - 100));
			}
			
			for(Point d : points) {
				if(!(model.findIndex(d) < 0 || model.findIndex(d) == model.findIndex(b))) { //if space is not empty, can't move: return
					System.out.println("Collided with block " + model.findIndex(d));
					return;
				}
			}
			//if we haven't returned, move is valid.
			b.movey(-100);
			model.incMoves();
		}
		
		
		if(val == KeyEvent.VK_RIGHT) {
			if(b.getx() + b.getWidth() > 400) {
	        	   return;
	        }
			
			//if going right, check top right corner and bottom right corner
			points = new ArrayList<Point>();
			points.add(new Point(b.getx() + b.getWidth(), b.gety()));
			
			if(b.getWidth() > 100) {
				points.add(new Point(b.getx() + b.getWidth(), b.gety()));
			}
			
			if(b.getHeight() > 100) {
				points.add(new Point(b.getx() + b.getWidth(), b.gety() + 100));
			}
			
			for(Point d : points) {
				if(!(model.findIndex(d) < 0 || model.findIndex(d) == model.findIndex(b))) { //if space is not empty, can't move: return
					System.out.println("Collided with block " + model.findIndex(d));
					return;
				}
			}
			b.movex(100);
			model.incMoves();
		}
		
		if(val == KeyEvent.VK_LEFT) {
			if(b.getx() - 100 < 2) {
	        	   return;
	        }
			
			//if going left, check top left corner
			points = new ArrayList<Point>();
			points.add(new Point(b.getx() - 100, b.gety()));
			
			if(b.getHeight() > 100) {
				points.add(new Point(b.getx() - 100, b.gety() + 100));
			}
			for(Point d : points) {
				if(!(model.findIndex(d) < 0 || model.findIndex(d) == model.findIndex(b))) { //if space is not empty, can't move: return
					System.out.println("Collided with block " + model.findIndex(d));
					return;
				}
			}
			b.movex(-100);
			model.incMoves();
		}
		
		//WORKING as far as I can tell.
		if(val == KeyEvent.VK_DOWN) {
			if(b.gety() + b.getHeight() > 500) {
				if(b.getWidth() == 200 && b.getHeight() == 200 && b.getx() == 102) {
					System.out.println("You win!!!!!");
					model.setWon(true);
					return;
				}
				else {
					return;
				}
	        }
			
			//if going down, check bottom left corner & bottom right corner.
			points = new ArrayList<Point>();
			points.add(new Point(b.getx(), b.gety() + b.getHeight()));
			
			//If a long or square block, check all segments.
			if(b.getWidth() > 100) {
				points.add(new Point(b.getx() + 100, b.gety() + b.getHeight()));
			}

			for(Point d : points) {
				if(!(model.findIndex(d) < 0)) { //if space is not empty, can't move: return
					return;
				}
			}
			//if we haven't returned, move is valid.
			b.movey(100);
			model.incMoves();
		}
	}
}
