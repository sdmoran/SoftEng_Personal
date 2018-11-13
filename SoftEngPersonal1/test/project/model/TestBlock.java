package project.model;

import junit.framework.TestCase;
import project.model.Block;

public class TestBlock extends TestCase {
	public void test() {
		Block b = new Block(10, 10, 100, 200);
		assertEquals(b.getHeight(), 200);
		assertEquals(b.getWidth(), 100);
		b.select();
		assertTrue(b.selected);
		b.deSelect();
		assertFalse(b.selected);
		
		assertEquals(b.getx(), 10);
		assertEquals(b.gety(), 10);
		
		b.movex(90);
		b.movey(40);
		assertEquals(b.getx(), 100);
		assertEquals(b.gety(), 50);
		
		b.revertBlock();
		assertEquals(b.getx(), 10);
		assertEquals(b.gety(), 10);
	}
	
	
}
