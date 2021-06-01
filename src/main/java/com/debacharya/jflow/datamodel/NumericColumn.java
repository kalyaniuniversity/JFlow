package com.debacharya.jflow.datamodel;

import lombok.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class NumericColumn extends AbstractColumn<NumericDataPoint> {

	public NumericColumn(@NonNull String columnName) {
		super(columnName);
	}

	public NumericColumn(@NonNull List<Double> values, @NonNull String columnName) {
		super(columnName);
		this.setDataPoints(
			values
				.stream()
				.map(NumericDataPoint::new)
				.collect(Collectors.toList())
		);
	}

	public NumericColumn(@NonNull Double[] values, @NonNull String columnName) {
		this(Arrays.asList(values), columnName);
	}

	public NumericColumn(@NonNull double[] values, @NonNull String columnName) {
		this(
			DoubleStream
				.of(values)
				.boxed()
				.collect(Collectors.toList()),
			columnName
		);
	}
}
