package com.debacharya.jflow.nn;

import com.debacharya.jflow.nn.activationfunction.ActivationFunction;
import com.debacharya.jflow.nn.datastructure.bias.SimpleBias;
import com.debacharya.jflow.nn.datastructure.dendrite.SimpleDendrite;
import com.debacharya.jflow.nn.datastructure.synapse.SimpleSynapse;
import com.debacharya.jflow.nn.datastructure.weight.SimpleWeight;
import com.debacharya.jflow.nn.hiddenlayer.SimpleHiddenLayer;
import com.debacharya.jflow.nn.inputlayer.SimpleInputLayer;
import com.debacharya.jflow.nn.outputlayer.SimpleOutputLayer;

import java.util.List;

public class SimpleNeuralNetwork extends AbstractNeuralNetwork<SimpleInputLayer, SimpleHiddenLayer, SimpleOutputLayer> {

	public SimpleNeuralNetwork(SimpleInputLayer inputLayer, SimpleOutputLayer outputLayer) {
		super(inputLayer, outputLayer);
	}

	public SimpleNeuralNetwork(
		SimpleInputLayer inputLayer,
		List<SimpleHiddenLayer> hiddenLayers,
		SimpleOutputLayer outputLayer
	) {
		super(inputLayer, hiddenLayers, outputLayer);
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
}
