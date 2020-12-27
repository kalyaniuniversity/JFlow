package com.debacharya.jflow.nn.outputlayer;

import com.debacharya.jflow.nn.datastructure.synapse.SimpleSynapse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SimpleOutputLayer extends AbstractOutputLayer<SimpleSynapse> {

	public SimpleOutputLayer(SimpleSynapse output) {
		super(Collections.singletonList(output));
	}

	public SimpleSynapse getOutput() {
		return this.getOutputs().get(0);
	}
}
