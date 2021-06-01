package com.debacharya.jflow.datamodel;

import lombok.*;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AbstractDataMatrix<T extends AbstractColumn<?>, S extends AbstractColumn<?>> {

	public static final String CLASS_LABEL = "class label";

	private List<T> columns;
	private S classLabels;
	private boolean classLabeled;

	public void setColumns(@NonNull T[] columns) {
		this.columns = Arrays.asList(columns);
	}

	public void setClassLabels(@NonNull S classLabels) {
		this.classLabels = classLabels;
		this.classLabeled = true;
	}
}
