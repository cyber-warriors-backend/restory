package com.cw.restory.web.tag.controller;

import com.cw.restory.service.tag.TagService;
import com.cw.restory.web.common.response.CommonListResponse;
import com.cw.restory.web.tag.request.TagGetRequest;
import com.cw.restory.web.tag.response.TagResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "태그 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
public class TagController {
    private final TagService tagService;
    @Operation(summary = "태그 목록 조회", description = "추천검색어로 사용할 태그 목록입니다.")
    @GetMapping
    public ResponseEntity<CommonListResponse<TagResponse>> getTagAll(@Validated TagGetRequest tagGetRequest){
        return ResponseEntity.ok().body(tagService.getTagAll(tagGetRequest));
    }
}
