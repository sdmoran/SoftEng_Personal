package project.model;

import java.awt.Point;
import java.util.*;

public class Model {
	
	ArrayList<Block> blocks;
	int selected;
	
	public Model() {
		this.blocks = new ArrayList<>();
		/**
		 * Add tall blocks
		 */
		blocks.add(new Block(2, 2, 100, 200));
		blocks.add(new Block(2, 202, 100, 200));
		blocks.add(new Block(302, 2, 100, 200));
		blocks.add(new Block(302, 202, 100, 200));
		
        /**
         * Big square block
         */
		blocks.add(new Block(102, 2, 200, 200));
        
        /**
         * Small blocks
         */
		blocks.add(new Block(202, 202, 100, 100));
		blocks.add(new Block(102, 202, 100, 100));
		blocks.add(new Block(202, 302, 100, 100));
		blocks.add(new Block(102, 302, 100, 100));
        
        /**
         * Horizontal Block
         */
		blocks.add(new Block(102, 402, 200, 100));
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
		Block b = blocks.get(selected);
		b.deSelect();
		blocks.set(selected, b);
		
		
		b = blocks.get(index);
		b.select();
		blocks.set(index, b);
		
		selected = index;
	}
	
	/**
	 * deselect
	 * @return The block that was previously selected
	 */
	public Block deselect() {
		Block b = blocks.get(selected);
		b.deSelect();
		blocks.set(selected, b);
		System.out.println("Deselected!");
		//selected = -1;
		return b;	
	}
	
	public Block getSelected() {
		if(selected >= 0) {
			return blocks.get(selected);
		}
		else
			return null; 
	}
}
