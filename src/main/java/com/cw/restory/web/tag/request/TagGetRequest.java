package com.cw.restory.web.tag.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Builder;

@Schema(title = "태그 목록 조회 요청 DTO")
public record TagGetRequest(
        @Schema(description = "보여줄 데이터 개수", example = "6", defaultValue = "6")
        @Min(value = 1, message = "최솟값은 1입니다.")
        @Max(value = 1000, message = "최댓값은 1000입니다.")
        @Positive(message = "양수만 가능합니다.")
        Integer size
)
{
    @Builder
    public TagGetRequest(Integer size) {
        this.size = (size == null) || (size < 1) ? 6 : size;
    }
}
