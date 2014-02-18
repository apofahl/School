package homework2;

import javax.swing.*;

public abstract class Robot {
	
	protected int currentCol;
	protected int currentRow;
	protected String botName;
	protected Maze maze;
    protected int count;
	
	public Robot(Maze maze) {
		this.maze = new Maze(maze);
		botName = "Alex";
		currentCol = maze.getStartCol();
		currentRow = maze.getStartRow();
	}
	
	public abstract int chooseMoveDirection();
	
	public abstract boolean move(int direction);
	
	public boolean solved() {
		boolean done = false;
		
		if (currentCol == maze.getExitCol() && currentRow == maze.getExitRow()) {
			done = true;
            JOptionPane.showMessageDialog(null, "The maze is solved in " +count+ " moves!");
		}

		return done;
	}
	
	public String toString() {
		String output = "Your robot, " +botName+ " is currently in the " +currentRow+ " row and the " +currentCol+ ".";
		
		return output;
	}

}
