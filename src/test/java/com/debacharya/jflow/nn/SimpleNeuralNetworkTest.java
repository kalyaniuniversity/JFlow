package com.debacharya.jflow.nn;

import com.debacharya.jflow.nn.activationfunction.ActivationFunctionProvider;
import com.debacharya.jflow.nn.datastructure.bias.SimpleBias;
import com.debacharya.jflow.nn.datastructure.dendrite.SimpleDendrite;
import com.debacharya.jflow.nn.datastructure.synapse.SimpleSynapse;
import com.debacharya.jflow.nn.datastructure.weight.SimpleWeight;
import com.debacharya.jflow.nn.hiddenlayer.HiddenLayerProvider;
import com.debacharya.jflow.nn.hiddenlayer.SimpleHiddenLayer;
import com.debacharya.jflow.nn.inputlayer.SimpleInputLayer;
import com.debacharya.jflow.nn.outputlayer.SimpleOutputLayer;

import java.util.ArrayList;
import java.util.List;

public class SimpleNeuralNetworkTest {

	public static void main(String[] args) {
		SimpleNeuralNetworkTest.noHiddenLayerTest();
	}

	public static void oneHiddenLayerTest() {

		List<SimpleDendrite> inputs = new ArrayList<>();
		List<SimpleWeight> weights = new ArrayList<>();
		SimpleBias bias = new SimpleBias(0);

		inputs.add(new SimpleDendrite(2));
		inputs.add(new SimpleDendrite(3));

		weights.add(new SimpleWeight(0));
		weights.add(new SimpleWeight(1));

		SimpleInputLayer inputLayer = new SimpleInputLayer(inputs);
		List<SimpleHiddenLayer> hiddenLayers = new ArrayList<>();
		SimpleOutputLayer outputLayer = new SimpleOutputLayer(
			weights,
			bias,
			ActivationFunctionProvider.sigmoidFunction()
		);

		SimpleHiddenLayer hiddenLayer1 = HiddenLayerProvider.generateSimpleHiddenLayer(
			2,
			weights,
			bias,
			ActivationFunctionProvider.sigmoidFunction()
		);

		hiddenLayers.add(hiddenLayer1);

		SimpleNeuralNetwork neuralNetwork = new SimpleNeuralNetwork(
			inputLayer,
			hiddenLayers,
			outputLayer
		);

		neuralNetwork.run();

		SimpleSynapse output = neuralNetwork.getOutputLayer().getResult();

		System.out.println("Output is: " + output.getValue());
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
		SimpleOutputLayer outputLayer = new SimpleOutputLayer(
			weights,
			bias,
			ActivationFunctionProvider.sigmoidFunction()
		);

		SimpleNeuralNetwork neuralNetwork = new SimpleNeuralNetwork(
			inputLayer,
			outputLayer
		);

		neuralNetwork.run();

		SimpleSynapse output = neuralNetwork.getOutputLayer().getResult();

		System.out.println("Output is: " + output.getValue());
	}
}
