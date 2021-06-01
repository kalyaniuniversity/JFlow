package com.debacharya.jflow.nn.datastructure.dendrite;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDendrite<S> {

	protected S value;

	public AbstractDendrite(S value) {
		this.value = value;
	}

	public static <T extends AbstractDendrite<?>> List<T> cloneDendrites(List<T> source) {

		List<T> destination = new ArrayList<>();

		for(T dendrite : source)
			destination.add(dendrite.getCopy());

		return destination;
	}

	public abstract S getValue();
	public abstract void setValue(S value);
	public abstract <T extends AbstractDendrite<?>> T getCopy();
}
