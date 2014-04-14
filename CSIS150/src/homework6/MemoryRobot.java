package homework6;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by apofahl
 */
public class MemoryRobot extends Robot{

    private ArrayList<Point> points;

    public MemoryRobot(Maze maze) {
        super(maze);
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
                if (deadEnd(currentRow, currentCol)) {
                    maze.setCell(currentRow, currentCol, 'D');
                } else {
                    points.add(new Point(currentRow, currentCol));
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
                    points.add(new Point(currentRow, currentCol));
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
                    points.add(new Point(currentRow, currentCol));
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
                    points.add(new Point(currentRow, currentCol));
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

    private boolean beenHere(int row, int col) {
        boolean been = false;

        for (Point point : points) {
            if (point.getRowPoint() == row && point.getColPoint() == col) {
                been = true;
                break;
            }
        }

        return been;
    }

    private boolean deadEnd(int row, int col) {
        int count = 0;
        boolean dead = false;

        if (currentRow < maze.getRows() && maze.openCell(row + 1, col)) {
            count++;
        }
        if (currentRow > 0 && maze.openCell(row - 1, col)) {
            count++;
        }
        if (currentCol < maze.getCols() && maze.openCell(row, col + 1)) {
            count++;
        }
        if (currentCol > 0 && maze.openCell(row, col - 1)) {
            count ++;
        }
        if (count >= 3) {
            dead = true;
        }

        return dead;
    }
}
