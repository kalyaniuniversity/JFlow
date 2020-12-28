package com.debacharya.jflow.nn.datastructure.neuron;

import com.debacharya.jflow.nn.datastructure.synapse.AbstractSynapse;

public interface Neuron<T extends AbstractSynapse<?>> {
	T feedForward();
//	AbstractSynapse<?> feedForward();
}
