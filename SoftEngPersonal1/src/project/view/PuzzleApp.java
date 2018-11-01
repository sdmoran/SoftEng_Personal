package project.view;
import javax.swing.*;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Optional;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import java.awt.event.KeyEvent;

import project.controller.*;
import project.model.*;

public class PuzzleApp extends JFrame {
		JPanel window;
		PuzzleView puzzle;
		Block[] blocks;
		Model model;
		MovePieceController moveController;
		
	public PuzzleApp() {
		this.model = new Model();
		
		window = new JPanel();
		getContentPane().add(window, BorderLayout.CENTER);
		window.setLayout(null);
		
		puzzle = new PuzzleView(model);
		puzzle.setBorder(new LineBorder(new Color(0, 0, 0)));
		puzzle.setBackground(Color.WHITE);
		puzzle.setBounds(15, 16, 405, 505);
		puzzle.setLayout(null);
		puzzle.drawBlocks();
		
		window.add(puzzle);
		window.setLocation(200, 100);
		window.setVisible(true);
		puzzle.setFocusable(true);
		puzzle.requestFocusInWindow();
		setTitle("Block Puzzle");
		setBounds(100, 100, 455, 700);
        
        puzzle.addKeyListener(new KeyListener() {
    			@Override
    			public void keyPressed(KeyEvent k) {
    				Block b = model.getSelected();
    				if(b != null) {
    					MovePieceController m = new MovePieceController(PuzzleApp.this, model);
    					m.moveBlock(model.findIndex(b), k, model);
    					b.setBounds(b.getx(), b.gety(), b.getWidth(), b.getHeight());
    					puzzle.repaint(b.getx(), b.gety(), b.getWidth(), b.getHeight());
    					System.out.println(b.getx());
    				}
    				else {
    					System.out.println("No block selected!");
    				}
    			}
    			
    			@Override
    			public void keyReleased(KeyEvent k) { }
    			
    			@Override
    			public void keyTyped(KeyEvent k) { }
        });
        System.out.println("Added key listener");
        
        
        puzzle.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				Block prev = model.getSelected();
				Point p = me.getPoint();
				int found = model.findIndex(p);
				
				//if block not found, don't highlight any blocks.
				if(found < 0) {
					Block d = model.deselect();
					puzzle.repaint(d.getx(), d.gety(), d.getWidth(), d.getHeight());
					return;
				}
				
					Block b = model.getBlock(found);
					//if(!prev.equals(b)) {
						model.selectBlock(found);
						puzzle.repaint(b.getx(), b.gety(), b.getWidth(), b.getHeight());
						puzzle.repaint(prev.getx(), prev.gety(), prev.getWidth(), prev.getHeight());
					//}
					System.out.println("Point: " + p.x + ", " + p.y);
					System.out.println("Block: " + found);
				
			}
        });
        System.out.println("Added mouse listener");
	
	}
}
