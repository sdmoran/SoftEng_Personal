package project.controller;
import project.model.*;
import project.view.*;


public class ResetPuzzleController {
	PuzzleApp app;
	
	public ResetPuzzleController(PuzzleApp app) {
		this.app = app;
	}
	
	public void reset() {
		revertBlocks();
	}
	
	/**
	 * revertBlocks - ResetPuzzleController?
	 */
	public void revertBlocks() {
		for(Block b : app.getModel().getBlockList()) {
			b.revertBlock();
		}
		app.getModel().resetMoves();
		app.getModel().setWon(false);
	}
}
 