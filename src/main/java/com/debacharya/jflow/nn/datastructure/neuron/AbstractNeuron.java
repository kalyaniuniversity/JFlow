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

	private List<P> inputs;
	private Q output;
	private List<R> weights;
	private S bias;
	private ActivationFunction<P, R, S, Q> activationFunction;
	private final List<NeuronSnapshot<P, Q, R, S>> snapshots;

	public AbstractNeuron() {
		this.inputs = new ArrayList<>();
		this.weights = new ArrayList<>();
		this.snapshots = new ArrayList<>();
	}

	public AbstractNeuron(
		List<P> inputs,
		Q output,
		List<R> weights,
		S bias,
		ActivationFunction<P, R, S, Q> activationFunction
	) {
		this.inputs = inputs;
		this.output = output;
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

	public void setInputs(List<P> inputs) {
		this.inputs = inputs;
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

	public void setWeights(List<R> weights) {
		this.weights = weights;
	}

	public S getBias() {
		return bias;
	}

	public void setBias(S bias) {
		this.bias = bias;
	}

	public ActivationFunction<P, R, S, Q> getActivationFunction() {
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
}
