package homework6;

/**
 *
 * Created by apofahl
 */
public class Point {
    private int rowDone;
    private int colDone;

    public Point(int row, int col) {
        rowDone = row;
        colDone = col;
    }

    public int getRowPoint() {
        return rowDone;
    }

    public int getColPoint() {
        return colDone;
    }
}
