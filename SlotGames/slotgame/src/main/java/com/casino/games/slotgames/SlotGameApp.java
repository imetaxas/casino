package com.casino.games.slotgames;

import java.util.Date;


/**
 * Main class for running slot games as an application
 * 
 * @author imetaxas
 *
 */
public final class SlotGameApp {
	
	private SlotGameApp(){}
	
	/**
	 * The Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Number of simulated game rounds
		int GAME_ROUNDS = 1000000;
		
		//Create the Slot game's statistics
		Statistics stats = new SlotGameStats();
		stats.addStatistic("wins", 0, 1);
		stats.addStatistic("losses", 0, 2);
		stats.addStatistic("playing coins", 0, 3);
		stats.addStatistic("winning coins", 0, 4);
		stats.addStatistic("free rounds", 0, 5);
		
		//Create a randomizer with a seed
		RandomStrategy randomizer = new RandomMersenneTwister64(new Date());
		
		//Create the Slot game
		Game game = new SlotGameImpl(randomizer, stats);
		
		//Play the game
		game.playGameRounds(GAME_ROUNDS);
		
		//Print the statistics
		game.getStatistics().printStatistics(System.out);
		
	}
	
	
}
