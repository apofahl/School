package homework6;

import javax.swing.*;
import java.awt.*;

/**
 * Created by apofahl
 */
public class MemoryFrame extends JFrame {

    private JPanel panel;
    private Point points;
    private final int HEIGHT = 30;
    private final int WIDTH = 30;
    private final int SIDE = 10;
    private final int TOP = 65;

    public MemoryFrame(MemoryRobot robot) {
        panel = new JPanel();
        points = robot.getPoints();
        paintComponent(getGraphics());
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) (g);
        setBackground(Color.WHITE);

        for (int row = 0; row < points.getCols(); row++) {
            for (int col = 0; col < points.getRows(); col++) {
                switch (points.getPoint(row, col)) {
                    case ('0'):
                        g2d.setColor(Color.WHITE);
                        g2d.fillRect(row * WIDTH +SIDE, col * HEIGHT +TOP, HEIGHT, WIDTH);
                        break;
                    case ('1'):
                        g2d.setColor(Color.getColor("C3DDDD"));
                        g2d.fillRect(col * WIDTH + SIDE, row * HEIGHT + TOP, HEIGHT, WIDTH);
                        break;
                    case ('2'):
                        g2d.setColor(Color.getColor("87BBBB"));
                        g2d.fillRect(col * WIDTH +SIDE, row * HEIGHT +TOP, HEIGHT, WIDTH);
                        break;
                    case ('3'):
                        g2d.setColor(Color.getColor("5FA4A4"));
                        g2d.fillRect(col * WIDTH +SIDE, row * HEIGHT +TOP, HEIGHT, WIDTH);
                        break;
                    case ('4'):
                        g2d.setColor(Color.getColor("388E8E"));
                        g2d.fillRect(col * WIDTH +SIDE, row * HEIGHT +TOP, HEIGHT, WIDTH);
                        break;
                    default:

                }
            }
        }
    }
}
