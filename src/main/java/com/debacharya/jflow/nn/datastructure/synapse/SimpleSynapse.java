package com.debacharya.jflow.nn.datastructure.synapse;

import com.debacharya.jflow.util.Utility;

public class SimpleSynapse extends AbstractSynapse<Double> {

	public SimpleSynapse(double value) {
		super(value);
	}

	@Override
	public Double getValue() {
		return this.value;
	}

	public double getValue(int decimalPlace) {
		return Utility.roundOff(
			this.getValue(),
			decimalPlace
		);

	}
}
