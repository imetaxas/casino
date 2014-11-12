package com.casino.games.slotgames;

import java.util.Date;

import cern.jet.random.engine.MersenneTwister64;

/**
 * Class for generating 64-bit random numbers using the Random Mersenne Twister pseudo-random number generator.
 * 
 * It DOES passes the Marsaglia’s Diehard Battery of Tests of Randomness.
 * 
 * @author imetaxas
 *
 */
public class RandomMersenneTwister64 implements RandomStrategy {
	
	/**
	 * Stores an instance of the MersenneTwister64 class 
	 */
	private MersenneTwister64 inst;
	
	/**
	 * Constructor
	 */
	public RandomMersenneTwister64(){
		inst = new MersenneTwister64();
	}
	
	/**
	 * Constructor with a seed
	 */
	public RandomMersenneTwister64(int seed){
		inst = new MersenneTwister64(seed);
	}
	
	/**
	 * Constructor with a Date object as seed
	 */
	public RandomMersenneTwister64(Date date){
		inst = new MersenneTwister64(date);
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
