package com.casino.games.slotgames;

import java.util.Random;

/**
 * Class for generating random numbers using the uniform Gaussian distribution
 * 
 * Not a good distribution for this purpose since it does not pass the
 * Marsaglia’s Diehard Battery of Tests of Randomness
 * 
 * @author imetaxas
 *
 */
public class RandomGaussian implements RandomStrategy {
	
	/**
	 * Stores an instance of the Random class 
	 */
	private Random inst;
	
	/**
	 * Constructor
	 */
	public RandomGaussian(){
		inst = new Random();
	}
	
	/**
	 * Constructor with a seed
	 */
	public RandomGaussian(long seed){
		inst = new Random(seed);
	}
	
	/**
	  * {@inheritDoc}
	  * 
	  */
	@Override
	public double nextDouble() {
		return Math.abs(inst.nextGaussian());
	}

}
