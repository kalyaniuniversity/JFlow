package com.debacharya.jflow.nn.outputlayer;

import com.debacharya.jflow.nn.datastructure.bias.AbstractBias;
import com.debacharya.jflow.nn.datastructure.dendrite.AbstractDendrite;
import com.debacharya.jflow.nn.datastructure.neuron.AbstractNeuron;
import com.debacharya.jflow.nn.datastructure.synapse.AbstractSynapse;
import com.debacharya.jflow.nn.datastructure.weight.AbstractWeight;

import java.util.List;

public abstract class AbstractOutputLayer<
		O extends AbstractNeuron<
			? extends AbstractDendrite<?>,
			? extends AbstractSynapse<?>,
			? extends AbstractWeight<?, ? extends AbstractDendrite<?>>,
			? extends AbstractBias<?>
		>
	> {

	private final List<O> outputs;

	public AbstractOutputLayer(List<O> outputs) {
		this.outputs = outputs;
	}

	public List<O> getOutputs() {
		return outputs;
	}
}
