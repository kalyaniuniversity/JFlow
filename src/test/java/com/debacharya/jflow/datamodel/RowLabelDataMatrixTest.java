package com.debacharya.jflow.datamodel;

import org.junit.Test;

public class RowLabelDataMatrixTest {

	String[] names = {
		"Alice",
		"Bob",
		"Charlie",
		"Diana"
	};

	double[] weights = { 133, 160, 152, 120 };
	double[] heights = { 65, 72, 70, 60 };
	String[] genders = { "F", "M", "M", "F" };

	@Test
	public void representData() {

		RowLabeledDataMatrix matrix = new RowLabeledDataMatrix();
		StringColumn rowLabels = new StringColumn(this.names, "Name");
		NumericColumn weightColumn = new NumericColumn(this.weights, "Weight (lb)");
		NumericColumn heightColumn = new NumericColumn(this.heights, "Height (in)");
		StringColumn classLabels = new StringColumn(this.genders, "Gender");

		matrix.setRowLabels(rowLabels);
		matrix.setClassLabels(classLabels);
		matrix.setColumns(new NumericColumn[] {
			weightColumn,
			heightColumn
		});

		System.out.println(matrix.toString());
	}
}
