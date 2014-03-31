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
    private final int HEIGHT = 100;
    private final int WIDTH = 100;

    public MazePanel() {

    }

    public void setMaze(Maze maze) {
        this.maze = maze;
        robot.setMaze(maze);
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
        robot.setMaze(maze);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) (g);
        BufferedImage botPic = null;
        try {
            botPic = ImageIO.read(new File("robot.png"));
        } catch (IOException e) {
            System.out.println("Image file not found.");
        }

        for (int row = 0; row < maze.getRows(); row++) {
            for (int col = 0; col < maze.getCols(); col++) {
                switch (maze.getCell(row, col)) {
                    case ('S'):
                        g.drawImage(botPic, HEIGHT, WIDTH, null);
                        break;
                    case ('R'):
                        g.drawImage(botPic, HEIGHT, WIDTH, null);
                        break;
                    case ('*'):
                        g2d.setColor(Color.MAGENTA);
                        g2d.fillRect(row, col, HEIGHT, WIDTH);
                        break;
                    case (' '):
                        g2d.setColor(Color.WHITE);
                        g2d.fillRect(row, col, HEIGHT, WIDTH);
                        break;
                    case ('E'):
                        g2d.setColor(Color.WHITE);
                        g2d.fillRect(row, col, HEIGHT, WIDTH);
                        break;
                    default:

                }
            }
        }
    }
}
