package com.casino.games.slotgames;


/**
 * Implementation of the Bonus Game.
 * 
 * @author imetaxas
 *
 */
public class BonusGameImpl extends AbstractGame {
	
	/**
	 * Number of boxes of the box-picking level
	 */
	private static final int NUMBER_OF_BOXES = 5;
	
	/**
	 * Constructor 
	 * 
	 * @param randomStrategy
	 * @param statistics
	 */
	public BonusGameImpl(RandomStrategy randomStrategy, Statistics statistics) {
		super.setRandomStrategy(randomStrategy);
		super.setStatistics(statistics);
		super.setWinningCoinsPerEvent(5);
		super.setPercentageChanceToTriggerEvent(0.1);
		super.setPlayingCoinsPerRound(10);
	}

	/**
	  * {@inheritDoc}
	  */
	@Override
	public void playGameRounds(int numberOfRounds) {
		for (int i = 0; i < numberOfRounds; i++){
			getStatistics().incrementStat("playing coins", getPlayingCoinsPerRound());
			
			//pick a chance for starting a bonus game
			double chanceFactor = getRandomStrategy().nextDouble();
			
			//test if the chance triggers the box-picking level
			if (chanceFactor <= getPercentageChanceToTriggerEvent()){
				getStatistics().incrementStat("bonus games", 1);
				setEventTriggered(true);
				int currentNumberOfBoxes = NUMBER_OF_BOXES;
				//start picking boxes
				while(currentNumberOfBoxes - 1 > 0 && isEventTriggered()){
					getStatistics().incrementStat("boxes tried", 1);
					//pick a chance for picking a box
					chanceFactor = getRandomStrategy().nextDouble();
					double pecentageChanceToWin = ((double)(currentNumberOfBoxes - 1) / currentNumberOfBoxes);
					setPecentageChanceToWin(pecentageChanceToWin);
					//test if the chance opens a box successfully
					if(chanceFactor <= getPecentageChanceToWin()){
						getStatistics().incrementStat("boxes succeded", 1);
						getStatistics().incrementStat("winning coins", getWinningCoinsPerEvent());
						currentNumberOfBoxes--;
					}else{
						//chance to open a box has failed
						getStatistics().incrementStat("boxes failed", 1);
						setEventTriggered(false);
					}
				}
			}else{
				//chance to trigger the box-picking level has failed
				getStatistics().incrementStat("direct losses", 1);
			}
    	}
	}
}
