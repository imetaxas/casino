package com.casino.games.slotgames;


/**
 * Implementation of the Slot Game.
 * 
 * @author imetaxas
 *
 */
public class SlotGameImpl extends AbstractGame {

	/**
	 * Constructor 
	 * 
	 * @param randomStrategy
	 * @param statistics
	 */
    public SlotGameImpl(RandomStrategy randomStrategy, Statistics statistics) {
		super.setRandomStrategy(randomStrategy);
		super.setStatistics(statistics);
		super.setPecentageChanceToWin(0.3);
		super.setWinningCoinsPerEvent(20);
		super.setPercentageChanceToTriggerEvent(0.1);
		super.setPlayingCoinsPerRound(10);
	}

    /**
	  * {@inheritDoc}
	  */
	@Override
    public void playGameRounds(int numberOfRounds){
		int i = 0;
		
		//play for as long there are both paid and free rounds
		while (i < numberOfRounds || isEventTriggered()){
			if(!isEventTriggered()){
				//paid round
				getStatistics().incrementStat("playing coins", getPlayingCoinsPerRound());
				i++;
			}else{
				//free round
				setEventTriggered(false);
			}
			
			//pick a chance for winning a free round
			double chanceFactor = getRandomStrategy().nextDouble();
			
			//test if the chance gives a free next round
			if (chanceFactor <= getPercentageChanceToTriggerEvent()){
				setEventTriggered(true);
				getStatistics().incrementStat("free rounds", 1);
			}
			
			//test if the chance wins coins
			if (chanceFactor <= getPecentageChanceToWin()){
				getStatistics().incrementStat("winning coins", getWinningCoinsPerEvent());
				getStatistics().incrementStat("wins", 1);
			}else{
				getStatistics().incrementStat("losses", 1);
			}
    	}
    }
	
}
