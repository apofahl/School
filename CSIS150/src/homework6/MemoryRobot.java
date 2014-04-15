package homework6;

import java.util.Random;

/**
 * Created by apofahl
 */
public class MemoryRobot extends Robot{

    private Point points;

    public MemoryRobot(Maze maze) {
        super(maze);
        points = new Point(maze.getRows(), maze.getCols());
    }

    @Override
    public int chooseMoveDirection() {
        Random random = new Random();
        int choice = random.nextInt(4);
        return choice;
    }

    @Override
    public boolean move(int direction) {
        boolean done = false;

        if (direction == 0) {
            if (currentRow > 0 && maze.openCell(currentRow - 1, currentCol)) {
                if (deadEnd(currentRow, currentCol) || beenHere(currentRow, currentCol) > 4) {
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
                if (deadEnd(currentRow, currentCol) || beenHere(currentRow, currentCol) > 4) {
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
                if (deadEnd(currentRow, currentCol) || beenHere(currentRow, currentCol) > 4) {
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
                if (deadEnd(currentRow, currentCol) || beenHere(currentRow, currentCol) > 4) {
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

    private int beenHere(int row, int col) {
        int been = points.getPoint(row, col);

        return been;
    }

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
}
