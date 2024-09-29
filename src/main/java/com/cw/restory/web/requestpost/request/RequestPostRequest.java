package com.cw.restory.web.requestpost.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Builder;

@Schema(title = "재생공간 등록 요청 DTO")
public record RequestPostRequest(
        @Schema(description = "공간 이름", example = "재생공간의 이름을 입력해주세요.")
        @Size(max = 500, message = "500자를 넘을 수 없습니다.")
        @NotBlank(message = "필수값입니다.")
        String title,
        @Schema(description = "공간 주소", example = "요청사항을 입력해주세요.")
        @Size(max = 500, message = "500자를 넘을 수 없습니다.")
        @NotBlank(message = "필수값입니다.")
        String address,
        @Schema(description = "요청사항", example = "요청사항을 입력해주세요.")
        @Size(max = 500, message = "500자 이내로 입력해주세요.")
        @NotBlank(message = "필수값입니다.")
        String content
)
{
    @Builder
    public RequestPostRequest(String title, String address, String content) {
        this.title = title;
        this.address = address;
        this.content = content;
    }
}
