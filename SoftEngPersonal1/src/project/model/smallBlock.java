package project.model;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class smallBlock extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(0, 0, 90, 90);
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 90, 90);
		g.drawRect(0, 0, 96, 96);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 96, 96);
	}

	public Dimension getPreferredSize() {
		// maximum size. x and y components provide offset from the top corner in the
		// maximum size....
		return new Dimension(100, 100);
	}

}
