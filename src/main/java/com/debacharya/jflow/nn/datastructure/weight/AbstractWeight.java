package com.debacharya.jflow.nn.datastructure.weight;

import com.debacharya.jflow.nn.datastructure.dendrite.AbstractDendrite;

public abstract class AbstractWeight<S, T extends AbstractDendrite<?>> {

	protected final S value;

	public AbstractWeight(S value) {
		this.value = value;
	}

	public abstract S getValue();
	public abstract T runWeightFunction(T input);
}
