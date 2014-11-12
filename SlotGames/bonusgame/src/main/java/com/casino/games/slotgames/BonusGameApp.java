package com.casino.games.slotgames;

import java.util.Date;


/**
 * Main class for running bonus games as an application
 * 
 * @author imetaxas
 *
 */
public final class BonusGameApp {
	
	private BonusGameApp(){}
	
	/**
	 * The Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Number of simulated game rounds
		int GAME_ROUNDS = 1000000;
		
		//Create the Bonus game's statistics
		Statistics stats = new BonusGameStats();
		stats.addStatistic("direct losses", 0, 1);
		stats.addStatistic("playing coins", 0, 2);
		stats.addStatistic("winning coins", 0, 3);
		stats.addStatistic("bonus games", 0, 4);
		stats.addStatistic("boxes tried", 0, 5);
		stats.addStatistic("boxes succeded", 0, 6);
		stats.addStatistic("boxes failed", 0, 7);
		
		//Create a randomizer with a seed
		RandomStrategy randomizer = new RandomMersenneTwister64(new Date());
		
		//Create the Bonus game
		Game game = new BonusGameImpl(randomizer, stats);
		
		//Play the game
		game.playGameRounds(GAME_ROUNDS);
		
		//Print the statistics
		game.getStatistics().printStatistics(System.out);
		
	}

	

}
