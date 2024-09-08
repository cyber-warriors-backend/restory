package com.cw.restory.service.user;

import com.cw.restory.web.user.request.SignupRequest;
import com.cw.restory.web.user.response.SignupResponse;

public interface SingupService {
    SignupResponse signup(SignupRequest signupRequest);
}
