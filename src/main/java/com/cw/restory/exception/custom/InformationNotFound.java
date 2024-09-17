package com.cw.restory.exception.custom;

import com.cw.restory.exception.ApiException;
import org.springframework.http.HttpStatus;

public class InformationNotFound extends ApiException {
    public InformationNotFound() {
        super("존재하지 않는 게시물입니다.");
    }
    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
