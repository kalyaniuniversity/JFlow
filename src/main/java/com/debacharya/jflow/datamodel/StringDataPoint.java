package com.debacharya.jflow.datamodel;

public class StringDataPoint extends AbstractDataPoint<String> {

	public StringDataPoint(String value) {
		super(value);
	}

	@Override
	public String toString() {
		return this.getValue();
	}
}
