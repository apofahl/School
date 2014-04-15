package homework6;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

/**
 * Created by apofahl
 */
public class MazeFrame extends JFrame{

    // Robot Stuff
    private MazePanel panel;
    private Maze maze;
    private Maze refresh;
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
    JMenuItem memoryBot;

    // UI Stuff
    private JPanel messPanel;
    private JLabel message;
    private JButton showMemory;


    /**
     * Sets up JFrame
     */
    public void setUp() {
        //Build Maze Panel
        panel = new MazePanel();
        JMenuBar menuBar = buildMenuBar();
        setJMenuBar(menuBar);

        // Set up buttons
        showMemory = new JButton("Show Memory");
        showMemory.addActionListener(new ShowMemory());

        // Build Message Panel
        messPanel = setUpMessage();
        add(messPanel);

        // Build Frame
        setTitle("RobotMaze");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
    }

    /**
     * Sets up message panel to communicate with user
     * @return message panel
     */
    public JPanel setUpMessage() {
        messPanel = new JPanel();
        message = new JLabel("Please load a maze to solve.");

        messPanel.add(message);

        return messPanel;
    }

    /**
     * Builds menu bar
     * @return built menu bar
     */
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

    /**
     * Builds file menu
     * @return built file menu
     */
    public JMenu buildFileMenu() {
        // File menu set up
        JMenu fileMenu = new JMenu("File");
        solve = new JMenuItem("Hint");
        JMenuItem exit = new JMenuItem("Exit");

        // Add Listeners
        ShowSolution hint = new ShowSolution();
        solve.addActionListener(hint);
        solve.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        CloseProgram close = new CloseProgram();
        exit.addActionListener(close);

        // Put together
        fileMenu.add(solve);
        solve.setEnabled(false);
        fileMenu.add(new JSeparator());
        fileMenu.add(exit);

        return fileMenu;
    }

    /**
     * Builds maze menu
     * @return built maze menu
     */
    public JMenu buildMazeMenu() {
        // Maze menu set up
        JMenu mazeMenu = new JMenu("Maze");
        JMenuItem newMaze = new JMenuItem("New Maze");
        newMaze.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        // Add Listeners
        NewMazeOpen mazeOpen = new NewMazeOpen();
        newMaze.addActionListener(mazeOpen);

        // Put together
        mazeMenu.add(newMaze);

        return mazeMenu;
    }

    /**
     * Builds robot menu
     * @return built robot menu
     */
    public JMenu buildRobotMenu() {
        // Robot menu set up
        robotMenu = new JMenu("Robot");
        rightBot = new JMenuItem("Righthand Robot");
        leftBot = new JMenuItem("Lefthand Robot");
        lookBot = new JMenuItem("Look Ahead Robot");
        randBot = new JMenuItem("Random Robot");
        wallHopBot = new JMenuItem("Wall Hop Robot");
        memoryBot = new JMenuItem("Memory Robot");

        // Add Listeners
        ChooseBot choose = new ChooseBot();
        rightBot.addActionListener(choose);
        leftBot.addActionListener(choose);
        lookBot.addActionListener(choose);
        randBot.addActionListener(choose);
        wallHopBot.addActionListener(choose);
        memoryBot.addActionListener(choose);

        // Put together
        robotMenu.add(rightBot);
        robotMenu.add(leftBot);
        robotMenu.add(lookBot);
        robotMenu.add(randBot);
        robotMenu.add(wallHopBot);
        robotMenu.add(memoryBot);

        return robotMenu;
    }

