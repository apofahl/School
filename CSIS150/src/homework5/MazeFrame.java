package homework5;

import com.sun.swing.internal.plaf.metal.resources.metal_sv;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

/**
 * Created by apofahl
 */
public class MazeFrame extends JFrame{

    // Robot Stuff
    private MazePanel panel;
    private Maze maze;
    private Robot robot;
    private boolean running = false;
    private File file;

    // Menu Stuff
    JMenuItem solve;
    JMenu robotMenu;
    JMenuItem rightBot;
    JMenuItem leftBot;
    JMenuItem lookBot;
    JMenuItem randBot;
    JMenuItem wallHopBot;

    // UI Stuff
    private JPanel messPanel;
    private JLabel message;


    public void setUp() {
        //Build Maze Panel
        panel = new MazePanel();
        JMenuBar menuBar = buildMenuBar();
        setJMenuBar(menuBar);

        // Build Message Panel
        messPanel = setUpMessage();
        add(messPanel);

        // Build Frame
        setName("RobotMaze");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
    }

    public JPanel setUpMessage() {
        messPanel = new JPanel();
        message = new JLabel("Please load a maze to solve.");

        messPanel.add(message);

        return messPanel;
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
        solve.setMnemonic('h');
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
        mazeMenu.setMnemonic(KeyEvent.VK_CONTROL);
        JMenuItem newMaze = new JMenuItem("New Maze", KeyEvent.VK_N);

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
        randBot = new JMenuItem("Random Robot");
        wallHopBot = new JMenuItem("Wall Hop Robot");

        // Add Listeners
        ChooseBot choose = new ChooseBot();
        rightBot.addActionListener(choose);
        leftBot.addActionListener(choose);
        lookBot.addActionListener(choose);
        randBot.addActionListener(choose);
        wallHopBot.addActionListener(choose);

        // Put together
        robotMenu.add(rightBot);
        robotMenu.add(leftBot);
        robotMenu.add(lookBot);
        robotMenu.add(randBot);
        robotMenu.add(wallHopBot);

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
                message.setText("Choose a robot to help you.");
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
            } else if (event.getSource() == lookBot) {
                robot = new LookAheadRobot(maze);
                panel.setRobot(robot);
            } else if (event.getSource() == randBot) {
                robot = new RandomRobot(maze);
                panel.setRobot(robot);
            } else {
                robot = new WallHopRobot(maze);
                panel.setRobot(robot);
            }
            solve.setVisible(true);
            panel.setSize(maze.getCols() * 10, maze.getRows() * 10);
            messPanel.setVisible(false);
            add(panel);
            panel.paintComponent(getGraphics());
            panel.requestFocus();
            panel.setFocusTraversalKeysEnabled(false);
            panel.addKeyListener(new KeyMoves());
            setSize(maze.getCols() * 30 + 60, maze.getRows() * 30 + 170);
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
            running = true;
            try {
                int currentX = robot.currentCol;
                int currentY = robot.currentRow;
                for (int count = 0; count < 1000000 && !robot.solved(); count++) {
                    int direction = robot.chooseMoveDirection();
                    if (direction >=0)  { //invalid direction is -1
                        robot.move(direction);
                        panel.setVisible(false);
                        panel.paintComponent(getGraphics()); // repaint was not doing it
                        panel.setVisible(true);
                    }
                    Thread.sleep(1500);
                    robot.maze.setCell(robot.currentRow, robot.currentCol, ' ');
                    robot.maze.setCell(currentY, currentX, 'R');
                }
                Thread.sleep(3000);
                // put bot back after hint
            } catch (Exception e) {

            }
        }
    }

    public class KeyMoves implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            int thisWay = e.getKeyCode(); // Something is happening! 
            switch (thisWay) {
                case KeyEvent.VK_UP:
                    if (robot.currentRow > 0 && robot.maze.openCell(robot.currentRow - 1, robot.currentCol)) {
                        robot.move(0);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (robot.currentRow < robot.maze.getRows() && robot.maze.openCell(robot.currentRow + 1, robot.currentCol)) {
                        robot.move(1);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (robot.currentCol < robot.maze.getCols() && robot.maze.openCell(robot.currentRow, robot.currentCol + 1)) {
                        robot.move(3);

                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (robot.currentCol > 0 && robot.maze.openCell(robot.currentRow, robot.currentCol - 1)) {
                        robot.move(2);
                    }
                    break;
                default:

            }

            // Show move
            panel.setVisible(false);
            panel.paintComponent(getGraphics()); // repaint was not doing it
            panel.setVisible(true);
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }
    }

    public static void main(String [] args) {
        MazeFrame runMaze = new MazeFrame();
        runMaze.setUp();
    }
}
