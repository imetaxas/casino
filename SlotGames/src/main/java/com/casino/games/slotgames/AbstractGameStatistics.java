package com.casino.games.slotgames;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract class used as a super class of statistics.
 * 
 * @author imetaxas
 *
 */
public abstract class AbstractGameStatistics implements Statistics {
	
	/**
	 * Stores all the statistics as a map
	 */
	private Map<String, StatisticAttribute> statistics;
	
	/**
	  * {@inheritDoc}
	  */
	@Override
	public <T extends Number> void addStatistic(String name, Number value) {
		addStatistic(name, value, Integer.MAX_VALUE);
	}
	
	/**
	  * {@inheritDoc}
	  */
	@Override
	public <T extends Number> void addStatistic(String name, Number value, int printOrder) {
		if(statistics == null){
			statistics = new HashMap<>();
		}
		statistics.put(name, new StatisticAttribute(name, value, printOrder));
	}
	
	/**
	  * {@inheritDoc}
	  */
	@Override
	public Collection<StatisticAttribute> getStatistics() {
		return statistics.values();
	}
	
	/**
	  * {@inheritDoc}
	  */
	@Override
	public Number getStatisticValue(String name) {
		return statistics.get(name).getValue();
	}
	
	/**
	  * {@inheritDoc}
	  */
	@Override
	public void incrementStat(String name, Number addValue) {
		
		StatisticAttribute attr = statistics.get(name);
		Number value = attr.getValue();
		int printOrder = attr.getPrintOrder();
		if(value instanceof Byte){
			value = value.byteValue() + addValue.byteValue();
		}else if(value instanceof Short){
			value = value.shortValue() + addValue.shortValue();
		}else if(value instanceof Integer){
			value = value.intValue() + addValue.intValue();
		}else if(value instanceof Long){
			value = value.longValue() + addValue.longValue();
		}else if(value instanceof Float){
			value = value.floatValue() + addValue.floatValue();
		}else if(value instanceof Double){
			value = value.doubleValue() + addValue.doubleValue();
		}else if(value instanceof BigInteger){
			BigInteger valueBigInt = new BigInteger(value.toString());
			BigInteger addValueBigInt = new BigInteger(addValue.toString());
			value = valueBigInt.add(addValueBigInt);
		}else {
			BigDecimal valueDec = new BigDecimal(value.toString());
			BigDecimal addValueDec = new BigDecimal(addValue.toString());
			value = valueDec.add(addValueDec);
		}
		
		statistics.put(name, new StatisticAttribute(name, value, printOrder));
	}
	
	/**
	  * {@inheritDoc}
	  */
	@Override
	public void printStatistics(PrintStream out){
		List<StatisticAttribute> stats = new ArrayList<>(getStatistics());
		Collections.sort(stats, new StatisticAttribute());
		for(StatisticAttribute att: stats){
			out.println(att);
		}
	}
	
}
