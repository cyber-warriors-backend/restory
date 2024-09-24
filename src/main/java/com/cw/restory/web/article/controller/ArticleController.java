package com.cw.restory.web.article.controller;

import com.cw.restory.service.article.ArticleService;
import com.cw.restory.web.article.response.ArticleResponse;
import com.cw.restory.web.common.response.CommonListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "아티클 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    @Operation(summary = "아티클 전체 조회", description = "모든 아티클을 조회합니다.")
    @GetMapping
    public ResponseEntity<CommonListResponse<ArticleResponse>> getAllArticle() {
        return ResponseEntity.ok().body(articleService.getAllArticle());
    }

    @Operation(summary = "아티클 상세 조회", description = "아티클 키값(ID)으로 아티크르 1개를 조회합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> getOneArticle(@PathVariable Long id) {
        return ResponseEntity.ok().body(articleService.getOneArticle(id));
    }

}
