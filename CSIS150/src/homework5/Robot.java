package homework5;

/**
 * Created by apofahl
 */
public abstract class Robot {

    protected int currentCol;
    protected int currentRow;
    protected String botName;
    protected Maze maze;
    protected int count;

    /**
     * Builds a new robot with in a specific maze
     * @param maze maze the bot is in
     */
    public Robot(Maze maze) {
        botName = "Alex";
        setMaze(maze);
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
        currentCol = maze.getStartCol();
        currentRow = maze.getStartRow();
    }

    /**
     * Chooses the direction the robot will moe next
     * @return direction the bot will move
     */
    public abstract int chooseMoveDirection();

    /**
     * Makes the move for the robot
     * @param direction direction the robot will move
     * @return whether or not the move was made
     */
    public abstract boolean move(int direction);

    /**
     * Checks whether the robot has made it through the maze
     * @return whether or not is it done
     */
    public boolean solved() {
        boolean done = false;

        if (currentCol == maze.getExitCol() && currentRow == maze.getExitRow()) {
            done = true;
        }

        return done;
    }

    public void resetBot(int row, int col, int count) {
        currentRow = row;
        currentCol = col;
        this.count = count;
        maze.setCell(row, col, 'R');
        maze.setCell(maze.getExitRow(), maze.getExitCol(), 'X');
    }

    /**
     * Allows user to change robot name
     * @param botName name of robot
     */
    public void setBotName(String botName) {
        this.botName = botName;
    }

    public String toString() {
        String output = "Your robot, " +botName+ ", is currently in row " +currentRow+ " and column " +currentCol+ ".";

        return output;
    }

}