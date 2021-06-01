package com.debacharya.jflow.nn.outputlayer;

import com.debacharya.jflow.nn.datastructure.bias.AbstractBias;
import com.debacharya.jflow.nn.datastructure.dendrite.AbstractDendrite;
import com.debacharya.jflow.nn.datastructure.neuron.AbstractNeuron;
import com.debacharya.jflow.nn.datastructure.synapse.AbstractSynapse;
import com.debacharya.jflow.nn.datastructure.weight.AbstractWeight;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class AbstractOutputLayer<
		O extends AbstractNeuron<
			? extends AbstractDendrite<?>,
			? extends AbstractSynapse<?>,
			? extends AbstractWeight<?, ? extends AbstractDendrite<?>>,
			? extends AbstractBias<?>
		>,
		R extends AbstractSynapse<?>
	> {

	private final List<O> outputs;
	private List<R> results;

	public AbstractOutputLayer(List<O> outputs) {
		this.outputs = outputs;
		this.results = new ArrayList<>();
	}

	public void setResults(List<R> results) {
		this.results = results;
	}
}
