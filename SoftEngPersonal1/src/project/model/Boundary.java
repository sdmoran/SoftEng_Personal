package project.model;
import java.awt.Color;
import java.awt.Graphics;

public class Goal extends Block {
	public Goal() {
		super(0, 0, 200, 200);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
	}
}
