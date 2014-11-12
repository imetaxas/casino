package com.casino.games.slotgames;

import java.util.Comparator;

/**
 * Defines a statistic attribute
 * 
 * @author imetaxas
 *
 */
public class StatisticAttribute implements Comparator<StatisticAttribute>{
	
	/**
	 * Stores the name
	 */
	private String name;
	
	/**
	 * Stores the value
	 */
	private Number value;
	
	/**
	 * Stores the printing order
	 */
	private int printOrder;
	
	/**
	 * Constructor used by the comparator for sorting the attributes
	 */
	public StatisticAttribute() {}
	
	/**
	 * Constructor for creating new attributes with a name and a value
	 * 
	 * @param name
	 * @param value
	 */
	public StatisticAttribute(String name, Number value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * Constructor for creating new attributes with a name, a value and a printing order
	 * 
	 * @param name
	 * @param value
	 * @param printOrder
	 */
	public StatisticAttribute(String name, Number value, int printOrder) {
		this.name = name;
		this.value = value;
		this.printOrder = printOrder;
	}
	
	/**
	 * Returns the value
	 * 
	 * @return the value
	 */
	public Number getValue() {
		return value;
	}

	/**
	 * Returns the print order
	 * 
	 * @return the print order
	 */
	public int getPrintOrder(){
		return printOrder;
	}
	
	
	@Override
	public String toString() {
		return name + ": " + value.toString();
	}

	@Override
	public int compare(StatisticAttribute attr1, StatisticAttribute attr2) {
		return attr1.getPrintOrder() - attr2.getPrintOrder();
	}

}
