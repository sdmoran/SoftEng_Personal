import javax.swing.*;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;


public class Main {
	/*public static void main(String[] args) {
		JFrame gui = new JFrame();
		gui.setTitle("Puzzle");
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		gui.setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Reset");
		menuBar.add(mntmNewMenuItem);
		
		Panel panel = new Panel();
		gui.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(null);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(214, 5, 0, 0);
		panel.add(canvas);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Clicky thingy");
		gui.getContentPane().add(rdbtnNewRadioButton, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		gui.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		gui.setSize(500,500);
		gui.setVisible(true);
		
		
	}*/
	
	 public static void main(String[] args) {
	        JPanel content = new JPanel();
	        content.setBorder(null);
	        JFrame window = new JFrame("GUI Test");
	        window.setContentPane(content);
	        content.setLayout(null);
	        
	        JButton btnNewButton = new JButton("New button");
	        btnNewButton.setBounds(136, 528, 157, 29);
	        content.add(btnNewButton);
	        
	        /**
	         * Set up interior panel for game
	         */
	        JPanel panel = new JPanel();
	        panel.setBackground(Color.WHITE);
	        panel.setBounds(15, 16, 400, 500);
	        content.add(panel);
	        panel.setLayout(null);
	        
	        /**
	         * Tall blocks
	         */
	        Block tallBlock_1 = new Block(100, 200);
	        tallBlock_1.setBounds(0, 0, 100, 200);
	        panel.add(tallBlock_1);
	        
	        Block tallBlock_2 = new Block(100, 200);
	        tallBlock_2.setBounds(0, 200, 100, 200);
	        panel.add(tallBlock_2);
	        
	        Block tallBlock_3 = new Block(100, 200);
	        tallBlock_3.setBounds(300, 0, 100, 200);
	        panel.add(tallBlock_3);
	        
	        Block tallBlock_4 = new Block(100, 200);
	        tallBlock_4.setBounds(300, 200, 100, 200);
	        panel.add(tallBlock_4);
	        
	        /**
	         * Big square block
	         */
	        Block squareBlock = new Block(200, 200);
	        squareBlock.setBounds(100, 0, 200, 200);
	        panel.add(squareBlock);
	        
	        /**
	         * Small blocks
	         */
	        Block smallBlock_1 = new Block(100, 100);
	        smallBlock_1.setBounds(200, 200, 100, 100);
	        panel.add(smallBlock_1);
	        
	        Block smallBlock_2 = new Block(100, 100);
	        smallBlock_2.setBounds(100, 200, 100, 100);
	        panel.add(smallBlock_2);
	        
	        Block smallBlock_3 = new Block(100, 100);
	        smallBlock_3.setBounds(200, 300, 100, 100);
	        panel.add(smallBlock_3);
	        
	        Block smallBlock_4 = new Block(100, 100);
	        smallBlock_4.setBounds(100, 300, 100, 100);
	        panel.add(smallBlock_4);
	        
	        /**
	         * Horizontal Block
	         */
	        Block horizontalBlock = new Block(200, 100);
	        horizontalBlock.setBounds(100, 399, 200, 100);
	        panel.add(horizontalBlock);
	        
	        window.setSize(461, 629);
	        window.setLocation(200, 100);
	        window.setVisible(true);
	}
}
