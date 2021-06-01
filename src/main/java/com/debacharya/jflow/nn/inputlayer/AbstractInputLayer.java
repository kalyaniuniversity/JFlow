package com.debacharya.jflow.nn.inputlayer;

import com.debacharya.jflow.nn.datastructure.dendrite.AbstractDendrite;

import java.util.List;

public abstract class AbstractInputLayer<I extends AbstractDendrite<?>> {

	private List<I> inputs;

	public AbstractInputLayer(List<I> inputs) {
		this.inputs = inputs;
	}

	public List<I> getInputs() {
		return inputs;
	}

	public void setInputs(List<I> inputs) {
		this.inputs = inputs;
	}
}
