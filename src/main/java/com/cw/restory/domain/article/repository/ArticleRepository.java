package com.cw.restory.domain.article.repository;


import com.cw.restory.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long>, ArticleQRepository {

}
