package com.debacharya.jflow.nn.inputlayer;

import com.debacharya.jflow.nn.datastructure.dendrite.SimpleDendrite;

import java.util.List;

public class SimpleInputLayer extends AbstractInputLayer<SimpleDendrite> {

	public SimpleInputLayer(List<SimpleDendrite> inputs) {
		super(inputs);
	}
}
