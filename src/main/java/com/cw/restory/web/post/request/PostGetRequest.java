package com.cw.restory.web.post.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Schema(title = "게시글 목록 조회 요청 DTO")
public record PostGetRequest(
        @Schema(description = "페이지당 보여줄 데이터 개수", example = "10", defaultValue = "10")
        @Min(value = 1, message = "최솟값은 1입니다.")
        @Max(value = 1000, message = "최댓값은 1입니다.")
        @Positive(message = "양수만 가능합니다.")
        Integer size,
        @Schema(description = "해당 페이지 번호", example = "1", defaultValue = "1")
        @Min(value = 1, message = "최솟값은 1입니다.")
        @Max(value = 100, message = "최댓값은 100입니다.")
        @Positive(message = "양수만 가능합니다.")
        Integer page,
        @Schema(description = "지역 필터로 검색 시 사용할 지역 코드", example = "SEOUL")
        String city,
        @Schema(description = "타입 필터로 검색 시 사용할 타입 코드", example = "CAFE")
        String type
)
{
    @Builder
    public PostGetRequest(Integer size, Integer page, String city, String type) {
        this.size = (size == null) || (size < 1) ? 10 : size;
        this.page = (page == null) || (page < 1) ? 1 : page;
        this.city = city == null ? "" : city;
        this.type = type == null ? "" : type;
    }

    public Integer offset(){
        return (this.page - 1) * size;
    }
}
