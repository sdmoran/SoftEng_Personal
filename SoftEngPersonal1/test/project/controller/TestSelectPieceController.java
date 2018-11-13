package project.controller;

import junit.framework.TestCase;
import project.model.*;

public class TestSelectPieceController extends TestCase {
	public void test() {
		Model m = new Model();
		assertEquals(m.getSelectedIndex(), -1);
		SelectPieceController s = new SelectPieceController(m);
		s.selectBlock(4);
		assertEquals(m.getSelectedIndex(), 4);
		s.selectBlock(5);
		assertEquals(m.getSelectedIndex(), 5);
		s.deselectBlock();
		assertEquals(m.getSelectedIndex(), -1);
	}
}
