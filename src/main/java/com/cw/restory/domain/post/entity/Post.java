package com.cw.restory.domain.post.entity;

import com.cw.restory.domain.post.enums.City;
import com.cw.restory.domain.post.enums.Type;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Post{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Type type;

    private String summary;

    @Lob
    @Column(nullable = false)
    private String content;

    @Lob
    private String subContent;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, length = 10)
    private City city;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    private String remark;

    private Boolean copyright;

    private String telephone;

    private String duration;

    private String holiday;

    private String url;

    @OneToMany(mappedBy = "post")
    private List<PostImage> postImages;
}
