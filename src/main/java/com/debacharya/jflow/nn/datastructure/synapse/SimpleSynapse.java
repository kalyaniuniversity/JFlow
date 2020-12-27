package com.debacharya.jflow.nn.datastructure.synapse;

public class SimpleSynapse extends AbstractSynapse<Double> {

	public SimpleSynapse(double value) {
		super(value);
	}

	@Override
	public Double getValue() {
		return this.value;
	}
}
