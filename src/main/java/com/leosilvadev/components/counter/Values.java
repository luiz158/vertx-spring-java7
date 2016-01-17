package com.leosilvadev.components.counter;

public class Values {

	private final Double valueOne;
	private final Double valueTwo;
	
	public Values(Double valueOne, Double valueTwo) {
		super();
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
	}

	public Double getValueOne() {
		return valueOne;
	}

	public Double getValueTwo() {
		return valueTwo;
	}
	
	public Double sum(){
		return valueOne + valueTwo;
	}

}
