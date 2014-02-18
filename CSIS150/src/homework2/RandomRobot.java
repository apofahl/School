package homework2;

import java.util.Random;

/**
 * Created by apofahl
 */
public class RandomRobot extends Robot {

    public RandomRobot(Maze maze) {
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
                maze.setCell(currentRow, currentCol, ' ');
                currentRow = currentRow - 1;
                maze.setCell(currentRow, currentCol, 'R');
                count++;
                done = true;
            }
        } else if (direction == 1) {
            if (currentRow < maze.getRows() && maze.openCell(currentRow + 1, currentCol)) {
                maze.setCell(currentRow, currentCol, ' ');
                currentRow = currentRow + 1;
                maze.setCell(currentRow, currentCol, 'R');
                count++;
                done = true;
            }
        } else if (direction == 2) {
            if (currentCol > 0 && maze.openCell(currentRow, currentCol - 1)) {
                maze.setCell(currentRow, currentCol, ' ');
                currentCol = currentCol - 1;
                maze.setCell(currentRow, currentCol, 'R');
                count++;
                done = true;
            }
        } else if (direction == 3) {
            if (currentCol < maze.getCols() && maze.openCell(currentRow, currentCol + 1)) {
                maze.setCell(currentRow, currentCol, ' ');
                currentCol = currentCol + 1;
                maze.setCell(currentRow, currentCol, 'R');
                count++;
                done = true;
            }
        }

        return done;
    }
}
