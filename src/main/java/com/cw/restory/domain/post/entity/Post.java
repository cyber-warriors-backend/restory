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
    public String getFormatText(String text) {
        // '.'을 기준으로 문자열을 분할
        String[] sentences = text.split("\\.");
        // 결과를 저장할 StringBuilder 객체 생성
        StringBuilder formattedText = new StringBuilder();
        // 분할된 문장들을 순회하며 개행 문자 추가
        for (String sentence : sentences) {
            // 공백만 있는 문장은 제외
            if (!sentence.trim().isEmpty()) {
                // 문장 뒤에 '.'과 개행 문자 추가
                formattedText.append(sentence.trim()).append(".\n");
            }
        }
        // 마지막 개행 문자를 제외한 최종 문자열 반환
        return formattedText.toString().trim();
    }

    public void formatContent(String content) {
        this.content = content;
    }

    public void formatSubContent(String subContent) {
        this.subContent = subContent;
    }
}
