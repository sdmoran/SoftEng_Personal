package project.controller;

import project.model.*;

public class SelectPieceController {
	Model model;
	/**
	 * Need to move selection logic from Model to here.
	 */
	
	public SelectPieceController(Model m) {
		this.model = m;
	}
	
	/**
	 * selectBlock - SelectePieceController. For sure.
	 * @param index: The index of the block to be selected
	 */
	public void selectBlock(int index) {
		if(model.getSelectedIndex() >= 0) {
			Block b = model.getBlock(model.getSelectedIndex());
			b.deSelect();
			model.setBlock(model.getSelectedIndex(), b);
		}	
		Block b = model.getBlock(index);
		b.select();
		model.setBlock(index, b);
		model.updateSelected();
	}
	
	public void deselectBlock() {
		if(model.getSelected() != null) {
			Block b = model.getSelected();
			b.deSelect();
			model.setBlock(model.findIndex(b), b);
			model.updateSelected();
		}
	}
}
