package com.cw.restory.domain.information.entity;

import com.cw.restory.domain.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Information extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String createdBy;

    private String updatedBy;

    @Builder
    private Information(String title, String content, String createdBy, String updatedBy) {
        this.title = title;
        this.content = content;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
}
