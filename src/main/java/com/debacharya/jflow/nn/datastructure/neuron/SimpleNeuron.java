package com.debacharya.jflow.nn.datastructure.neuron;

import com.debacharya.jflow.nn.activationfunction.ActivationFunction;
import com.debacharya.jflow.nn.datastructure.bias.SimpleBias;
import com.debacharya.jflow.nn.datastructure.dendrite.SimpleDendrite;
import com.debacharya.jflow.nn.datastructure.synapse.SimpleSynapse;
import com.debacharya.jflow.nn.datastructure.weight.SimpleWeight;

import java.util.List;

public class SimpleNeuron extends AbstractNeuron<SimpleDendrite, SimpleSynapse, SimpleWeight, SimpleBias> {

	private int snapshotID = 0;

	public SimpleNeuron(
		List<SimpleWeight> weights,
		SimpleBias bias,
		ActivationFunction<SimpleDendrite, SimpleSynapse, SimpleWeight, SimpleBias> activationFunction
	) {
		super(weights, bias, activationFunction);
		this.takeSnapshot(this.getNextSnapshotID());
	}

	public SimpleNeuron(
		List<SimpleDendrite> inputs,
		List<SimpleWeight> weights,
		SimpleBias bias,
		ActivationFunction<SimpleDendrite, SimpleSynapse, SimpleWeight, SimpleBias> activationFunction
	) {
		this(weights, bias, activationFunction);
		this.takeSnapshot(this.getNextSnapshotID());
	}

	public int getNextSnapshotID() {
		return ++this.snapshotID;
	}

	@Override
	public SimpleSynapse feedForward() {
		return this.getActivationFunction().calculateOutput(
			this.getInputs(),
			this.getWeights(),
			this.getBias()
		);
	}
}
