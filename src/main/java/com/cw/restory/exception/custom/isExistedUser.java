package com.cw.restory.exception.custom;

import com.cw.restory.exception.ApiException;
import org.springframework.http.HttpStatus;

public class isExistedUser extends ApiException {
    public isExistedUser() {
        super("이미 존재하는 아이디입니다.");
    }
    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
