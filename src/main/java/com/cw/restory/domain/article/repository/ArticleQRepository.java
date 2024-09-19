package com.cw.restory.domain.article.repository;

import com.cw.restory.domain.article.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleQRepository {
    List<Article> findAllArticleWithImage();

    Optional<Article> findOneArticleWithImage(Long id);

}
