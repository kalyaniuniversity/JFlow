package com.debacharya.jflow.nn;

import com.debacharya.jflow.nn.hiddenlayer.AbstractHiddenLayer;

public interface NeuralNetwork<H extends AbstractHiddenLayer<?>> {
	void buildNetwork();
	void processOutput();
	void prepareHiddenLayer(H layer);
	void run();
}
