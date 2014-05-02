package homework6;

import javax.swing.*;

/**
 * Created by apofahl
 */
public class MemoryFrame extends JFrame {

    private MemoryPanel panel;

    /**
     * Opens window of robot memory
     * @param robot
     */
    public MemoryFrame(MemoryRobot robot) {
        panel = new MemoryPanel(robot.getPoints());
        add(panel);

        setTitle("Robot Memory");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 450);
    }
}
