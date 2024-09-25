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

    @Column(length = 4)
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    @Builder
    private ArticleImage(String imageUrl, String description, String type, Article article) {
        this.imageUrl = imageUrl;
        this.description = description;
        this.type = type;
        this.article = article;
    }
}
