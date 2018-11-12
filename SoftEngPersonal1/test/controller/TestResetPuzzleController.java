package project.controller;

import junit.framework.TestCase;
import project.model.*;

public class TestResetPuzzleController extends TestCase {
	public void test() {
		Model m = new Model();
		ResetPuzzleController r = new ResetPuzzleController(m);
		
		for(Block b : m.getBlockList()) {
			b.movex(1000);
			b.movey(-1000);
		}
		
		r.reset();
		assertEquals(m.getBlock(0).getx(), 2);
		
	}
}