    /**
     * Builds new maze from file.
     */
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
                if (robot == null) {
                    refresh = new Maze(maze);
                    panel.setMaze(maze);
                    message.setText("Choose a robot to help you.");
                } else {
                    refresh = new Maze(maze);
                    robot.setMaze(maze);
                    panel.setRobot(robot);
                    panel.setMaze(maze);
                    panel.requestFocus();
                    panel.setMessage("Have fun!");
                    setFrameSize();
                    showChange();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
            robotMenu.setVisible(true);
        }

    }

    /**
     * Chooses which robot to help solve the maze
     */
    public class ChooseBot implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (robot != null) {
                resetMaze();
            } else {
                add(panel);
                solve.setEnabled(true);
                messPanel.setVisible(false);
                panel.setFocusTraversalKeysEnabled(false);
                panel.addKeyListener(new KeyMoves());
            }

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
            } else if (event.getSource() == wallHopBot) {
                robot = new WallHopRobot(maze);
                panel.setRobot(robot);
            } else {
                robot = new MemoryRobot(maze);
                panel.setRobot(robot);
                showMemory.setVisible(true);
            }

            // Show to user
            panel.paintComponent(getGraphics());
            panel.requestFocus();
            setFrameSize();
        }
    }

    /**
     * Terminates the program
     */
    public class CloseProgram implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }

    /**
     * Takes user through the maze the route the chosen robot would take and
     * puts the user back at current position.
     */
    public class ShowSolution implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            running = true;

            // Get current bot info
            int currentX = robot.currentCol;
            int currentY = robot.currentRow;
            int currentCount = robot.count;
            run();

            // Put back to where bot started
            robot.resetBot(currentY, currentX, currentCount);
            panel.setMessage("Now you solve it with the new tricks!");
            showChange();
        }
    }

    /**
     * Moves robot through maze using the arrow keys.
     */
    public class KeyMoves implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            int thisWay = e.getKeyCode();
            switch (thisWay) {
                case KeyEvent.VK_UP:
                    if (robot.currentRow > 0 && robot.maze.openCell(robot.currentRow - 1, robot.currentCol)) {
                        if (robot instanceof LookAheadRobot) {
                            ((LookAheadRobot) robot).move(0, false);
                        } else {
                            robot.move(0);
                        }
                    } else {
                        panel.setMessage("You can't move there.");
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (robot.currentRow < robot.maze.getRows() && robot.maze.openCell(robot.currentRow + 1, robot.currentCol)) {
                        if (robot instanceof LookAheadRobot) {
                            ((LookAheadRobot) robot).move(1, false);
                        } else {
                            robot.move(1);
                        }
                    } else {
                        panel.setMessage("You can't move there.");
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (robot.currentCol < robot.maze.getCols() && robot.maze.openCell(robot.currentRow, robot.currentCol + 1)) {
                        if (robot instanceof LookAheadRobot) {
                            ((LookAheadRobot) robot).move(3, false);
                        } else {
                            robot.move(3);
                        }

                    } else {
                        panel.setMessage("You can't move there.");
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (robot.currentCol > 0 && robot.maze.openCell(robot.currentRow, robot.currentCol - 1)) {
                        if (robot instanceof LookAheadRobot) {
                            ((LookAheadRobot) robot).move(2, false);
                        } else {
                            robot.move(2);
                        }
                    } else {
                        panel.setMessage("You can't move there.");
                    }
                    break;
                default:
                    if (e.getKeyCode() != KeyEvent.VK_H || e.getKeyCode() != KeyEvent.VK_CONTROL) {
                        panel.setMessage("Please use arrow keys.");
                    }
            }

            // Show move
            showChange();
            if (!robot.solved()) {
                panel.requestFocus();
            } else {
                panel.setMessage("You made it. Try a new maze!");
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }
    }

    public class ShowMemory implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MemoryFrame memory = new MemoryFrame();
        }
    }

    public void run() {
        try {
            int direction = robot.chooseMoveDirection();
            if (direction >=0)  { //invalid direction is -1
                robot.move(direction);
                showChange();
                Thread.sleep(1500);
                if (!robot.solved())
                {
                    run();
                } else {
                    Thread.sleep(3000);
                    running = false;
                }
            }
        } catch (Exception e) {
            panel.setMessage("Error in background.");
        }
    }

    public void resetMaze() {
        maze = new Maze(refresh);
        robot.setMaze(maze);
        panel.setRobot(robot);
        panel.setMessage("Let's do it again!");
    }

    public void showChange() {
        panel.setVisible(false);
        panel.paintComponent(getGraphics()); // repaint was not doing it
        panel.setVisible(true);
    }

    public void setFrameSize() {
        panel.setSize(maze.getCols() * 10, maze.getRows() * 10);
        setSize(maze.getCols() * 30 + 60, maze.getRows() * 30 + 170);
    }

    public static void main(String [] args) {
        MazeFrame runMaze = new MazeFrame();
        runMaze.setUp();
    }
}
