import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Block extends JPanel {
	private int width;
	private int height;
	
	public Block(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawRect(0, 0, width, height );
		g.setColor(Color.WHITE);  
		g.fillRect(0, 0, width, height);  
		
		g.drawRect(2, 2, width - 4, height - 4);
		g.setColor(Color.RED);  
		g.fillRect(2, 2, width - 4, height - 4);
	}
}
