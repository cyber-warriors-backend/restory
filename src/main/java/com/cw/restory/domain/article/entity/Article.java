package com.cw.restory.domain.article.entity;

import com.cw.restory.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String thumbnail;

    @OneToMany(mappedBy = "article")
    private List<ArticleImage> articleImages;

    @Builder
    private Article(String title, String content, String thumbnail, List<ArticleImage> articleImages) {
        this.title = title;
        this.content = content;
        this.thumbnail = thumbnail;
        this.articleImages = articleImages;
    }
}
