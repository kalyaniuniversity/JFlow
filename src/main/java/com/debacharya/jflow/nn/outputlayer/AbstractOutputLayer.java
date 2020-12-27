package com.debacharya.jflow.nn.outputlayer;

import com.debacharya.jflow.nn.datastructure.synapse.AbstractSynapse;

import java.util.List;

public abstract class AbstractOutputLayer<O extends AbstractSynapse<?>> {

	private final List<O> outputs;

	public AbstractOutputLayer(List<O> outputs) {
		this.outputs = outputs;
	}

	public List<O> getOutputs() {
		return outputs;
	}
}
