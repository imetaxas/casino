package com.casino.games.slotgames;

import java.io.PrintStream;

/**
 * Class used for collecting statistics for the slot game.
 * 
 * @author imetaxas
 *
 */
public class SlotGameStats extends AbstractGameStatistics {
	
	/**
	  * {@inheritDoc}
	  * 
	  */
	@Override
	public void printReturnToPlayer(PrintStream out){
		out.println();
		double winningCoins = super.getStatisticValue("winning coins").doubleValue();
		double playingCoins = super.getStatisticValue("playing coins").doubleValue();
		out.println("Return To Player (RTP): " + winningCoins / playingCoins);
	}
	
	/**
	  * {@inheritDoc}
	  * 
	  * More specific method for printing statistics for the Slot game
	  */
	@Override
	public void printStatistics(PrintStream out){
		super.printStatistics(out);
		
		out.println();
		
		double wins = super.getStatisticValue("wins").doubleValue();
		double losses = super.getStatisticValue("losses").doubleValue();
		double numberOfRounds = wins + losses;
		out.println("Winning percentage: " + wins / numberOfRounds );
		
		double freeRounds = super.getStatisticValue("free rounds").doubleValue();
		out.println("Free rounds percentage: " + freeRounds / numberOfRounds );
		
		printReturnToPlayer(out);
	}
	
}
