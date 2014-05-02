package homework6;

import java.util.Random;

/**
 * Created by apofahl
 */
public class MemoryRobot extends Robot{

    private Memory points;

    /**
     * Builds a robot that blocks dead ends and remembers the locations it has been in
     * @param maze maze to navigate
     */
    public MemoryRobot(Maze maze) {
        super(maze);
        points = new Memory(maze);
    }

    /**
     * Chooses the direction the robot will moe next
     * @return direction the bot will move
     */
    @Override
    public int chooseMoveDirection() {
        Random random = new Random();
        int choice = random.nextInt(4);
        return choice;
    }

    /**
     * Makes the move for the robot
     * @param direction direction the robot will move
     * @return whether or not the move was made
     */
    @Override
    public boolean move(int direction) {
        boolean done = false;

        if (direction == 0) {
            if (currentRow > 0 && maze.openCell(currentRow - 1, currentCol)) {
                if (deadEnd(currentRow, currentCol)) {
                    maze.setCell(currentRow, currentCol, 'D');
                } else {
                    points.addPoint(currentRow, currentCol);
                    maze.setCell(currentRow, currentCol, ' ');
                }
                currentRow = currentRow - 1;
                maze.setCell(currentRow, currentCol, 'R');
                count++;
                done = true;
            }
        } else if (direction == 1) {
            if (currentRow < maze.getRows() && maze.openCell(currentRow + 1, currentCol)) {
                if (deadEnd(currentRow, currentCol)) {
                    maze.setCell(currentRow, currentCol, 'D');
                } else {
                    points.addPoint(currentRow, currentCol);
                    maze.setCell(currentRow, currentCol, ' ');
                }
                currentRow = currentRow + 1;
                maze.setCell(currentRow, currentCol, 'R');
                count++;
                done = true;
            }
        } else if (direction == 2) {
            if (currentCol > 0 && maze.openCell(currentRow, currentCol - 1)) {
                if (deadEnd(currentRow, currentCol)) {
                    maze.setCell(currentRow, currentCol, 'D');
                } else {
                    points.addPoint(currentRow, currentCol);
                    maze.setCell(currentRow, currentCol, ' ');
                }
                currentCol = currentCol - 1;
                maze.setCell(currentRow, currentCol, 'R');
                count++;
                done = true;
            }
        } else if (direction == 3) {
            if (currentCol < maze.getCols() && maze.openCell(currentRow, currentCol + 1)) {
                if (deadEnd(currentRow, currentCol)) {
                    maze.setCell(currentRow, currentCol, 'D');
                } else {
                    points.addPoint(currentRow, currentCol);
                    maze.setCell(currentRow, currentCol, ' ');
                }
                currentCol = currentCol + 1;
                maze.setCell(currentRow, currentCol, 'R');
                count++;
                done = true;
            }
        }

        return done;
    }

    /**
     * Checks to see if the robot has been in this location
     * @param row row to check
     * @param col column to check
     * @return whether or not it has been there
     */
    private int beenHere(int row, int col) {
        int been = points.getPoint(row, col);

        return been;
    }

    /**
     * Checks to see if the location is a dead end
     * @param row row of check
     * @param col column of check
     * @return whether or not the location is a dead end
     */
    private boolean deadEnd(int row, int col) {
        int count = 0;
        boolean dead = false;

        if (row == maze.getRows() || !maze.openCell(row + 1, col)) {
            count++;
        }
        if (row == 0 || !maze.openCell(row - 1, col)) {
            count++;
        }
        if (col == maze.getCols() || !maze.openCell(row, col + 1)) {
            count++;
        }
        if (col == 0 || !maze.openCell(row, col - 1)) {
            count ++;
        }
        if (count >= 3) {
            dead = true;
        }

        return dead;
    }

    /**
     * Gets memory of robot
     * @return memory of robot
     */
    public Memory getPoints() {
        return points;
    }
}
