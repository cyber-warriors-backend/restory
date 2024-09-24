package com.cw.restory.web.article.response;

import com.cw.restory.domain.article.entity.ArticleImage;
import com.cw.restory.domain.post.entity.PostImage;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ArticleImageResponse {
    private Long id;
    private String imageUrl;
    private String description;
    private String type;
    private static final String IMAGE_URL_PREFIX = "https://img.restory.site/";

    @Builder
    public ArticleImageResponse(ArticleImage articleImage) {
        this.id = articleImage.getId();
        this.imageUrl = articleImage.getImageUrl() == null ? "" : IMAGE_URL_PREFIX + articleImage.getImageUrl();
        this.description = articleImage.getDescription();
        this.type = articleImage.getType();
    }
}
