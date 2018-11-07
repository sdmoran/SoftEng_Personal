package project.controller;
import project.model.*;
import project.view.*;


public class ResetPuzzleController {
	PuzzleApp app;
	
	public ResetPuzzleController(PuzzleApp app) {
		this.app = app;
	}
	
	public void reset() {
		app.getModel().revertBlocks();
	}
}
