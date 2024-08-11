package com.cw.restory.web.post.response;

import com.cw.restory.domain.post.entity.Post;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Schema(title = "게시글 목록 조회 응답 DTO")
public class PostResponse{
    private final Long id;
    private final String title;
    private final String type;
    private final String summary;
    private final String content;
    private final String subContent;
    private final String city;
    private final String address;
    private final Double latitude;
    private final Double longitude;
    private final String remark;
    private final String telephone;
    private final String duration;
    private final String holiday;
    private final String url;
    private final List<PostImageResponse> postImages;
    @Builder
    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.type = post.getType().getDescription();
        this.summary = post.getSummary();
        this.content = post.getContent();
        this.subContent = post.getSubContent();
        this.city = post.getCity().getDescription();
        this.address = post.getAddress();
        this.latitude = post.getLatitude();
        this.longitude = post.getLongitude();
        this.remark = post.getRemark();
        this.telephone = post.getTelephone();
        this.duration = post.getDuration();
        this.holiday = post.getHoliday();
        this.url = post.getUrl();
        this.postImages = post.getPostImages().stream()
                .map(p -> PostImageResponse.builder()
                        .postImage(p)
                        .build())
                .toList();
    }
}



