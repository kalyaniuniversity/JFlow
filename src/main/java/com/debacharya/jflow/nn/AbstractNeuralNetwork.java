package com.debacharya.jflow.nn;

import com.debacharya.jflow.nn.datastructure.bias.AbstractBias;
import com.debacharya.jflow.nn.datastructure.dendrite.AbstractDendrite;
import com.debacharya.jflow.nn.datastructure.neuron.AbstractNeuron;
import com.debacharya.jflow.nn.datastructure.synapse.AbstractSynapse;
import com.debacharya.jflow.nn.datastructure.weight.AbstractWeight;
import com.debacharya.jflow.nn.hiddenlayer.AbstractHiddenLayer;
import com.debacharya.jflow.nn.inputlayer.AbstractInputLayer;
import com.debacharya.jflow.nn.outputlayer.AbstractOutputLayer;

import java.util.List;

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
		O extends AbstractOutputLayer<
			? extends AbstractNeuron<
				? extends AbstractDendrite<?>,
				? extends AbstractSynapse<?>,
				? extends AbstractWeight<?, ? extends AbstractDendrite<?>>,
				? extends AbstractBias<?>
			>,
			? extends AbstractSynapse<?>
		>
	> implements NeuralNetwork {

	private final I inputLayer;
	private final List<H> hiddenLayers;
	private final O outputLayer;

	public AbstractNeuralNetwork(I inputLayer, O outputLayer) {
		this.inputLayer = inputLayer;
		this.outputLayer = outputLayer;
		this.hiddenLayers = null;
	}

	public AbstractNeuralNetwork(I inputLayer, List<H> hiddenLayers, O outputLayer) {
		this.inputLayer = inputLayer;
		this.hiddenLayers = hiddenLayers;
		this.outputLayer = outputLayer;
	}

	public I getInputLayer() {
		return inputLayer;
	}

	public List<H> getHiddenLayers() {
		return hiddenLayers;
	}

	public O getOutputLayer() {
		return outputLayer;
	}

	@Override
	public void buildNetwork() {
		if(this.hiddenLayers == null)
			this.fuseInputToOutputLayer();
	}

	@Override
	public void run() {
		this.buildNetwork();
		this.processOutput();
	}

	public abstract void fuseInputToOutputLayer();
}
