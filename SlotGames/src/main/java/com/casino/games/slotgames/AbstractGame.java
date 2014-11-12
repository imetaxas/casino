package com.casino.games.slotgames;

/**
 * Abstract class used as a super class of a game.
 * 
 * @author imetaxas
 *
 */
public abstract class AbstractGame implements Game {
	
	/**
	 * Stores the percentage chance to win
	 */
	private double pecentageChanceToWin;
	
	/**
	 * Stores the percentage chance to trigger an event
	 */
	private double percentageChanceToTriggerEvent;
	

	/**
	 * Stores the winning coins per event
	 */
	private int winningCoinsPerEvent;
	

	/**
	 * Stores the playing coins per round
	 */
	private int playingCoinsPerRound;
	
	/**
	 * Stores the strategy for getting random numbers
	 */
	private RandomStrategy randomStrategy;
	
	/**
	 * Stores the games statistics
	 */
	private Statistics statistics;
	
	/**
	 * Stores if an event is triggered
	 */
	private boolean isEventTriggered = false;
	
	/**
	  * {@inheritDoc}
	  */
	@Override
	public Statistics getStatistics() {
		return statistics;
	}
	
	/**
	  * {@inheritDoc}
	  */
	@Override
	public RandomStrategy getRandomStrategy() {
		return randomStrategy;
	}
	
	/**
	  * {@inheritDoc}
	  */
	@Override
	public int getPlayingCoinsPerRound() {
		return playingCoinsPerRound;
	}
	
	/**
	  * {@inheritDoc}
	  */
	@Override
	public double getPercentageChanceToTriggerEvent(){
		return percentageChanceToTriggerEvent;
	}
	
	/**
	  * {@inheritDoc}
	  */
	@Override
	public double getPecentageChanceToWin() {
		return pecentageChanceToWin;
	}
	
	/**
	  * {@inheritDoc}
	  */
	@Override
	public int getWinningCoinsPerEvent(){
		return winningCoinsPerEvent;
	}
	
	/**
	 * Sets the percentage chance to win
	 */
	public void setPecentageChanceToWin(double pecentageChanceToWin) {
		this.pecentageChanceToWin = pecentageChanceToWin;
	}
	
	/**
	 * Indicates if an event is triggered
	 */
	public boolean isEventTriggered() {
		return isEventTriggered;
	}

	/**
	 * Sets the playing coins per round
	 */
	public void setPlayingCoinsPerRound(int coins) {
		this.playingCoinsPerRound = coins;
	}

	/**
	 * Sets the percentage chance to trigger an event
	 */
	public void setPercentageChanceToTriggerEvent(double chance) {
		this.percentageChanceToTriggerEvent = chance;
	}
	
	/**
	 * Sets if an event is triggered
	 */
	public void setEventTriggered(boolean isEventTriggered) {
		this.isEventTriggered = isEventTriggered;
	}

	/**
	 * Sets the game's strategy for getting random numbers
	 */
	public void setRandomStrategy(RandomStrategy randomStrategy) {
		this.randomStrategy = randomStrategy;
	}

	/**
	 * Sets the game's statistics
	 */
	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
	
	/**
	 * Sets the winning coins per event
	 */
	public void setWinningCoinsPerEvent(int coins){
		this.winningCoinsPerEvent = coins;
	}
	
}
