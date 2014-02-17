package homework1;

import javax.swing.JOptionPane;

public class GameDriver {
	
	/**
	 * It is just getting a name to call the player throughout the game
	 * @param input makes the statement unique to the player
	 * @return name player will be called through the game
	 */
	public static String setUpPlayer(String input)
	{
		String name = JOptionPane.showInputDialog("What is " +input+ " gamer name?");
		
		return name;
	}
	/**
	 * It calls the name of the player who's turn it is
	 * @param player what player are we talking about?
	 * @return the player's name in the game
	 */
	public static String whosMove(Player player)
	{
		String name = player.getPlayerName();
		
		return name;
	}

	/**
	 * This program set up and plays a game of Tic Tac Toe.
	 * 
	 *  Author: Abi Pofahl
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Set up Variables
		int playAgain = 0;
		Player player1 = new Player(setUpPlayer("your"), "X");
		Player player2 = new Player(setUpPlayer("the other"), "O");
		Player cat = new Player("Cat", "-");
		
		while(playAgain == 0) {
			// Set up the board and such
			Board gameBoard = new Board();
			Player winner = player1;
			boolean win = false;
			String anything = "";
			int index = 1;
		
			// The actual playing the game part
			while (win == false) {
				String turn;
				Player player;
			
				if (index%2 != 0) {
					turn = whosMove(player1);
					player = player1;
				}
				else {
					turn = whosMove(player2);
					player = player2;
				}
				index++;
			
				// Now we will take turns
				String place = JOptionPane.showInputDialog(gameBoard+ "\n" +anything+ "\nWhere would you like to make your move " +turn+ "?");
				anything = gameBoard.playerMove(player, place);
			
				if (anything.compareTo("Invalid place. Choose again.") == 0) 	{
					index--;
				}
				
				win = gameBoard.checkForWinner();  // Check for win
				
				if (win == true) {
					winner = player;
					player.playerWin();
				} else if (index > 9) { // Check for cat game
					winner = cat;
					cat.playerWin();
					win = true;
				}
				
			}
		
			JOptionPane.showMessageDialog(null, "The game is won by " +winner.getPlayerName()+ "!");
			playAgain = JOptionPane.showConfirmDialog(null,"The scores are:\n" +player1.getPlayerName()+
							": " +player1.getGamesWon()+ "\n" +player2.getPlayerName()+ ": " +player2.getGamesWon()+
							"\n" +cat.getPlayerName()+ ": " +cat.getGamesWon()+ "\nWould you like to play again?");
		}
		
		JOptionPane.showMessageDialog(null, "Thanks for playing! <3 Abi");
		
	}

}
