package littleGuys;

import java.math.BigInteger;

/**
 * Created by apofahl
 */
public class Problem15 {

//    Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
//
//    How many such routes are there through a 20×20 grid?

    static BigInteger[ ] [ ] grid = new BigInteger [20][20];

    public static void main(String [] args) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (row == 0) {
                    if (col == 0) {
                        grid [row] [col] = new BigInteger("2");
                    } else {
                        grid [row] [col] = grid [row] [col - 1].add(BigInteger.ONE);
                    }
                } else if (col == 0) {
                        grid [row] [col] = grid [row - 1] [col].add(BigInteger.ONE);
                } else if (row > 0 && col > 0) {
                    grid [row] [col] = grid [row - 1] [col].add(grid [row] [col - 1]);
                }
            }
        }

        System.out.println(grid [19] [19]);
    }
}
