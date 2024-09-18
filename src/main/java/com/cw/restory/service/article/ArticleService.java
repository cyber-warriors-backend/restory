package com.cw.restory.service.article;


import com.cw.restory.web.article.response.ArticleResponse;
import com.cw.restory.web.common.response.CommonListResponse;

public interface ArticleService {

    public CommonListResponse<ArticleResponse> getAllArticle();

    public ArticleResponse getOneArticle(Long id);

}
