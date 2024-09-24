package com.cw.restory.service.article;

import com.cw.restory.domain.article.entity.Article;
import com.cw.restory.domain.article.repository.ArticleRepository;
import com.cw.restory.exception.custom.ArticleNotFound;
import com.cw.restory.web.article.response.ArticleResponse;
import com.cw.restory.web.common.response.CommonListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService{

    private final ArticleRepository articleRepository;

    @Override
    public CommonListResponse<ArticleResponse> getAllArticle() {

        List<ArticleResponse> list = articleRepository.findAllArticleWithImage()
                .stream().map(A -> ArticleResponse.builder()
                        .article(A).build())
                .toList();

        return new CommonListResponse<>(list.size(), list);
    }

    @Override
    public ArticleResponse getOneArticle(Long id) {
        Article article = articleRepository.findOneArticleWithImage(id)
                .orElseThrow(ArticleNotFound::new);

        article.formatContent(article.getFormatText(article.getContent()));

        return ArticleResponse.builder().article(article)
                .build();
    }

}
