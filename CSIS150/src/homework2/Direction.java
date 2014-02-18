package homework2;

/**
 * Created by apofahl
 */
public enum Direction {

    NORTH('N'), SOUTH('S'), EAST('E'), WEST('W');

    private char card;

    private Direction(char symbol) {
        card = symbol;
    }

    public char getCard() {
        return card;
    }
}
