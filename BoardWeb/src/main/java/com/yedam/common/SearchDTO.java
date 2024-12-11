package com.yedam.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //AllArgs를 다가져오는 생성자.
public class SearchDTO {
	private int page;
	private String searchCondition;
	private String keyword;
}
