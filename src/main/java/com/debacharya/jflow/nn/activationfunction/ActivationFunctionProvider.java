package com.debacharya.jflow.nn.activationfunction;

import com.debacharya.jflow.nn.datastructure.bias.SimpleBias;
import com.debacharya.jflow.nn.datastructure.dendrite.SimpleDendrite;
import com.debacharya.jflow.nn.datastructure.synapse.SimpleSynapse;
import com.debacharya.jflow.nn.datastructure.weight.SimpleWeight;
import org.apache.commons.math3.analysis.function.Sigmoid;

public class ActivationFunctionProvider {

	public static ActivationFunction<SimpleDendrite, SimpleSynapse, SimpleWeight, SimpleBias> sigmoidFunction() {
		return (inputs, weights, bias) -> {

			long summation = 0;

			for(int i = 0; i < inputs.size(); i++)
				summation += weights.get(i).runWeightFunction(inputs.get(i)).getValue();

			summation += bias.getValue();

			return new SimpleSynapse(new Sigmoid(0, 1).value(summation));
		};
	}
}
