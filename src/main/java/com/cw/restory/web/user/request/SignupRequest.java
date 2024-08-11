package com.cw.restory.web.user.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(title = "회원가입 요청")
public record SignupRequest(
        @Schema(description = "아이디", example = "qwerty")
        @NotBlank(message = "아이디를 입력해주세요")
        String loginId,
        @Schema(description = "비밀번호", example = "1234")
        @NotBlank(message = "비밀번호를 입력해주세요")
        String password

) {}
