package com.debacharya.jflow.nn.outputlayer;

import com.debacharya.jflow.nn.activationfunction.ActivationFunction;
import com.debacharya.jflow.nn.datastructure.bias.SimpleBias;
import com.debacharya.jflow.nn.datastructure.dendrite.SimpleDendrite;
import com.debacharya.jflow.nn.datastructure.neuron.SimpleNeuron;
import com.debacharya.jflow.nn.datastructure.synapse.SimpleSynapse;
import com.debacharya.jflow.nn.datastructure.weight.SimpleWeight;
import com.debacharya.jflow.nn.inputlayer.SimpleInputLayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SimpleOutputLayer extends AbstractOutputLayer<SimpleNeuron> {

	public SimpleOutputLayer(SimpleNeuron output) {
		super(Collections.singletonList(output));
	}

	public SimpleOutputLayer(
		SimpleInputLayer inputLayer,
		List<SimpleWeight> weights,
		SimpleBias bias,
		ActivationFunction<SimpleDendrite, SimpleSynapse, SimpleWeight, SimpleBias> activationFunction
	) {
		this(new SimpleNeuron(
			inputLayer.getInputs(),
			weights,
			bias,
			activationFunction
		));
	}

	public SimpleNeuron getOutput() {
		return this.getOutputs().get(0);
	}

	public SimpleSynapse getOutputSynapse() {
		return this.getOutputs().get(0).getOutput();
	}
}
