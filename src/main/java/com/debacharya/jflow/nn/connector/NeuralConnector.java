package com.debacharya.jflow.nn.connector;

import com.debacharya.jflow.nn.datastructure.dendrite.AbstractDendrite;
import com.debacharya.jflow.nn.datastructure.synapse.AbstractSynapse;

public interface NeuralConnector<T extends AbstractDendrite<?>, S extends AbstractSynapse<?>> {
	T connect(S input);
}
