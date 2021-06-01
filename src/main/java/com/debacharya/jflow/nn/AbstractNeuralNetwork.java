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
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
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

		if(this.hiddenLayers != null && this.hiddenLayers.size() == 1)
			this.prepareHiddenLayer(this.hiddenLayers.get(0));

		if(this.hiddenLayers != null && this.hiddenLayers.size() > 1) {
			for(int i = 0; i < (this.hiddenLayers.size() - 1); i++)
				this.connectHiddenLayers(i, i + 1);
			this.activateLastHiddenLayer();
		}

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

	public void activateLastHiddenLayer() {
		if(this.hiddenLayers != null && !this.hiddenLayers.isEmpty())
			this.activateHiddenLayer(
				this.hiddenLayers.size() - 1
			);
	}

	public abstract void fuseInputToOutputLayer();
	public abstract void shorCircuitInputToHiddenLayer(int hiddenLayerIndex);
	public abstract void shorCircuitHiddenLayerToOutput(int hiddenLayerIndex);
	public abstract void connectHiddenLayers(int hiddenLayerFromIndex, int hiddenLayerToIndex);
}
