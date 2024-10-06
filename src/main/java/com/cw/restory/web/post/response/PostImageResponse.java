package com.cw.restory.web.post.response;

import com.cw.restory.domain.post.entity.PostImage;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostImageResponse {
    private final Long id;
    private final String imageUrl;
    private final String description;
    private final String type;
    private static final String IMAGE_URL_PREFIX = "https://img.restory.site/posts/";
    @Builder
    public PostImageResponse(PostImage postImage) {
        this.id = postImage.getId();
        this.imageUrl = postImage.getImageUrl() == null ? "" : IMAGE_URL_PREFIX + postImage.getImageUrl() ;
        this.description = postImage.getDescription();
        this.type = postImage.getType();
    }
}
