package com.cw.restory.domain.requestpost.entity;

import com.cw.restory.domain.BaseTimeEntity;
import com.cw.restory.web.requestpost.request.RequestPostRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RequestPost extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String address;

    @Lob
    @Column(nullable = false)
    private String content;

    @Builder
    public RequestPost(RequestPostRequest requestPostRequest) {
        this.title = requestPostRequest.title();
        this.address = requestPostRequest.address();
        this.content = requestPostRequest.content();
    }
}
