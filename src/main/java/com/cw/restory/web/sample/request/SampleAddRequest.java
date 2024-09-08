package com.cw.restory.web.sample.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record SampleAddRequest(
        @NotNull(message = "정수를 입력해주세요")
        @Max(value = 999, message = "3자리까지만 가능합니다.")
        @Min(value = -999, message = "3자리까지만 가능합니다.")
        Integer a,
        @NotNull(message = "정수를 입력해주세요")
        @Max(value = 999, message = "3자리까지만 가능합니다.")
        @Min(value = -999, message = "3자리까지만 가능합니다.")
        Integer b

) {}