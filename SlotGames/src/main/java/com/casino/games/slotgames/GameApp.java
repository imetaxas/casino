package com.casino.games.slotgames;

import java.util.Date;

/**
 * Main class for running games as an application
 * 
 * @author imetaxas
 *
 */
public final class GameApp {
	
	private GameApp(){}
	
	/**
	 * The Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Number of simulated game rounds
		int GAME_ROUNDS = 1_000_000;
		
		System.out.println("SlotGame results after " + GAME_ROUNDS + " rounds:");
		System.out.println("----------------------------------------");
		
		//Create the Slot game's statistics
		Statistics stats = new SlotGameStats();
		stats.addStatistic("wins", 0, 1);
		stats.addStatistic("losses", 0, 2);
		stats.addStatistic("playing coins", 0, 3);
		stats.addStatistic("winning coins", 0, 4);
		stats.addStatistic("free rounds", 0, 5);
		
		//Create a randomizer
		RandomStrategy randomizer = new RandomMersenneTwister64(new Date());
		
		//Create the Slot game
		Game game1 = new SlotGameImpl(randomizer, stats);
		
		//Play the game
		game1.playGameRounds(GAME_ROUNDS);
		
		//Print the statistics
		game1.getStatistics().printStatistics(System.out);
		
		System.out.println("-----------------");
		
		System.out.println("\nBonusGame results after " + GAME_ROUNDS + " rounds:");
		System.out.println("----------------------------------------");
		
		//Create the Bonus game's statistics
		stats = new BonusGameStats();
		stats.addStatistic("direct losses", 0, 1);
		stats.addStatistic("playing coins", 0, 2);
		stats.addStatistic("winning coins", 0, 3);
		stats.addStatistic("bonus games", 0, 4);
		stats.addStatistic("boxes tried", 0, 5);
		stats.addStatistic("boxes succeded", 0, 6);
		stats.addStatistic("boxes failed", 0, 7);
		
		//Create a randomizer with a new seed
		randomizer = new RandomMersenneTwister64(new Date());
		
		//Create the Bonus game
		Game game2 = new BonusGameImpl(randomizer, stats);
		
		//Play the game
		game2.playGameRounds(GAME_ROUNDS);
		
		//Print the statistics
		game2.getStatistics().printStatistics(System.out);

	}

}
