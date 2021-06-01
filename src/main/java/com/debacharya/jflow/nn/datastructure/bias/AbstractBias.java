package com.debacharya.jflow.nn.datastructure.bias;

public abstract class AbstractBias<S> {

	protected S value;

	public AbstractBias(S value) {
		this.value = value;
	}

	public abstract S getValue();
}
