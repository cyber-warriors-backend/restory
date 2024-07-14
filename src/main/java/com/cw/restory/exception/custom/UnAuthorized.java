package com.cw.restory.exception.custom;

import com.cw.restory.exception.ApiException;

public class UnAuthorized extends ApiException {
    public UnAuthorized(String message) {
        super("로그인이 필요합니다.");
    }
    @Override
    public int getStatusCode() {
        return 401;
    }
}
