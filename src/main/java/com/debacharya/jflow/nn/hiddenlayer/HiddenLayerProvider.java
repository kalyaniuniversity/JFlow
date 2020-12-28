package com.debacharya.jflow.nn.hiddenlayer;

import com.debacharya.jflow.nn.activationfunction.ActivationFunction;
import com.debacharya.jflow.nn.datastructure.bias.SimpleBias;
import com.debacharya.jflow.nn.datastructure.dendrite.SimpleDendrite;
import com.debacharya.jflow.nn.datastructure.neuron.SimpleNeuron;
import com.debacharya.jflow.nn.datastructure.synapse.SimpleSynapse;
import com.debacharya.jflow.nn.datastructure.weight.SimpleWeight;

import java.util.ArrayList;
import java.util.List;

public class HiddenLayerProvider {

	public static SimpleHiddenLayer generateSimpleHiddenLayer(
		int neuronCount,
		List<SimpleWeight> weights,
		SimpleBias bias,
		ActivationFunction<SimpleDendrite, SimpleSynapse, SimpleWeight, SimpleBias> activationFunction
	) {

		List<SimpleNeuron> neurons = new ArrayList<>();

		for(int i = 0; i < neuronCount; i++)
			neurons.add(i, new SimpleNeuron(
				weights,
				bias,
				activationFunction
			));

		return new SimpleHiddenLayer(neurons);
	}

	public static SimpleHiddenLayer generateSimpleHiddenLayer(
		int neuronCount,
		List<List<SimpleWeight>> weights,
		ActivationFunction<SimpleDendrite, SimpleSynapse, SimpleWeight, SimpleBias> activationFunction,
		SimpleBias bias
	) {

		List<SimpleNeuron> neurons = new ArrayList<>();

		for(int i = 0; i < neuronCount; i++)
			neurons.add(i, new SimpleNeuron(
				weights.get(i),
				bias,
				activationFunction
			));

		return new SimpleHiddenLayer(neurons);
	}

	public static SimpleHiddenLayer generateSimpleHiddenLayer(
		int neuronCount,
		List<SimpleWeight> weights,
		List<SimpleBias> biases,
		ActivationFunction<SimpleDendrite, SimpleSynapse, SimpleWeight, SimpleBias> activationFunction
	) {

		List<SimpleNeuron> neurons = new ArrayList<>();

		for(int i = 0; i < neuronCount; i++)
			neurons.add(i, new SimpleNeuron(
				weights,
				biases.get(i),
				activationFunction
			));

		return new SimpleHiddenLayer(neurons);
	}

	public static SimpleHiddenLayer generateSimpleHiddenLayer(
		int neuronCount,
		List<List<SimpleWeight>> weights,
		List<SimpleBias> biases,
		List<ActivationFunction<SimpleDendrite, SimpleSynapse, SimpleWeight, SimpleBias>> activationFunctions
	) {

		List<SimpleNeuron> neurons = new ArrayList<>();

		for(int i = 0; i < neuronCount; i++)
			neurons.add(i, new SimpleNeuron(
				weights.get(i),
				biases.get(i),
				activationFunctions.get(i)
			));

		return new SimpleHiddenLayer(neurons);
	}
}
