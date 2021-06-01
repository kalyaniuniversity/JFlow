package com.debacharya.jflow.nn;

import com.debacharya.jflow.nn.activationfunction.ActivationFunctionProvider;
import com.debacharya.jflow.nn.connector.SimpleNeuralConnector;
import com.debacharya.jflow.nn.datastructure.bias.SimpleBias;
import com.debacharya.jflow.nn.datastructure.dendrite.SimpleDendrite;
import com.debacharya.jflow.nn.datastructure.synapse.SimpleSynapse;
import com.debacharya.jflow.nn.datastructure.weight.SimpleWeight;
import com.debacharya.jflow.nn.hiddenlayer.HiddenLayerProvider;
import com.debacharya.jflow.nn.hiddenlayer.SimpleHiddenLayer;
import com.debacharya.jflow.nn.inputlayer.SimpleInputLayer;
import com.debacharya.jflow.nn.outputlayer.SimpleOutputLayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SimpleNeuralNetworkTest {

	@Test
	public void manyHiddenLayersTest() {

		List<SimpleDendrite> inputs = new ArrayList<>();
		List<SimpleWeight> weights = new ArrayList<>();
		SimpleBias bias = new SimpleBias(0);

		inputs.add(new SimpleDendrite(2));
		inputs.add(new SimpleDendrite(3));

		weights.add(new SimpleWeight(0));
		weights.add(new SimpleWeight(1));

		SimpleNeuralConnector neuralConnector = new SimpleNeuralConnector();
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

		SimpleHiddenLayer hiddenLayer2 = HiddenLayerProvider.generateSimpleHiddenLayer(
			2,
			weights,
			bias,
			ActivationFunctionProvider.sigmoidFunction()
		);

		SimpleHiddenLayer hiddenLayer3 = HiddenLayerProvider.generateSimpleHiddenLayer(
			2,
			weights,
			bias,
			ActivationFunctionProvider.sigmoidFunction()
		);

		hiddenLayers.add(hiddenLayer1);
		hiddenLayers.add(hiddenLayer2);
		hiddenLayers.add(hiddenLayer3);

		SimpleNeuralNetwork neuralNetwork = new SimpleNeuralNetwork(
			inputLayer,
			hiddenLayers,
			outputLayer,
			neuralConnector
		);

		neuralNetwork.run();

		SimpleSynapse output = neuralNetwork.getOutputLayer().getResult();

		System.out.println("Output is: " + output.getValue());

		assertEquals(0.662, output.getValue(), 0.0002d);
	}

	@Test
	public void oneHiddenLayerTest() {

		List<SimpleDendrite> inputs = new ArrayList<>();
		List<SimpleWeight> weights = new ArrayList<>();
		SimpleBias bias = new SimpleBias(0);

		inputs.add(new SimpleDendrite(2));
		inputs.add(new SimpleDendrite(3));

		weights.add(new SimpleWeight(0));
		weights.add(new SimpleWeight(1));

		SimpleNeuralConnector neuralConnector = new SimpleNeuralConnector();
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
			outputLayer,
			neuralConnector
		);

		neuralNetwork.run();

		SimpleSynapse output = neuralNetwork.getOutputLayer().getResult();

		System.out.println("Output is: " + output.getValue());

		assertEquals(0.7216, output.getValue(), 0.0004d);
	}

	@Test
	public void noHiddenLayerTest() {

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

		assertEquals(0.999, output.getValue(), 0.00009d);
	}
}
