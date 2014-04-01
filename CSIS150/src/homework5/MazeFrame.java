package homework5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.text.AttributedCharacterIterator;

import javax.swing.*;
import javax.swing.text.Utilities;

/**
 * Created by apofahl
 */
public class MazeFrame extends JFrame{

    private MazePanel panel;
    private Maze maze;
    private Robot robot;
    private boolean running = false;
    private File file;
    JMenuItem solve;
    JMenu robotMenu;
    JMenuItem rightBot;
    JMenuItem leftBot;
    JMenuItem lookBot;

    public void setUp() {
        panel = new MazePanel();
        JMenuBar menuBar = buildMenuBar();
        setJMenuBar(menuBar);

        setName("RobotMaze");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
    }

    public JMenuBar buildMenuBar() {
        //Set up
        JMenuBar menu = new JMenuBar();
        JMenu fileMenu = buildFileMenu();
        JMenu mazeMenu = buildMazeMenu();
        JMenu robotMenu = buildRobotMenu();

        // Put together
        menu.add(fileMenu);
        menu.add(mazeMenu);
        menu.add(robotMenu);
        robotMenu.setVisible(false);

        return menu;
    }

    public JMenu buildFileMenu() {
        // File menu set up
        JMenu fileMenu = new JMenu("File");
        solve = new JMenuItem("Hint");
        JMenuItem exit = new JMenuItem("Exit");

        // Add Listeners
        ShowSolution hint = new ShowSolution();
        solve.addActionListener(hint);
        CloseProgram close = new CloseProgram();
        exit.addActionListener(close);

        // Put together
        fileMenu.add(solve);
        solve.setVisible(false);
        fileMenu.add(new JSeparator());
        fileMenu.add(exit);

        return fileMenu;
    }

    public JMenu buildMazeMenu() {
        // Maze menu set up
        JMenu mazeMenu = new JMenu("Maze");
        JMenuItem newMaze = new JMenuItem("New Maze");

        // Add Listeners
        NewMazeOpen mazeOpen = new NewMazeOpen();
        newMaze.addActionListener(mazeOpen);

        // Put together
        mazeMenu.add(newMaze);

        return mazeMenu;
    }

    public JMenu buildRobotMenu() {
        // Robot menu set up
        robotMenu = new JMenu("Robot");
        rightBot = new JMenuItem("Righthand Robot");
        leftBot = new JMenuItem("Lefthand Robot");
        lookBot = new JMenuItem("Look Ahead Robot");

        // Add Listeners
        ChooseBot choose = new ChooseBot();
        rightBot.addActionListener(choose);
        leftBot.addActionListener(choose);
        lookBot.addActionListener(choose);

        // Put together
        robotMenu.add(rightBot);
        robotMenu.add(leftBot);
        robotMenu.add(lookBot);

        return robotMenu;
    }

    public class NewMazeOpen implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            JFileChooser chooser;
            try {
                // Get the filename.
                chooser = new JFileChooser();
                int status = chooser.showOpenDialog(null);
                if (status != JFileChooser.APPROVE_OPTION) {
                    System.out.println("No File Chosen");
                    System.exit(0);
                }
                file = chooser.getSelectedFile();
                maze = new Maze(file);
                panel.setMaze(maze);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
            robotMenu.setVisible(true);
        }

    }

    public class ChooseBot implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == rightBot) {
                robot = new RightHandRobot(maze);
                panel.setRobot(robot);
            } else if (event.getSource() == leftBot) {
                robot = new LeftHandRobot(maze);
                panel.setRobot(robot);
            } else {
                robot = new LookAheadRobot(maze);
                panel.setRobot(robot);
            }
            solve.setVisible(true);
            panel.setSize(maze.getCols() * 10 , maze.getRows() * 10);
            add(panel);
            panel.paintComponent(getGraphics());
            panel.addMouseListener(new MouseMoves());
            setSize(maze.getCols() * 30 +40 , maze.getRows() * 30 +150);
        }
    }

    public class CloseProgram implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }

    public class ShowSolution implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            for (int count = 0; count < 1000000 && !robot.solved(); count++) {
                int direction = robot.chooseMoveDirection();
                if (direction >=0)  { //invalid direction is -1
                    robot.move(direction);
                    panel.setVisible(false);
                    panel.paintComponent(getGraphics()); // need to find a way to show new maze
                    panel.setVisible(true);
                }
//                try {
//                    wait(300);
//                } catch (InterruptedException e) {
//                    System.out.println("Something went wrong.");
//                }
            }

        }
    }

    public class MouseMoves implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            panel.getToolTipLocation(e);
            System.out.println(e.getPoint());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public static void main(String [] args) {
        MazeFrame runMaze = new MazeFrame();
        runMaze.setUp();
    }
}
