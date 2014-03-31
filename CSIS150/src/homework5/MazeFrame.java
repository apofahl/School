package homework5;

import javax.swing.*;

/**
 * Created by apofahl
 */
public class MazeFrame extends JFrame{


    public void setUp() {
        MazePanel panel = new MazePanel();
        setName("RobotMaze");
        setVisible(true);
        setSize(800, 800);
        add(new MazePanel());
    } 

    public static void main(String [] args) {
        MazeFrame runMaze = new MazeFrame();
        runMaze.setUp();
    }
}
