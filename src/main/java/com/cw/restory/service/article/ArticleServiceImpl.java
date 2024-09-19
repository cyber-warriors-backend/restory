package com.cw.restory.service.article;

import com.cw.restory.domain.article.repository.ArticleRepository;
import com.cw.restory.exception.custom.ArticleNotFound;
import com.cw.restory.web.article.response.ArticleResponse;
import com.cw.restory.web.common.response.CommonListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService{

    private final ArticleRepository articleRepository;

    @Override
    public CommonListResponse<ArticleResponse> getAllArticle() {
        return null;
    }

    @Override
    public ArticleResponse getOneArticle(Long id) {
        return ArticleResponse.builder().article(articleRepository.findOneArticleWithImage(id)
                .orElseThrow(ArticleNotFound::new))
                .build();
    }

}
