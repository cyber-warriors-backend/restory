package com.cw.restory.web.post.controller;

import com.cw.restory.service.post.PostService;
import com.cw.restory.web.common.response.CommonListResponse;
import com.cw.restory.web.post.request.PostGetRequest;
import com.cw.restory.web.post.response.PostResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "게시글 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Operation(summary = "게시글 목록 조회", description = "필터에 해당하는 모든 게시글을 조회합니다.")
    @GetMapping
    public ResponseEntity<CommonListResponse<PostResponse>> getPostAll(@Validated PostGetRequest postRequest){
        return ResponseEntity.ok().body(postService.getPostAll(postRequest));
    }

    @Operation(summary = "게시글 상세 조회", description = "게시글 키값(ID)으로 게시글 1개를 조회합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPostOne(@PathVariable Long id){
        return ResponseEntity.ok().body(postService.getPostOne(id));
    }
}
