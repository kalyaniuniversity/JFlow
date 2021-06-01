package com.debacharya.jflow.datamodel;

import java.util.Arrays;
import java.util.List;

public class NumericDataMatrix extends AbstractDataMatrix<NumericColumn, StringColumn> {

	public NumericDataMatrix(List<NumericColumn> columns) {
		super(columns, null, false);
	}

	public NumericDataMatrix(List<NumericColumn> columns, StringColumn classLabels) {
		super(columns, classLabels, true);
	}

	public NumericDataMatrix(List<NumericColumn> columns, List<String> classLabels) {
		super(
			columns,
			new StringColumn(
				classLabels,
				AbstractDataMatrix.CLASS_LABEL
			),
			true
		);
	}

	public NumericDataMatrix(List<NumericColumn> columns, String[] classLabels) {
		this(columns, Arrays.asList(classLabels));
	}
}
