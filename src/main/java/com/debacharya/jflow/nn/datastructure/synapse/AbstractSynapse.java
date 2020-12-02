package com.debacharya.jflow.nn.datastructure.synapse;

public abstract class AbstractSynapse<S> {

	protected S value;

	public AbstractSynapse(S value) {
		this.value = value;
	}

	public abstract S getValue();
	public abstract void setValue(S value);
}
