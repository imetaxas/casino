package com.casino.games.slotgames;

import java.io.PrintStream;
import java.util.Collection;

/**
 * Interface for defining the statistics of a game.
 * 
 * @author imetaxas
 *
 */
public interface Statistics {
	
	/**
	 * Adds a new statistic
	 * 
	 * @param name
	 * @param value
	 */
	<T extends Number> void addStatistic(String name, Number value);
	
	/**
	 * Adds a new statistic with its printing order
	 * 
	 * @param name
	 * @param value
	 * @param printOrder
	 */
	<T extends Number> void addStatistic(String name, Number value, int printOrder);
	
	/**
	 * Returns a collection with all the statistics
	 * 
	 * @return a collection with all the statistics
	 */
	Collection<?> getStatistics();
	
	/**
	 * Returns the value of the statistic with the given name
	 * 
	 * @param name
	 * @return the value of the statistic with the given name
	 */
	Number getStatisticValue(String name);
	
	/**
	 * Increments the statistic with the given name by a given value
	 * 
	 * @param name
	 * @param addValue
	 */
	void incrementStat(String name, Number addValue);
	
	/**
	 * Prints all the statistics to a given output
	 * 
	 * @param out
	 */
	void printStatistics(PrintStream out);
	
	/**
	 * Prints the Return To Player (RTP) factor
	 * 
	 * @param out
	 */
	void printReturnToPlayer(PrintStream out);
	
}
