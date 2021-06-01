package com.debacharya.jflow.nn.datastructure.dendrite;

public class SimpleDendrite extends AbstractDendrite<Double> {

	public SimpleDendrite(double value) {
		super(value);
	}

	@Override
	public Double getValue() {
		return this.value;
	}

	@Override
	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public SimpleDendrite getCopy() {
		return new SimpleDendrite(this.value);
	}
}
