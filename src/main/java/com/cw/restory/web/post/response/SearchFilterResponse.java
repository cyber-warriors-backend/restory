package com.cw.restory.web.post.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
//@Schema(title = "게시글 검색 필터 조회 웅답 DTO")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SearchFilterResponse{
    private final String code;
    private final String description;
    private final Long cnt;

    @Builder
    public SearchFilterResponse(String code, String description, Long cnt) {
        this.code = code;
        this.description = description;
        this.cnt = cnt;
    }
}
