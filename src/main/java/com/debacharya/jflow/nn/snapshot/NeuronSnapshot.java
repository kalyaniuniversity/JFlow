package com.debacharya.jflow.nn.snapshot;

import com.debacharya.jflow.nn.datastructure.bias.AbstractBias;
import com.debacharya.jflow.nn.datastructure.dendrite.AbstractDendrite;
import com.debacharya.jflow.nn.datastructure.neuron.AbstractNeuron;
import com.debacharya.jflow.nn.datastructure.synapse.AbstractSynapse;
import com.debacharya.jflow.nn.datastructure.weight.AbstractWeight;
import com.debacharya.jflow.util.Utility;

import java.util.List;

public class NeuronSnapshot<
	P extends AbstractDendrite<?>,
	Q extends AbstractSynapse<?>,
	R extends AbstractWeight<?, ? extends AbstractDendrite<?>>,
	S extends AbstractBias<?>
	> {

	private final AbstractNeuron<P, Q, R, S> neuron;
	private final long timeOfCreation;
	private List<P> inputs;
	private long lastUpdate;
	private int snapshotID;
	private String label;

	public NeuronSnapshot(
		AbstractNeuron<P, Q, R, S> neuron,
		int snapshotID,
		String label
	) {
		this.timeOfCreation = System.currentTimeMillis();
		this.neuron = neuron;
		this.snapshotID = snapshotID;
		this.label = label;

		if(this.neuron.areInputsSet())
			this.inputs = AbstractDendrite.cloneDendrites(this.neuron.getInputs());
	}

	public NeuronSnapshot(AbstractNeuron<P, Q, R, S> neuron) {
		this(
			neuron,
			Utility.generateRandomInteger(),
			Utility.generateRandomLabel()
		);
	}

	public List<P> getInputs() {
		return this.inputs;
	}

	public int getSnapshotID() {
		return snapshotID;
	}
}
