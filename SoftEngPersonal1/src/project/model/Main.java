package project.model;
import javax.swing.*;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;

import project.view.*;

public class Main {

	public static void main(String[] args) {
		PuzzleApp puzzle = new PuzzleApp();	
		puzzle.setVisible(true);
	}
}
