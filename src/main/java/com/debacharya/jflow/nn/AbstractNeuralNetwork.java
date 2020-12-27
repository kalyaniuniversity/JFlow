package com.debacharya.jflow.nn;

import com.debacharya.jflow.nn.datastructure.bias.AbstractBias;
import com.debacharya.jflow.nn.datastructure.dendrite.AbstractDendrite;
import com.debacharya.jflow.nn.datastructure.neuron.AbstractNeuron;
import com.debacharya.jflow.nn.datastructure.synapse.AbstractSynapse;
import com.debacharya.jflow.nn.datastructure.weight.AbstractWeight;
import com.debacharya.jflow.nn.hiddenlayer.AbstractHiddenLayer;
import com.debacharya.jflow.nn.inputlayer.AbstractInputLayer;
import com.debacharya.jflow.nn.outputlayer.AbstractOutputLayer;

public abstract class AbstractNeuralNetwork<
		I extends AbstractInputLayer<? extends AbstractDendrite<?>>,
		H extends AbstractHiddenLayer<
			? extends AbstractNeuron<
				? extends AbstractDendrite<?>,
				? extends AbstractSynapse<?>,
				? extends AbstractWeight<?, ? extends AbstractDendrite<?>>,
				? extends AbstractBias<?>
			>
		>,
		O extends AbstractOutputLayer<? extends AbstractSynapse<?>>
	> implements NeuralNetwork {
}
