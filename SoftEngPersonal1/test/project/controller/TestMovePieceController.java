package project.controller;

import junit.framework.TestCase;
import project.view.PuzzleApp;
import project.model.*;

public class TestMovePieceController extends TestCase {
	
	private static final int LEFT = 37;
	private static final int UP = 38;
	private static final int RIGHT = 39;
	private static final int DOWN = 40;

	public void test() {
		Model model = new Model();
		PuzzleApp app = new PuzzleApp(model);
		MovePieceController m = new MovePieceController(app, model);
		
		//Test big block moving, all should fail
		assertFalse(m.moveBlock(3, LEFT, model));
		assertFalse(m.moveBlock(3, UP, model));
		assertFalse(m.moveBlock(3, RIGHT, model));
		assertFalse(m.moveBlock(3, DOWN, model));
		
		//Test bottom most wide block moving left 
		assertTrue(m.moveBlock(9, LEFT, model));
		assertTrue(m.moveBlock(9, RIGHT, model));
		
		assertTrue(m.moveBlock(1, DOWN, model));
		assertTrue(m.moveBlock(1, UP, model));
		assertFalse(m.moveBlock(1, RIGHT, model));
		
		assertFalse(m.moveBlock(0, UP, model));
	
		//testing for arbitrary keypress input
		assertFalse(m.moveBlock(1, 0, model));
	}
}
