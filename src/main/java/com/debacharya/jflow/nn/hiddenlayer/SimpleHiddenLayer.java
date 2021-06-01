package com.debacharya.jflow.nn.hiddenlayer;

import com.debacharya.jflow.nn.datastructure.neuron.SimpleNeuron;

import java.util.List;

public class SimpleHiddenLayer extends AbstractHiddenLayer<SimpleNeuron> {

	public SimpleHiddenLayer(List<SimpleNeuron> neurons) {
		super(neurons);
	}
}
