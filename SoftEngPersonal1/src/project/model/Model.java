package project.model;

import java.awt.Point;
import java.util.*;

public class Model {
	
	ArrayList<Block> blocks;
	int selected;
	int totalMoves;
	boolean isWon;
	
	
	public Model() {
		this.blocks = new ArrayList<>();
		this.selected = -1;
		this.totalMoves = 0;
		/**
		 * Add tall blocks
		 */
		blocks.add(new Block(2, 2, 100, 200));
		blocks.add(new Block(2, 202, 100, 200));
		blocks.add(new Block(102, 102, 100, 200));
		
        /**
         * Big square block
         */
		blocks.add(new Block(202, 102, 200, 200));
        
        /**
         * Small blocks
         */
		blocks.add(new Block(102, 2, 100, 100));
		blocks.add(new Block(202, 2, 100, 100));
		blocks.add(new Block(302, 2, 100, 100));
		blocks.add(new Block(302, 302, 100, 100));
        
        /**
         * Horizontal Blocks
         */
		blocks.add(new Block(102, 302, 200, 100));
		blocks.add(new Block(202, 402, 200, 100));
	}
	
	/**
	 * getBlocks
	 * @return The list of blocks in the model
	 */
	public ArrayList<Block> getBlockList() {
		return this.blocks;
	}
	
	/**
	 * getBlock
	 * @param index: The index from which to retrieve a block
	 * @return The block retrieved from given index
	 */
	public Block getBlock(int index) {
		return blocks.get(index);
	}
	
	public void setBlock(int index, Block b) {
		if(index < this.blocks.size() && index >= 0) {
			this.blocks.set(index, b);
		}
	}
	
	/**
	 * findIndex - MovePieceController?
	 * @param p: A Point object representing a position on the game board
	 * @return The index of the block that contains the point, -1 if no block there.
	 */
	public int findIndex(Point p) {
		int index = 0;
		for(Block b : blocks) {
			//if block.getx < p.x < block.getx + block.width
			//&& if block.gety < p.y < block.gety + block.width
			//return b;
			if(b.getx() <= p.x && p.x < b.getx() + b.getWidth()
					&& b.gety() <= p.y && p.y < b.gety() + b.getHeight()) {
				return index;
			}
			index++;
		}
		return -1;
	}
	
	/**
	 * findIndex - MovePieceController?
	 * @param p: A Block object representing a block on the game board
	 * @return The index of the block in the list of blocks, -1 if not found
	 */
	public int findIndex(Block b) {
		int i = 0;
		for(Block c : blocks) {
			if(c.equals(b)) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	/**
	 * updateSelected - SelectPieceController?
	 * Updates selected block in list. If no block selected, returns -1.
	 */
	public void updateSelected() {
		for(Block c : blocks) {
			if(c.selected == true) {
				this.selected = findIndex(c);
				return;
			}
		}
		this.selected = -1;
	}
	
	/**
	 * getSelected - Here, probably.
	 * @return
	 */
	public Block getSelected() {
		if(selected >= 0) {
			return blocks.get(selected);
		}
		else
			return null;
	}
	
	public void incMoves() {
		totalMoves++;
	}
	
	public int getMoveNum() {
		return totalMoves;
	}
	
	public boolean isWon() {
		return isWon;
	}
	
	public void setWon(boolean b) {
		this.isWon = b;
	}
	
	public void resetMoves() {
		this.totalMoves = 0;
		this.isWon = false;
	}
	
	public int getSelectedIndex() {
		return selected;
	}
}
