package com.cw.restory.web.user.controller;

import com.cw.restory.service.user.SingupService;
import com.cw.restory.web.user.request.SignupRequest;
import com.cw.restory.web.user.response.SignupResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@Tag(name = "회원가입 API", description = "회원가입 API 입니다.")
@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final SingupService signupService;

//    @Operation(summary = "일반 회원가입", description = "일반 회원가입 API 입니다.")
    @PostMapping("/auth/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody @Validated SignupRequest signupRequest){
        return ResponseEntity.ok()
                .body(signupService.signup(signupRequest));
    }

}
