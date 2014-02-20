package homework2;

/**
 * Created by apofahl
 */
public class LeftHandRobot extends FacingRobot {

    /**
     * Builds a robot in a specific maze and started facing south
     * @param maze maze the bot is in
     */
    public LeftHandRobot(Maze maze) {
        super(maze);
    }

    /**
     * Chooses the direction the robot will moe next
     * @return direction the bot will move
     */
    @Override
    public int chooseMoveDirection() {
        int move;

        switch (direction.getCard()) {
            case 'S':
                if (currentCol < maze.getCols() && maze.openCell(currentRow, currentCol + 1)) {
                    move = 3;
                } else if (currentRow < maze.getRows() && maze.openCell(currentRow + 1, currentCol)) {
                    move = 1;
                } else if (currentCol > 0 && maze.openCell(currentRow, currentCol - 1)) {
                    move = 2;
                } else {
                    move = 0;
                }
                break;
            case 'N':
                if (currentCol > 0 && maze.openCell(currentRow, currentCol - 1)) {
                    move = 2;
                } else if (currentRow > 0 && maze.openCell(currentRow - 1, currentCol)) {
                    move = 0;
                } else if (currentCol < maze.getCols() && maze.openCell(currentRow, currentCol + 1)) {
                    move = 3;
                } else {
                    move = 1;
                }
                break;
            case 'W':
                if (currentRow < maze.getRows() && maze.openCell(currentRow + 1, currentCol)) {
                    move = 1;
                } else if (currentCol > 0 && maze.openCell(currentRow, currentCol - 1)) {
                    move = 2;
                } else if (currentRow > 0 && maze.openCell(currentRow - 1, currentCol)) {
                    move = 0;
                } else {
                    move = 3;
                }
                break;
            case 'E':
                if (currentRow > 0 && maze.openCell(currentRow - 1, currentCol)) {
                    move = 0;
                } else if (currentCol < maze.getCols() && maze.openCell(currentRow, currentCol + 1)) {
                    move = 3;
                } else if (currentRow < maze.getRows() && maze.openCell(currentRow + 1, currentCol)) {
                    move = 1;
                } else {
                    move = 2;
                }
                break;
            default:
                move = -1;
        }

        return move;
    }

    /**
     * Makes the move for the robot
     * @param direction direction the robot will move
     * @return whether or not the move was made
     */
    @Override
    public boolean move(int direction) {
        boolean done = false;
        maze.setCell(currentRow, currentCol, ' ');

        if (direction == 0) {
            currentRow = currentRow - 1;
            this.direction = Direction.NORTH;
            count++;
            done = true;
        } else if (direction == 1) {
            currentRow = currentRow + 1;
            this.direction = Direction.SOUTH;
            count++;
            done = true;
        } else if (direction == 2) {
            currentCol = currentCol - 1;
            this.direction = Direction.WEST;
            count++;
            done = true;
        } else if (direction == 3) {
            currentCol = currentCol + 1;
            count++;
            this.direction = Direction.EAST;
            done = true;
        }

        maze.setCell(currentRow, currentCol, this.direction.getCard());
        return done;
    }

}
