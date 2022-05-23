package com.webfin.customers.pagination;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class ResponseDto<T> {
	@NotNull(message = "Response without content")
	private final List<T> content;
	private final PageableDto pageable;

	@ApiModelProperty(example = "0", dataType = "integer", notes = "Total number of pages")
	private final Integer totalPages;

	@ApiModelProperty(example = "true", notes = "Indicates whether the current page is the last")
	private final Boolean last;

	@ApiModelProperty(example = "15740", notes = "Total number of elements")
	private final Integer totalElements;

	@ApiModelProperty(example = "1000", notes = "Number of items per page")
	private final Integer size;

	@ApiModelProperty(example = "4", notes = "Returned page number")
	private final Integer pageNumber;

	@ApiModelProperty(example = "740", notes = "Number of elements returned on the current page")
	private final Integer numberOfElements;

	@ApiModelProperty(example = "1200", notes = "Indicates whether the returned page is the first")
	private final Boolean first;
}
