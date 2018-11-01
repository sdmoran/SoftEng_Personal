package project.view;
import javax.swing.*;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import java.awt.event.KeyEvent;

import project.model.Block;
import project.model.Model;
import project.view.*;

public class PuzzleView extends JPanel {
	Model model;
	
	public PuzzleView(Model model) {
		this.model = model;
	}
	
	public void drawBlocks() {
		for(Block b : model.getBlocks()) {
			b.setBounds(b.getx(), b.gety(), b.getWidth(), b.getHeight());
			this.add(b);
		}
	}
	
	
	public boolean checkCollision(Block b, Block c, KeyEvent k) {
		//b.comparePoints(c, k);
		return false;
	}
}
