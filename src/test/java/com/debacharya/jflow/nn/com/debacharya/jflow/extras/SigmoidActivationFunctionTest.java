package com.debacharya.jflow.nn.com.debacharya.jflow.extras;

import org.apache.commons.math3.analysis.function.Sigmoid;

public class SigmoidActivationFunctionTest {

	public static void main(String[] args) {
		Sigmoid sigmoid = new Sigmoid(0, 1);
		System.out.println("output: " + sigmoid.value(0.9526));
//		System.out.println("output: " + sigmoid.value(0));
	}
}
