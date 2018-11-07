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
	public ArrayList<Block> getBlocks() {
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
	
	/**
	 * findIndex
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
	 * findIndex
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
	 * selectBlock
	 * @param index: The index of the block to be selected
	 */
	public void selectBlock(int index) {
		if(selected >= 0) {
			Block b = blocks.get(selected);
			b.deSelect();
			blocks.set(selected, b);
		}	
			
		Block b = blocks.get(index);
		b.select();
		blocks.set(index, b);
			
		selected = index;
	}
	
	/**
	 * deselect
	 * @return The block that was previously selected
	 */
	public void deselect() {
		if(selected > 0) {
			Block b = blocks.get(selected);
			b.deSelect();
			blocks.set(selected, b);
			selected = -1;
		}
	}
	
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
	
	public void revertBlocks() {
		for(Block b : blocks) {
			b.revertBlock();
		}
		this.totalMoves = 0;
		this.isWon = false;
	}
	
	public boolean isWon() {
		return isWon;
	}
	
	public void setWon() {
		this.isWon = true;
	}
}
