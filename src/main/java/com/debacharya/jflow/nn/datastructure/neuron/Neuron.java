package com.debacharya.jflow.nn.datastructure.neuron;

import com.debacharya.jflow.nn.datastructure.synapse.AbstractSynapse;

public interface Neuron {
	AbstractSynapse<?> feedForward();
}
