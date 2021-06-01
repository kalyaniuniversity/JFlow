package com.debacharya.jflow.datamodel;

import lombok.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringColumn extends AbstractColumn<StringDataPoint> {

	public StringColumn(@NonNull String columnName) {
		super(columnName);
	}

	public StringColumn(@NonNull List<String> values, @NonNull String columnName) {
		super(columnName);
		this.setDataPoints(
			values
				.stream()
				.map(StringDataPoint::new)
				.collect(Collectors.toList())
		);
	}

	public StringColumn(@NonNull String[] values, @NonNull String columnName) {
		this(Arrays.asList(values), columnName);
	}
}
