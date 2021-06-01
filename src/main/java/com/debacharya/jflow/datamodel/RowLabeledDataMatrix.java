package com.debacharya.jflow.datamodel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RowLabeledDataMatrix extends AbstractDataMatrix<NumericColumn, StringColumn> {
	private StringColumn rowLabels;
}
