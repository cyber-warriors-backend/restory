package com.cw.restory.exception.custom;

import com.cw.restory.exception.ApiException;
import org.springframework.http.HttpStatus;

public class UnAuthorized extends ApiException {
    public UnAuthorized() {
        super("로그인이 필요합니다.");
    }
    @Override
    public int getStatusCode() {
        return HttpStatus.UNAUTHORIZED.value();
    }
}
