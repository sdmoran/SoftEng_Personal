package project.controller;
import project.model.*;
import project.view.*;


public class ResetPuzzleController {
	Model model;
	
	public ResetPuzzleController(Model model) {
		this.model = model;
	}
	
	public void reset() {
		revertBlocks();
	}
	
	/**
	 * revertBlocks - ResetPuzzleController?
	 */
	void revertBlocks() {
		for(Block b : model.getBlockList()) {
			b.revertBlock();
		}
		model.resetMoves();
		model.setWon(false);
	}
}
 