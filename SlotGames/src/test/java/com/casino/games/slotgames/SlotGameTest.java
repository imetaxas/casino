package com.casino.games.slotgames;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/** 
 * JUnit test class for testing the SlotGameTest class.
 *
 * @author Ioannis Metaxas
 * @version 1.0
 * @since 1.0
 * @see <a href="http://junit.org/">JUnit tests</a>
*/
public final class SlotGameTest {
	
	private static final int GAME_ROUNDS = 1_000_000;
	private static final double ACCEPTED_RTP_PERC_WITH_RANDOM_MERSENNE_TWISTER64 = 0.67;
	
	private Statistics stats;
	private Game game;
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(SlotGameTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println("Failure: " + failure.toString());
		}
		System.out.println("Was successful: " + result.wasSuccessful());
	}
	
	@Before
    public void simulateGameRounds() throws Exception {
		
		stats = new SlotGameStats();
		stats.addStatistic("wins", 0, 1);
		stats.addStatistic("losses", 0, 2);
		stats.addStatistic("playing coins", 0, 3);
		stats.addStatistic("winning coins", 0, 4);
		stats.addStatistic("free rounds", 0, 5);
		
		RandomStrategy randomizer = new RandomMersenneTwister64(new Date());
		
		game = new SlotGameImpl(randomizer, stats);
		game.playGameRounds(GAME_ROUNDS);
		
    }
	
	@Test
    public void assertEqualsNumberOfRounds(){
		
		int wins = stats.getStatisticValue("wins").intValue();
		int losses = stats.getStatisticValue("losses").intValue();
		int freeRounds = stats.getStatisticValue("free rounds").intValue();
		
		assertEquals(wins + losses - freeRounds, GAME_ROUNDS);
	}
	
	@Test
    public void assertEqualsNumberOfPlayingCoins(){
		int playingCoins = stats.getStatisticValue("playing coins").intValue();
		
		assertEquals(playingCoins, GAME_ROUNDS * game.getPlayingCoinsPerRound());
	}
	
	@Test
    public void assertEqualsNumberOfWinningCoins(){
		int winningCoins = stats.getStatisticValue("winning coins").intValue();
		int wins = stats.getStatisticValue("wins").intValue();
		
		assertEquals(winningCoins, wins * game.getWinningCoinsPerEvent());
	}
	
	@Test
    public void assertRTPLessThanConstantWithRandomMersenneTwister64(){
		double winningCoins = stats.getStatisticValue("winning coins").doubleValue();
		double playingCoins = stats.getStatisticValue("playing coins").doubleValue();
		double RTP = winningCoins / playingCoins;
		
		assertThat(RTP, lessThan(ACCEPTED_RTP_PERC_WITH_RANDOM_MERSENNE_TWISTER64));
	}
	
}
