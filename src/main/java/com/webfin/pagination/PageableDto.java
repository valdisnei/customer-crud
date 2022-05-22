package com.webfin.pagination;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@ApiModel(description = "Paging object")
public class PageableDto {

	@ApiModelProperty(notes = "Indicates the number of the element obtained according to the underlying page and the page size")
	private final Integer offset;

	@ApiModelProperty(example = "1000", dataType = "integer", notes = "Number of elements returned on the current page")
	private final Integer pageSize;

	@ApiModelProperty(example = "1", dataType = "integer", notes = "Returned page number")
	private final Integer pageNumber;

	@ApiModelProperty(example = "false", dataType = "boolean", notes = "Returns if the request does not contain paging information")
	private final Boolean unpaged;

	@ApiModelProperty(example = "false", dataType = "boolean", notes = "Returns whether the request contains paging information")
	private final Boolean paged;
}
