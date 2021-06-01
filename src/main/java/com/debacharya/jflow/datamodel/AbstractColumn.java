package com.debacharya.jflow.datamodel;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AbstractColumn<T extends AbstractDataPoint<?>> {
	@Setter(AccessLevel.NONE)
	private final String columnName;
	private List<T> dataPoints;
}
