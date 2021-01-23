package com.debacharya.jflow.nn;

import com.debacharya.jflow.nn.activationfunction.ActivationFunction;
import com.debacharya.jflow.nn.connector.SimpleNeuralConnector;
import com.debacharya.jflow.nn.datastructure.bias.SimpleBias;
import com.debacharya.jflow.nn.datastructure.dendrite.SimpleDendrite;
import com.debacharya.jflow.nn.datastructure.neuron.Neuron;
import com.debacharya.jflow.nn.datastructure.neuron.SimpleNeuron;
import com.debacharya.jflow.nn.datastructure.synapse.SimpleSynapse;
import com.debacharya.jflow.nn.datastructure.weight.SimpleWeight;
import com.debacharya.jflow.nn.hiddenlayer.SimpleHiddenLayer;
import com.debacharya.jflow.nn.inputlayer.SimpleInputLayer;
import com.debacharya.jflow.nn.outputlayer.SimpleOutputLayer;

import java.util.List;
import java.util.stream.Collectors;

public class SimpleNeuralNetwork extends AbstractNeuralNetwork<
		SimpleInputLayer,
		SimpleHiddenLayer,
		SimpleOutputLayer,
		SimpleNeuralConnector
	> {

	public SimpleNeuralNetwork(SimpleInputLayer inputLayer, SimpleOutputLayer outputLayer) {
		super(inputLayer, outputLayer);
	}

	public SimpleNeuralNetwork(
		SimpleInputLayer inputLayer,
		List<SimpleHiddenLayer> hiddenLayers,
		SimpleOutputLayer outputLayer,
		SimpleNeuralConnector neuralConnector
	) {
		super(inputLayer, hiddenLayers, outputLayer, neuralConnector);
	}

	public SimpleNeuralNetwork(
		SimpleInputLayer inputLayer,
		List<SimpleWeight> weights,
		SimpleBias bias,
		ActivationFunction<SimpleDendrite, SimpleSynapse, SimpleWeight, SimpleBias> activationFunction
	) {
		this(
			inputLayer,
			new SimpleOutputLayer(
				inputLayer,
				weights,
				bias,
				activationFunction
			)
		);
	}

	@Override
	public void processOutput() {

		List<SimpleSynapse> result = this
			.getOutputLayer()
			.getOutputs()
			.stream()
			.parallel()
			.map(Neuron::feedForward)
			.map(SimpleSynapse.class::cast)
			.collect(Collectors.toList());

		this.getOutputLayer().setResults(result);
	}

	@Override
	public void prepareHiddenLayer(SimpleHiddenLayer layer) {

		List<SimpleNeuron> neurons = layer.getNeurons();

		neurons.forEach(neuron -> {
			SimpleSynapse output = neuron.feedForward();
			neuron.setOutput(output);
		});
	}

	@Override
	public void fuseInputToOutputLayer() {
		if(!this.getOutputLayer().getOutput().areInputsSet())
			this.getOutputLayer().getOutput().setInputs(
				this.getInputLayer().getInputs(),
				true
			);
	}

	@Override
	public void shorCircuitInputToHiddenLayer(int hiddenLayerIndex) {
		this
			.getHiddenLayers()
			.get(hiddenLayerIndex)
			.getNeurons()
			.forEach(neuron -> neuron.setInputs(
				this.getInputLayer().getInputs(),
				true
			));
	}

	@Override
	public void shorCircuitHiddenLayerToOutput(int hiddenLayerIndex) {
		this
			.getOutputLayer()
			.getOutput()
			.setInputs(
				this.getNeuralConnector().connect(
					this
						.getHiddenLayers()
						.get(hiddenLayerIndex)
						.getNeurons()
						.stream()
						.map(SimpleNeuron::getOutput)
						.collect(Collectors.toList())
				),
				true
			);
	}
}
