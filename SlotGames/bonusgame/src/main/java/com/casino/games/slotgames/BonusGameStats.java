package com.casino.games.slotgames;

import java.io.PrintStream;

/**
 * Class used for collecting statistics for the bonus game.
 * 
 * @author imetaxas
 *
 */
public class BonusGameStats extends AbstractGameStatistics {
	
	/**
	  * {@inheritDoc}
	  * 
	  */
	@Override
	public void printReturnToPlayer(PrintStream out){
		double winningCoins = super.getStatisticValue("winning coins").doubleValue();
		double playingCoins = super.getStatisticValue("playing coins").doubleValue();
		out.println("Return To Player (RTP): " + Math.abs(winningCoins / playingCoins));
	}
	
	/**
	  * {@inheritDoc}
	  * 
	  * More specific method for printing statistics for the Bonus game
	  */
	@Override
	public void printStatistics(PrintStream out){
		super.printStatistics(out);
		
		out.println();
		
		printReturnToPlayer(out);
	}
}
