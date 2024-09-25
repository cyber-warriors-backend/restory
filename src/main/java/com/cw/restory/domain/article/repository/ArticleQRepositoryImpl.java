package com.cw.restory.domain.article.repository;


import com.cw.restory.domain.article.entity.Article;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.cw.restory.domain.article.entity.QArticle.article;

@RequiredArgsConstructor
public class ArticleQRepositoryImpl implements ArticleQRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Article> findAllArticleWithImage() {
        return jpaQueryFactory.selectFrom(article)
                .leftJoin(article.articleImages)
                .fetchJoin()
                .fetch();
    }

    @Override
    public Optional<Article> findOneArticleWithImage(Long id) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(article)
                .leftJoin(article.articleImages)
                .where(article.id.eq(id))
                .fetchJoin()
                .fetchOne());
    }
}
