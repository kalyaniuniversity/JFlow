package com.debacharya.jflow.nn.connector;

import com.debacharya.jflow.nn.datastructure.dendrite.AbstractDendrite;
import com.debacharya.jflow.nn.datastructure.synapse.AbstractSynapse;

import java.util.List;

public interface NeuralConnector<T extends AbstractDendrite<?>, S extends AbstractSynapse<?>> {
	T connect(S input);
	List<T> connect(List<S> inputs);
}
