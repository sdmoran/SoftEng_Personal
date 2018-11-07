package project.view;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Optional;
import java.awt.event.ActionEvent;
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		puzzle = new PuzzleView(model);
		
		giveKeyListener(puzzle);
		giveMouseListener(puzzle);
		
		window.add(puzzle);
		window.setLocation(200, 100);
		
		JButton quitButton = new JButton("Quit (Q)");
		quitButton.setBounds(92, 599, 115, 29);
		
		quitButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  QuitApplicationController q = new QuitApplicationController();
			  }
		});
		
		window.add(quitButton);
		
		JButton resetButton = new JButton("Reset (R)");
		resetButton.setBounds(222, 599, 115, 29);
		
		resetButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				System.out.println("Reset Puzzle.");
				puzzle.drawBlocks();
				ResetPuzzleController r = new ResetPuzzleController(PuzzleApp.this);
				r.reset();
				puzzle.requestFocusInWindow();
			  }
		});
		
		window.add(resetButton);
		window.setVisible(true);
		setTitle("Block Puzzle");
		setBounds(100, 100, 455, 700);
	
	}
	
	public void setModel(Model m) {
		this.model = m;
	}
	
	public Model getModel() {
		return this.model;
	}
	
	public void handleKeypress(KeyEvent k) {
		if(k.getKeyCode() == 82) {
			puzzle.drawBlocks();
			ResetPuzzleController r = new ResetPuzzleController(PuzzleApp.this);
			r.reset();
		}
		
		if(model.isWon()) {
			return;
		}
		
		if(k.getKeyCode() == 81) {
			QuitApplicationController q = new QuitApplicationController();
		}
		
		Block b = model.getSelected();
		
		if(b != null) {
			MovePieceController m = new MovePieceController(PuzzleApp.this, model);
			m.moveBlock(model.findIndex(b), k, model);
			b.setBounds(b.getx(), b.gety(), b.getWidth(), b.getHeight());
			puzzle.repaint(b.getx(), b.gety(), b.getWidth(), b.getHeight()); 
		}
		
		else {
			System.out.println("No block selected!");
		}
	}
	
	public void giveKeyListener(PuzzleView p) {
		p.addKeyListener(new KeyListener() {
			@Override
    		public void keyPressed(KeyEvent k) {
    			handleKeypress(k);
    		}
    		@Override
    		public void keyReleased(KeyEvent k) { }
    		
    		@Override
    		public void keyTyped(KeyEvent k) { }
        });
        System.out.println("Added key listener");
	}
	
	public void giveMouseListener(PuzzleView puzz) {
		puzz.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				if(model.isWon()) {
					return;
				}
				Point p = me.getPoint();
				int found = model.findIndex(p);
				
				//if block not found, don't highlight any blocks.
				if(found < 0) {
					model.deselect();
					puzz.redraw();
				}
				
				else {
					model.selectBlock(found);
					puzz.redraw();
				}
				
			}
        });
        System.out.println("Added mouse listener");
	}
}
