package com.debacharya.jflow.datamodel;


public class NumericDataPoint extends AbstractDataPoint<Double> {

	public NumericDataPoint(Double value) {
		super(value);
	}

	@Override
	public String toString() {
		return this.getValue().toString();
	}
}
