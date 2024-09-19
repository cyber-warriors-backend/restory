package com.cw.restory.domain.article.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleImage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    @Builder
    private ArticleImage(String imageUrl, String description, Article article) {
        this.imageUrl = imageUrl;
        this.description = description;
        this.article = article;
    }
}
