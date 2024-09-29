package com.cw.restory.web.requestpost.controller;

import com.cw.restory.service.requestpost.RequestPostService;
import com.cw.restory.web.requestpost.request.RequestPostRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "재생공간 등록 요청 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/requestposts")
public class RequestPostController {
    private final RequestPostService requestPostService;

    @Operation(summary = "재생공간 등록 요청", description = "재생공간 등록 요청")
    @PostMapping
    public ResponseEntity<Void> requestPlace(@Validated @RequestBody RequestPostRequest requestPostRequest){
        requestPostService.requestPost(requestPostRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
