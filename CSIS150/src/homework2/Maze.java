package homework2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class Maze {
	
	private static final int MARK_LIMIT = 3200;
	private int [ ] start;
	private int [ ] end;
	private char [ ] [ ] maze;
	
	public Maze() {
		start = new int [2];
		end = new int [2];
	}
	
	public Maze(File inFile){
        start = new int [2];
        end = new int [2];
	       if(inFile.exists()) {    
	           try {
	        	   // begin building maze
	               BufferedReader inReader = new BufferedReader(new FileReader(inFile));
	               inReader.mark(MARK_LIMIT);
	               String fileLine = inReader.readLine();
	               Scanner topScan = new Scanner(fileLine);
	               maze = new char[topScan.nextInt()] [topScan.nextInt()];
	               // fill start
	               fileLine = inReader.readLine();
                   topScan = new Scanner(fileLine);
	               for (int dex = 0; dex < 2; dex++) {
	            	   start [dex] = topScan.nextInt();
	               }
	               // fill end
	               fileLine = inReader.readLine();
                   topScan = new Scanner(fileLine);
	               for (int dex = 0; dex < 2; dex++) {
	            	   end [dex] = topScan.nextInt();
	               }
	               // fill maze
	               for(int rows = 0;rows < maze.length; rows++) {
	                    fileLine = inReader.readLine();
                       topScan = new Scanner(fileLine);
	                    for(int cols = 0; cols < maze[rows].length; cols++) {   
	                        maze[rows] [cols] = fileLine.charAt(cols);
	                    }
	               }
	               
	               topScan.close();
	               inReader.close();
	               
	           }	catch(IOException e) {
	        	   JOptionPane.showMessageDialog(null, "Error reading file: " +inFile+ "/n/nTry using a correctly formatted file. ;)");
	           }
	       }
	}
	
	public Maze(Maze copy) {
		start = copy.getStart();
		end = copy.getExit();
        maze = new char [copy.getRows()] [copy.getCols()];
        for(int row = 0;row < copy.getRows(); row++) {
            for(int col = 0; col < copy.getCols(); col++) {
                setCell(row, col, copy.getCell(row, col));
            }
       }
	}
	
	public int getRows() {
		return maze.length;
	}
	
	public int getCols() {
		return maze[0].length;
	}
	
	public int [ ] getStart() {
		return start;
	}
	
	public int getStartRow() {
		return start [0];
	}
	
	public int getStartCol() {
		return start [1];
	}
	
	public int [ ] getExit() {
		return end;
	}
	
	public int getExitRow() {
		return end [0];
	}
	
	public int getExitCol() {
		return end [1];
	}
	
	public char getCell(int row, int col) {
		return maze [row] [col];
	}
	
	public boolean openCell(int row, int col) {
		boolean open = false;
		if (maze [row] [col] == ' ' || maze [row] [col] == 'X') {
			open = true;
		}
		
		return open;
	}
	
	public void setCell(int row, int col, char newChar) {
           maze [row] [col] = newChar;
	}
	
	public String toString() {
		String output = "";
		
		for(int row = 0; row < maze.length; row++){
			for(int col = 0; col < maze[row].length; col++) {
				output += maze [row] [col];
			}
            output += "\n";
		}
		
		return output;
	}
}
