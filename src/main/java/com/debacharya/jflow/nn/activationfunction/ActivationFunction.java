package com.debacharya.jflow.nn.activationfunction;

import com.debacharya.jflow.nn.datastructure.bias.AbstractBias;
import com.debacharya.jflow.nn.datastructure.dendrite.AbstractDendrite;
import com.debacharya.jflow.nn.datastructure.synapse.AbstractSynapse;
import com.debacharya.jflow.nn.datastructure.weight.AbstractWeight;

import java.util.List;

@FunctionalInterface
public interface ActivationFunction<
	A extends AbstractDendrite<?>,
	B extends AbstractSynapse<?>,
	C extends AbstractWeight<?, ? extends AbstractDendrite<?>>,
	D extends AbstractBias<?>
	> {
	B calculateOutput(
		List<A> inputs,
		List<C> weights,
		D bias
	);
}
