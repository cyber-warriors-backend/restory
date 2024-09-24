package com.cw.restory.service.article;

import com.cw.restory.domain.article.entity.Article;
import com.cw.restory.domain.article.entity.ArticleImage;
import com.cw.restory.domain.article.repository.ArticleImageRepository;
import com.cw.restory.domain.article.repository.ArticleRepository;
import com.cw.restory.domain.post.entity.PostImage;
import com.cw.restory.domain.post.repository.PostImageRepository;
import com.cw.restory.domain.post.repository.PostRepository;
import com.cw.restory.service.post.PostService;
import com.cw.restory.web.article.response.ArticleResponse;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class ArticleServiceImplTest {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleImageRepository articleImageRepository;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private EntityManager em;


    @Test
    void getOneArticle() {

        Article article = Article.builder()
                .title("아티클 제목")
                .content("아티클 내용")
                .build();

        articleRepository.save(article);

        List<ArticleImage> articleImages = IntStream.range(0, 3)
                .mapToObj(i -> ArticleImage.builder()
                        .imageUrl((i+1) + "번 이미지 url")
                        .description((i+1) + "번 이미지 설명")
                        .article(article)
                        .build()).toList();

        articleImageRepository.saveAll(articleImages);

        em.clear();

        ArticleResponse response = articleService.getOneArticle(article.getId());

        assertThat(response.getId()).isEqualTo(article.getId());
        assertThat(response.getArticleImages().size()).isEqualTo(3);
    }
}