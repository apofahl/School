package homework5;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

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
    JMenuItem randBot;
    JMenuItem wallHopBot;

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
            running = true;
            try {
                for (int count = 0; count < 1000000 && !robot.solved(); count++) {
                    int direction = robot.chooseMoveDirection();
                    if (direction >=0)  { //invalid direction is -1
                        robot.move(direction);
                        panel.setVisible(false);
                        panel.paintComponent(getGraphics()); // need to find a way to show new maze
                        panel.setVisible(true);
                    }
                    Thread.sleep(1500);
                }
            } catch (Exception e) {

            }
        }
    }

    public class MouseMoves implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            panel.getToolTipLocation(e);
            System.out.println(e.getPoint());

        //    https://www.youtube.com/watch?v=p9Y-NBg8eto
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
