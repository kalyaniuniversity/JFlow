package com.debacharya.jflow.nn.connector;

import com.debacharya.jflow.nn.datastructure.dendrite.SimpleDendrite;
import com.debacharya.jflow.nn.datastructure.synapse.SimpleSynapse;

import java.util.List;
import java.util.stream.Collectors;

public class SimpleNeuralConnector implements NeuralConnector<SimpleDendrite, SimpleSynapse> {

	@Override
	public SimpleDendrite connect(SimpleSynapse input) {
		return new SimpleDendrite(
			input.getValue()
		);
	}

	@Override
	public List<SimpleDendrite> connect(List<SimpleSynapse> inputs) {
		return inputs
			.stream()
			.map(this::connect)
			.collect(Collectors.toList());
	}
}
