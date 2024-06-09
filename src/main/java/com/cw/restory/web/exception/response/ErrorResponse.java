package com.cw.restory.web.exception.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResponse {
    private final Integer code;
    private final String message;
    private final Map<String, String> validation;

    @Builder
    public ErrorResponse(Integer code, String message, Map<String, String> validation) {
        this.code = code;
        this.message = message == null ? "" : message;
        this.validation = validation == null ? new HashMap<>() : validation;
    }
}
