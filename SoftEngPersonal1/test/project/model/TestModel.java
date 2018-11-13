package project.model;

import java.awt.Point;

import junit.framework.TestCase;

public class TestModel extends TestCase {
	
	public static void test() {
	Model m = new Model();
		assertEquals(m.getBlock(0).getx(), 2);
		
		
		assertFalse(m.isWon());
		m.setWon(true);
		assertTrue(m.isWon());
		
		assertEquals(m.getMoveNum(), 0);
		m.incMoves();
		assertEquals(m.getMoveNum(), 1);
		
		m.resetMoves();
		assertEquals(m.getMoveNum(), 0);
		assertFalse(m.isWon());
		
		Block b = new Block(10, 10, 100, 100);
		m.setBlock(0, b);
		assertTrue(b.equals(m.getBlock(0)));
		
		assertEquals(m.findIndex(new Point(-1, -1)), -1);
		Block c = m.getBlock(5);
		assertEquals(m.findIndex(c), 5);
		
		assertEquals(m.getSelected(), null);
		assertEquals(m.getSelectedIndex(), -1);
		
		b.select();
		m.updateSelected();
		assertTrue(m.getSelected().equals(b));
		assertEquals(m.getSelectedIndex(), 0);
	}
}
