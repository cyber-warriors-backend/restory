package com.cw.restory.web.information.response;

import com.cw.restory.domain.information.entity.Information;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class InformationResponse {

    private Long id;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String createdBy;

    private String updatedBy;

    @Builder
    public InformationResponse(Information information) {
        this.id = information.getId();
        this.title = information.getTitle();
        this.content = information.getContent();
        this.createdAt = information.getCreatedAt();
        this.updatedAt = information.getUpdatedAt();
        this.createdBy = information.getCreatedBy();
        this.updatedBy = information.getUpdatedBy();
    }
}
