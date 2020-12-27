package com.debacharya.jflow.nn.datastructure.neuron;

import com.debacharya.jflow.nn.activationfunction.ActivationFunction;
import com.debacharya.jflow.nn.datastructure.bias.AbstractBias;
import com.debacharya.jflow.nn.datastructure.dendrite.AbstractDendrite;
import com.debacharya.jflow.nn.datastructure.synapse.AbstractSynapse;
import com.debacharya.jflow.nn.datastructure.weight.AbstractWeight;
import com.debacharya.jflow.nn.snapshot.NeuronSnapshot;
import com.debacharya.jflow.util.Service;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNeuron<
		P extends AbstractDendrite<?>,
		Q extends AbstractSynapse<?>,
		R extends AbstractWeight<?, ? extends AbstractDendrite<?>>,
		S extends AbstractBias<?>
	> implements Neuron {

	private final List<P> inputs;
	private Q output;
	private final List<R> weights;
	private final S bias;
	private final ActivationFunction<P, Q, R, S> activationFunction;
	private final List<NeuronSnapshot<P, Q, R, S>> snapshots;

	public AbstractNeuron(
		List<P> inputs,
		List<R> weights,
		S bias,
		ActivationFunction<P, Q, R, S> activationFunction
	) {
		this.inputs = inputs;
		this.weights = weights;
		this.bias = bias;
		this.activationFunction = activationFunction;
		this.snapshots = new ArrayList<>();
	}

	public List<P> getInputs() {
		return inputs;
	}

	public P getInput(int index) {
		if(index >= this.inputs.size())
			throw new ArrayIndexOutOfBoundsException("There are no Neuron Inputs at index: " + index);
		return this.inputs.get(index);
	}

	public void setInput(P input, int index) {
		if(index >= this.inputs.size())
			throw new ArrayIndexOutOfBoundsException("There is no Neuron Input at index: " + index);
		this.inputs.set(index, input);
	}

	public Q getOutput() {
		return output;
	}

	public void setOutput(Q output) {
		this.output = output;
	}

	public List<R> getWeights() {
		return weights;
	}

	public R getWeight(int index) {
		if(index >= this.weights.size())
			throw new ArrayIndexOutOfBoundsException("There is no Connection Weight at index: " + index);
		return this.weights.get(index);
	}

	public S getBias() {
		return bias;
	}

	public ActivationFunction<P, Q, R, S> getActivationFunction() {
		return this.activationFunction;
	}

	public void takeSnapshot() {
		this.snapshots.add(new NeuronSnapshot<>(this));
	}

	public void takeSnapshot(int snapshotID) {
		this.snapshots.add(new NeuronSnapshot<>(
			this,
			snapshotID,
			Service.generateRandomLabel()
		));
	}

	public NeuronSnapshot<P, Q, R, S> getSnapshot(int snapshotID) {
		return this
			.snapshots
			.stream()
			.parallel()
			.filter(snapshot -> snapshot.getSnapshotID() == snapshotID)
			.findFirst()
			.orElse(null);
	}
}
