package com.cw.restory.service.article;

import com.cw.restory.web.article.response.ArticleResponse;
import com.cw.restory.web.common.response.CommonListResponse;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Override
    public CommonListResponse<ArticleResponse> getAllArticle() {
        return null;
    }

    @Override
    public ArticleResponse getOneArticle(Long id) {
        return null;
    }

}
