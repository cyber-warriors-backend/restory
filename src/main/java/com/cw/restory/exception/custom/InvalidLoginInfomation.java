package com.cw.restory.exception.custom;

import com.cw.restory.exception.ApiException;
import org.springframework.http.HttpStatus;

public class InvalidLoginInfomation extends ApiException {
    public InvalidLoginInfomation() {
        super("아이디 또는 비밀번호가 일치하지 않습니다.");
    }
    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
