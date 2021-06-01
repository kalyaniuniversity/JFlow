package com.debacharya.jflow.datamodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AbstractDataPoint<T> {
	private T value;
}
