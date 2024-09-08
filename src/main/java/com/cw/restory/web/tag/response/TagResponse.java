package com.cw.restory.web.tag.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Schema(title = "태그 조회 웅답 DTO")
public class TagResponse {
    private final Long id;
    private final String name;

    @Builder
    public TagResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
