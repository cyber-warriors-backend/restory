package com.cw.restory.web.article.response;

import com.cw.restory.domain.article.entity.Article;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ArticleResponse {

    private Long id;
    private String title;
    private String content;
    private List<ArticleImageResponse> articleImages;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public ArticleResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreatedAt();
        this.updatedAt = article.getUpdatedAt();
        this.articleImages = article.getArticleImages().stream()
                .map(articleImage -> ArticleImageResponse.builder()
                        .articleImage(articleImage)
                        .build())
                .toList();
    }

}
