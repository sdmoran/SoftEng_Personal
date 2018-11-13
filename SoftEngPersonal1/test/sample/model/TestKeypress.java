package sample.model;

import java.awt.Point;
import java.awt.event.KeyEvent;

import junit.framework.TestCase;
import project.controller.SelectPieceController;
import project.model.*;
import project.view.*;

public class TestKeypress extends TestCase {
	PuzzleApp app;
	Model model;
	
	public void test() {
		model = new Model();
		app = new PuzzleApp(model);
		
		SelectPieceController s = new SelectPieceController(model);
		s.selectBlock(0);
		
		//Test valid keypresses
		assertTrue(app.handleKeypress(KeyEvent.VK_RIGHT));
		assertTrue(app.handleKeypress(KeyEvent.VK_UP));
		assertTrue(app.handleKeypress(KeyEvent.VK_LEFT));
		assertTrue(app.handleKeypress(KeyEvent.VK_DOWN));
		
		//Test invalid keypress
		assertFalse(app.handleKeypress(0));
		
		//Can't test quit, because it quits.
		//app.handleKeypress(81);
		app.handleKeypress(82);
		
	}
}
