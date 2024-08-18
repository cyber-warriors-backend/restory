package com.cw.restory.domain.post.entity;

import com.cw.restory.domain.post.enums.City;
import com.cw.restory.domain.post.enums.Type;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

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

    private Boolean isEditorPick;

    @OneToMany(mappedBy = "post")
    @BatchSize(size = 150)
    private List<PostImage> postImages;

    @Builder
    public Post(String title, Type type, String summary, String content, String subContent, City city, String address, Double latitude, Double longitude, String remark, Boolean copyright, String telephone, String duration, String holiday, String url, Boolean isEditorPick) {
        this.title = title;
        this.type = type;
        this.summary = summary;
        this.content = content;
        this.subContent = subContent;
        this.city = city;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.remark = remark;
        this.copyright = copyright;
        this.telephone = telephone;
        this.duration = duration;
        this.holiday = holiday;
        this.url = url;
        this.isEditorPick = isEditorPick;
    }
}
