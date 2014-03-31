package homework5;

/**
 * Created by apofahl
 */
public abstract class FacingRobot extends Robot {

    protected Direction direction;

    /**
     * Builds a robot in a specific maze and started facing south
     * @param maze maze the bot is in
     */
    public FacingRobot(Maze maze) {
        super(maze);
        direction = Direction.SOUTH;

    }
}
