package com.cw.restory.web.information.response;

import com.cw.restory.domain.information.entity.Information;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class InformationResponse {

    private Long id;

    private String title;

    private String content;

    private String createdAt;

    private String updatedAt;

    private String createdBy;

    private String updatedBy;

    @Builder
    public InformationResponse(Information information) {
        this.id = information.getId();
        this.title = information.getTitle();
        this.content = information.getContent();
        this.createdAt = information.getCreatedAt().format(formatter);
        this.updatedAt = information.getUpdatedAt().format(formatter);
        this.createdBy = information.getCreatedBy();
        this.updatedBy = information.getUpdatedBy();
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd");
}
