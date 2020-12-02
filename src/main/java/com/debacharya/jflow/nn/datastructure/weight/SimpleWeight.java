package com.debacharya.jflow.nn.datastructure.weight;

import com.debacharya.jflow.nn.datastructure.dendrite.SimpleDendrite;

public class SimpleWeight extends AbstractWeight<Double, SimpleDendrite> {

	public SimpleWeight(double value) {
		super(value);
	}

	@Override
	public Double getValue() {
		return this.value;
	}

	@Override
	public SimpleDendrite runWeightFunction(SimpleDendrite input) {
		input.setValue(input.getValue() * this.value);
		return input;
	}
}
