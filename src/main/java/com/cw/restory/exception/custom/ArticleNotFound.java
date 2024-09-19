package com.cw.restory.exception.custom;

import com.cw.restory.exception.ApiException;
import org.springframework.http.HttpStatus;

public class ArticleNotFound extends ApiException {
    public ArticleNotFound() {
        super("존재하지 않는 아티클입니다.");
    }
    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
