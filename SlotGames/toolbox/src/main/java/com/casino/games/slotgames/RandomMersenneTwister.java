package com.casino.games.slotgames;

import java.util.Date;

import cern.jet.random.engine.MersenneTwister;

/**
 * Class for generating 32-bit random numbers using the Random Mersenne Twister pseudo-random number generator.
 * 
 * It DOES passes the Marsaglia’s Diehard Battery of Tests of Randomness.
 * 
 * @author imetaxas
 *
 */
public class RandomMersenneTwister implements RandomStrategy {
	
	/**
	 * Stores an instance of the MersenneTwister class 
	 */
	private MersenneTwister inst;
	
	/**
	 * Constructor
	 */
	public RandomMersenneTwister(){
		inst = new MersenneTwister();
	}
	
	/**
	 * Constructor with a seed
	 */
	public RandomMersenneTwister(int seed){
		inst = new MersenneTwister(seed);
	}
	
	/**
	 * Constructor with a Date object as seed
	 */
	public RandomMersenneTwister(Date date){
		inst = new MersenneTwister(date);
	}
	
	/**
	  * {@inheritDoc}
	  * 
	  */
	@Override
	public double nextDouble() {
		return inst.nextDouble();
	}
}
