package homework5;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Created by apofahl
 */
public class MazePanel extends JPanel{

    private Maze maze;
    private Robot robot;
    private JLabel message = new JLabel("Use your arrow keys to navigate maze.");
    private final int HEIGHT = 30;
    private final int WIDTH = 30;
    private final int SIDE = 10;
    private final int TOP = 65;

    public void setMaze(Maze maze) {
        this.maze = new Maze(maze);
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public void setMessage(String info) {
        message.setText(info);
    }

    public void paintComponent(Graphics g) {
        setFocusable(true);
        add(message);
        Graphics2D g2d = (Graphics2D) (g);
        setBackground(Color.WHITE);
        BufferedImage botPic = null;
        BufferedImage ending = null;
        try {
            botPic = ImageIO.read(new File("robot.png"));
            ending = ImageIO.read(new File("Xspot.png"));
        } catch (IOException e) {
            System.out.println("Image file not found.");
        }

        for (int row = 0; row < maze.getRows(); row++) {
            for (int col = 0; col < maze.getCols(); col++) {
                switch (robot.maze.getCell(row, col)) {
                    case ('S'):
                        g.drawImage(botPic, col * WIDTH +SIDE, row * HEIGHT +TOP, null);
//                        g2d.setColor(Color.RED);
//                        g2d.fillOval(col * WIDTH +SIDE, row * HEIGHT +TOP, HEIGHT, WIDTH);
                        break;
                    case ('N'):
                        g.drawImage(botPic, col * WIDTH +SIDE, row * HEIGHT +TOP, null);
//                        g2d.setColor(Color.RED);
//                        g2d.fillOval(col * WIDTH +SIDE, row * HEIGHT +TOP, HEIGHT, WIDTH);
                        break;
                    case ('W'):
                        g.drawImage(botPic, col * WIDTH +SIDE, row * HEIGHT +TOP, null);
//                        g2d.setColor(Color.RED);
//                        g2d.fillOval(col * WIDTH +SIDE, row * HEIGHT +TOP, HEIGHT, WIDTH);
                        break;
                    case ('E'):
                        g.drawImage(botPic, col * WIDTH +SIDE, row * HEIGHT +TOP, null);
//                        g2d.setColor(Color.RED);
//                        g2d.fillOval(col * WIDTH +SIDE, row * HEIGHT +TOP, HEIGHT, WIDTH);
                        break;
                    case ('R'):
                        g.drawImage(botPic, col * WIDTH +SIDE, row * HEIGHT +TOP, null);
//                        g2d.setColor(Color.CYAN);
//                        g2d.fillOval(col * WIDTH +SIDE, row * HEIGHT +TOP, HEIGHT, WIDTH);
                        break;
                    case ('*'):
                        g2d.setColor(Color.MAGENTA);
                        g2d.fillRect(col * WIDTH +SIDE, row * HEIGHT +TOP, HEIGHT, WIDTH);
                        break;
                    case (' '):
                        g2d.setColor(Color.WHITE);
                        g2d.fillRect(col * WIDTH +SIDE, row * HEIGHT +TOP, HEIGHT, WIDTH);
                        break;
                    case ('X'):
                        g.drawImage(ending, col * WIDTH +SIDE, row * HEIGHT +TOP, null);

//                        g2d.setColor(Color.WHITE);
//                        g2d.fillRect(col * WIDTH +SIDE, row * HEIGHT +TOP, HEIGHT, WIDTH);
                        break;
                    default:

                }
            }
        }
    }
}
