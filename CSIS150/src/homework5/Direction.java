package homework5;

/**
 * Created by apofahl
 */
public enum Direction {

    NORTH('N'), SOUTH('S'), EAST('E'), WEST('W');

    private char card;

    /**
     * Defines direction with a char reference
     * @param symbol char reference to direction
     */
    private Direction(char symbol) {
        card = symbol;
    }

    /**
     * Gives user symbol for cardinal direction
     * @return symbol for cardinal direction
     */
    public char getCard() {
        return card;
    }
}
