package com.debacharya.jflow.nn.datastructure.neuron;

import com.debacharya.jflow.nn.activationfunction.ActivationFunctionProvider;
import com.debacharya.jflow.nn.datastructure.bias.SimpleBias;
import com.debacharya.jflow.nn.datastructure.dendrite.SimpleDendrite;
import com.debacharya.jflow.nn.datastructure.synapse.SimpleSynapse;
import com.debacharya.jflow.nn.datastructure.weight.SimpleWeight;

import java.util.ArrayList;
import java.util.List;

public class SimpleNeuronTest {

	public static void main(String[] args) {

		List<SimpleDendrite> inputs = new ArrayList<>();
		List<SimpleWeight> weights = new ArrayList<>();
		SimpleBias bias = new SimpleBias(4);

		inputs.add(new SimpleDendrite(2));
		inputs.add(new SimpleDendrite(3));

		weights.add(new SimpleWeight(0));
		weights.add(new SimpleWeight(1));

		SimpleNeuron simpleNeuron = new SimpleNeuron(
			inputs,
			weights,
			bias,
			ActivationFunctionProvider.sigmoidFunction()
		);

		SimpleSynapse output = simpleNeuron.feedForward();

		System.out.println("Output is: " + output.getValue(3));
	}
}
