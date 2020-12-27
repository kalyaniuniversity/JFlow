package com.debacharya.jflow.nn;

import com.debacharya.jflow.nn.activationfunction.ActivationFunctionProvider;
import com.debacharya.jflow.nn.datastructure.bias.SimpleBias;
import com.debacharya.jflow.nn.datastructure.dendrite.SimpleDendrite;
import com.debacharya.jflow.nn.datastructure.neuron.SimpleNeuron;
import com.debacharya.jflow.nn.datastructure.weight.SimpleWeight;
import com.debacharya.jflow.nn.hiddenlayer.SimpleHiddenLayer;
import com.debacharya.jflow.nn.inputlayer.SimpleInputLayer;
import com.debacharya.jflow.nn.outputlayer.SimpleOutputLayer;

import java.util.ArrayList;
import java.util.List;

public class SimpleNeuralNetworkTest {

	public static void main(String[] args) {
		SimpleNeuralNetworkTest.noHiddenLayerTest();
	}

	public static void noHiddenLayerTest() {

		List<SimpleDendrite> inputs = new ArrayList<>();
		List<SimpleWeight> weights = new ArrayList<>();
		SimpleBias bias = new SimpleBias(4);

		inputs.add(new SimpleDendrite(2));
		inputs.add(new SimpleDendrite(3));

		weights.add(new SimpleWeight(0));
		weights.add(new SimpleWeight(1));

		SimpleInputLayer inputLayer = new SimpleInputLayer(inputs);

		SimpleNeuralNetwork neuralNetwork = new SimpleNeuralNetwork(
			inputLayer,
			weights,
			bias,
			ActivationFunctionProvider.sigmoidFunction()
		);
	}
}
