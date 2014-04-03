package homework5;

/**
 * Created by apofahl
 */
public class WallHopRobot extends FacingRobot{


    /**
     * Builds a robot in a specific maze and started facing south
     * @param maze maze the bot is in
     */
    public WallHopRobot(Maze maze) {
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
                if (currentRow < maze.getRows() && maze.openCell(currentRow + 1, currentCol)) {
                    move = 1;
                } else if (currentCol > 0 && maze.openCell(currentRow, currentCol - 1)) {
                    move = 2;
                } else if (currentCol < maze.getCols() && maze.openCell(currentRow, currentCol + 1)) {
                    move = 3;
                } else if (currentRow + 1 < maze.getRows() && maze.openCell(currentRow + 2, currentCol)) {
                    move = 4;
                } else {
                    move = 0;
                }
                break;
            case 'N':
                if (currentRow > 0 && maze.openCell(currentRow - 1, currentCol)) {
                    move = 0;
                } else if (currentCol < maze.getCols() && maze.openCell(currentRow, currentCol + 1)) {
                    move = 3;
                } else if (currentCol > 0 && maze.openCell(currentRow, currentCol - 1)) {
                    move = 2;
                } else if (currentRow - 1 > 0 && maze.openCell(currentRow - 2, currentCol)) {
                    move = 5;
                } else {
                    move = 1;
                }
                break;
            case 'W':
                if (currentCol > 0 && maze.openCell(currentRow, currentCol - 1)) {
                    move = 2;
                } else if (currentRow > 0 && maze.openCell(currentRow - 1, currentCol)) {
                    move = 0;
                } else if (currentRow < maze.getRows() && maze.openCell(currentRow + 1, currentCol)) {
                    move = 1;
                } else if (currentCol - 1 > 0 && maze.openCell(currentRow, currentCol - 2)) {
                    move = 6;
                } else {
                    move = 3;
                }
                break;
            case 'E':
                if (currentCol < maze.getCols() && maze.openCell(currentRow, currentCol + 1)) {
                    move = 3;
                } else if (currentRow < maze.getRows() && maze.openCell(currentRow + 1, currentCol)) {
                    move = 1;
                } else if (currentRow > 0 && maze.openCell(currentRow - 1, currentCol)) {
                    move = 0;
                } else if (currentCol + 1 < maze.getCols() && maze.openCell(currentRow, currentCol + 2)) {
                    move = 7;
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
        } else if (direction == 4) {
            currentRow = currentRow + 2;
            count++;
            this.direction = Direction.SOUTH;
            done = true;
        } else if (direction == 5) {
            currentCol = currentCol -2;
            count++;
            this.direction = Direction.NORTH;
            done = true;
        } else if (direction == 6) {
            currentCol = currentCol - 2;
            count++;
            this.direction = Direction.WEST;
            done = true;
        } else if (direction == 7) {
            currentCol = currentCol + 2;
            count++;
            this.direction = Direction.EAST;
            done = true;
        }

        maze.setCell(currentRow, currentCol, this.direction.getCard());
        return done;
    }

}
