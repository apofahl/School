package homework2;

/**
 * Created by apofahl
 */
public abstract class FacingRobot extends Robot {

    protected Direction direction;

    public FacingRobot(Maze maze) {
        super(maze);
        direction = Direction.SOUTH;

    }
}
