package com.cw.restory.domain.post.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;
    private String description;
    @Column(length = 4)
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @Builder
    public PostImage(String imageUrl, String description, String type, Post post) {
        this.imageUrl = imageUrl;
        this.description = description;
        this.type = type;
        this.post = post;
    }
}
