package com.casino.games.slotgames;

/**
 * Interface for defining a game
 * 
 * @author imetaxas
 *
 */
public interface Game {
	
	/**
	 * Simulate a number of game rounds
	 * 
	 * @param numberOfRounds
	 */
	void playGameRounds(int numberOfRounds);
	
	/**
	 * Returns the game's statistics
	 * 
	 * @return the game's statistics
	 */
	Statistics getStatistics();
	
	/**
	 * Returns the winning coins per event
	 * 
	 * @return the winning coins per event
	 */
	int getWinningCoinsPerEvent();
	
	/**
	 * Returns the playing coins per round
	 * 
	 * @return the playing coins per round
	 */
	int getPlayingCoinsPerRound();
	
	/**
	 * Returns the percentage chance to trigger an event
	 * 
	 * @return the percentage chance to trigger an event
	 */
	double getPercentageChanceToTriggerEvent();
	
	/**
	 * Returns the percentage chance to win
	 * 
	 * @return the percentage chance to win
	 */
	double getPecentageChanceToWin();
	
	/**
	 * Returns the game's strategy for getting random numbers
	 * 
	 * @return the game's strategy for getting random numbers
	 */
	RandomStrategy getRandomStrategy();
	
}
