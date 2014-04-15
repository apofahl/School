package homework6;

import java.util.ArrayList;

/**
 *
 * Created by apofahl
 */
public class Point {

    private ArrayList<ArrayList<Integer>> beenHere;

    public Point(int rows, int cols) {
        beenHere = new ArrayList<ArrayList<Integer>>(cols);

        for (int dex = 0; dex < cols; dex++) {
            ArrayList<Integer> toAdd = new ArrayList<Integer>();
            for (int dex2 = 0; dex2 < rows; dex2++) {
                toAdd.add(0);
            }
            beenHere.add(toAdd);
        }
    }

    public int getPoint(int row, int col) {
        int times = beenHere.get(col).get(row);

        return times;
    }

    public void addPoint(int row, int col) {
        int times = beenHere.get(col).get(row) + 1;

        beenHere.get(col).set(row, times);
    }
}
