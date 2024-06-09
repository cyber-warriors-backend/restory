package com.cw.restory.web.sample.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(title = "sample 요청 dto")
public record SampleAddRequest(

        @Schema(description = "정수", example = "1")
        @NotNull(message = "정수를 입력해주세요")
        Integer a,
        Integer b

) {}