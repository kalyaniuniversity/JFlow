package com.debacharya.jflow.nn.hiddenlayer;

import com.debacharya.jflow.nn.datastructure.bias.AbstractBias;
import com.debacharya.jflow.nn.datastructure.dendrite.AbstractDendrite;
import com.debacharya.jflow.nn.datastructure.neuron.AbstractNeuron;
import com.debacharya.jflow.nn.datastructure.synapse.AbstractSynapse;
import com.debacharya.jflow.nn.datastructure.weight.AbstractWeight;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class AbstractHiddenLayer<
		H extends AbstractNeuron<
			? extends AbstractDendrite<?>,
			? extends AbstractSynapse<?>,
			? extends AbstractWeight<?, ? extends AbstractDendrite<?>>,
			? extends AbstractBias<?>
		>
	> {

	private final List<H> neurons;

	public AbstractHiddenLayer(List<H> neurons) {
		this.neurons = neurons;
	}
}
