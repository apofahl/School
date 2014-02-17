package homework1;

public class Player {
	
	private String playerName;
	private String playerSign;
	private int gamesWon;

	/**
	 * Makes a default player
	 */
	public Player() {
		playerName = "Player X";
		playerSign = "X";
		gamesWon = 0;
	}
	
	/**
	 * Makes player from given variables
	 * @param name (name they would like to be called)
	 * @param sign (what they want to mark the board with)
	 */
	public Player(String name, String sign) {
		playerName = name;
		playerSign = sign;
		gamesWon = 0;
	}
	
	/**
	 * Adds a tally to the winner board
	 */
	public void playerWin() {
		gamesWon++;
	}

    /**
     * Asks for the amount of games won by player
     * @return (number of games won)
     */
    public int getGamesWon() {
        return gamesWon;
    }
	
	/**
	 * Asks for the player's name
	 * @return (name they would like to be called)
	 */
	public String getPlayerName() {
		return playerName;	
	}
	
	/**
	 * Asks for the player's sign
	 * @return (what they want to mark the board with)
	 */
	public String getPlayerSign() {
		return playerSign;	
	}

    /**
     * Resets a player's name
     * @param newName (new name to be called)
     */
    public void setPlayerName(String newName) {
        playerName = newName;
    }

    /**
     * Resets a player's sign
     * @param newSign (new sign to use for marking)
     */
    public void setPlayerSign(String newSign) {
        playerSign = newSign;
    }

    /**
	 * Prints out player's info.
	 */
	public String toString() {
		return playerName+ " (marked by " +playerSign+ "'s) has won " +gamesWon+ " games!";	
	}

}