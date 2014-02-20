package homework1;

public class Board {

	private String [ ] [ ] board;
									 
	/**
	 * Create the board on which the game will be played.
	 */
	public Board() 	{
        board  = new String [3] [3];
        int count = 1;
        
        for(int row = 0; row < board.length; row++)  {
        	for(int col = 0; col < board[row].length; col++)  {
        		board[row] [col] = "" +count++;
            }
        }
	}
	
	/**
	 * Makes the move if applicable.
	 * @param player (the player that will be making the move)
	 * @param place (the place which the player wishes to move)
	 * @return (a string that either validates the move or tells them to pick again)
	 */
	public String playerMove(Player player, String place) 	{
		String output = "Invalid place. Choose again.";

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (place.equals(board [row] [col])) {
                    board [row] [col] = player.getPlayerSign();
                    output = "Good choice!";
                }
            }
        }
		
		return output;
	}
	
	/**
	 * Decides whether the game is won or if we should keep playing
	 * @return (true if the game is won and false if they should keep playing)
	 */
	public boolean checkForWinner()
	{
		int xCount;
		int oCount;
		boolean win = false;
		
		// Check vertical
		for (int row = 0; row < 3; row++) {
			xCount = oCount = 0;
			for (int col = 0; col < 3; col++) {
				if (board [row] [col].compareTo("O") == 0) {
					oCount++;
				}
				if (board [row] [col].compareTo("X") == 0) {
					xCount++;
				}
			}
			if (xCount == 3 || oCount == 3) {
				win = true;
			}
		}
		
		// Check horizontal
		for (int col = 0; col < 3; col++) {
			xCount = oCount = 0;
			for (int row = 0; row < 3; row++) {
				if (board [row] [col].equals("O")) {
					oCount++;
				}
				if (board [row] [col].equals("X")) {
					xCount++;
				}
			}
			if (xCount == 3 || oCount == 3) {
				win = true;
			}
		}
		
		xCount = oCount = 0;
		
		// Check diagonal
		for (int dex = 0; dex < 3; dex++) {
			if (board [dex] [dex].equals("O")) {
				oCount++;
			}
			if (board [dex] [dex].equals("X")) {
				xCount++;
			}
		}
		if (xCount == 3 || oCount == 3) {
			win = true;
		}
		
		xCount = oCount = 0;

		// Check anti-diagonal
		for (int dex = 0; dex < 3; dex++) {
			if (board [dex] [2-dex].compareTo("O") == 0) {
				oCount++;
			}
			if (board [dex] [2-dex].compareTo("X") == 0) {
				xCount++;
			}
		}
		if (xCount == 3 || oCount == 3) {
			win = true;
		}
		
		return win;
	}
	
	/**
	 * Prints the board so the players can see what is happening
	 */
	public String toString() {
		String gameBoard = "";
		
		for(int row = 0; row < board.length; row++) {
        	for(int col = 0; col < board[row].length; col++)  {
        		if (col != 2) {
        			gameBoard += board[row] [col]+ "   |    ";
        		}
        		else {
        			gameBoard += board[row] [col];
        		}
            }
        	
    		if (row != 2) {
    			gameBoard += "\n--- + ---- + ---- \n";
    		}
    		
        }
		
		return gameBoard;
	}

}
