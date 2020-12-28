package com.debacharya.jflow.nn.connector;

import com.debacharya.jflow.nn.datastructure.dendrite.AbstractDendrite;
import com.debacharya.jflow.nn.datastructure.dendrite.SimpleDendrite;
import com.debacharya.jflow.nn.datastructure.synapse.AbstractSynapse;
import com.debacharya.jflow.nn.datastructure.synapse.SimpleSynapse;

public class SimpleNeuralConnector implements NeuralConnector<SimpleDendrite, SimpleSynapse> {

	@Override
	public SimpleDendrite connect(SimpleSynapse input) {
		return null;
	}
}
