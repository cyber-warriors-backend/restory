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

    @OneToMany(mappedBy = "article")
    private List<ArticleImage> articleImages;

    @Builder
    private Article(String title, String content, List<ArticleImage> articleImages) {
        this.title = title;
        this.content = content;
        this.articleImages = articleImages;
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

}
