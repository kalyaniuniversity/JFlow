package com.debacharya.jflow.nn;

import com.debacharya.jflow.nn.connector.NeuralConnector;
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
		>,
		C extends NeuralConnector<
			? extends AbstractDendrite<?>,
			? extends AbstractSynapse<?>
		>
	> implements NeuralNetwork<H> {

	private final I inputLayer;
	private final List<H> hiddenLayers;
	private final O outputLayer;
	private final C neuralConnector;

	public AbstractNeuralNetwork(I inputLayer, O outputLayer) {
		this.inputLayer = inputLayer;
		this.outputLayer = outputLayer;
		this.hiddenLayers = null;
		this.neuralConnector = null;
	}

	public AbstractNeuralNetwork(I inputLayer, List<H> hiddenLayers, O outputLayer, C neuralConnector) {
		this.inputLayer = inputLayer;
		this.hiddenLayers = hiddenLayers;
		this.outputLayer = outputLayer;
		this.neuralConnector = neuralConnector;
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

	public C getNeuralConnector() {
		return neuralConnector;
	}

	@Override
	public void buildNetwork() {

		if(this.hiddenLayers == null) {
			this.fuseInputToOutputLayer();
			return;
		}

		this.connectInputToFirstHiddenLayer();
	}

	@Override
	public void run() {

		this.buildNetwork();

		if(this.hiddenLayers != null && !this.hiddenLayers.isEmpty())
			this.hiddenLayers.forEach(this::prepareHiddenLayer);

		this.connectLastHiddenLayerToOutput();
		this.processOutput();
	}

	public void connectInputToFirstHiddenLayer() {
		if(this.hiddenLayers != null && !this.hiddenLayers.isEmpty())
			this.shorCircuitInputToHiddenLayer(0);
	}

	public void connectLastHiddenLayerToOutput() {
		if(this.hiddenLayers != null && !this.hiddenLayers.isEmpty())
			this.shorCircuitHiddenLayerToOutput(
				this.hiddenLayers.size() - 1
			);
	}

	public abstract void fuseInputToOutputLayer();
	public abstract void shorCircuitInputToHiddenLayer(int hiddenLayerIndex);
	public abstract void shorCircuitHiddenLayerToOutput(int hiddenLayerIndex);
}
