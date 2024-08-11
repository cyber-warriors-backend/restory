package com.cw.restory.web.post.controller;

import com.cw.restory.domain.post.enums.City;
import com.cw.restory.domain.post.enums.Type;
import com.cw.restory.web.post.response.SearchFilterResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Tag(name = "검색 필터 API")
@RestController
@RequestMapping("/filters")
public class PostSearchFilterController {

    @Operation(summary = "도시", description = "도시 필터 목록을 조회합니다.")
    @GetMapping("/city")
    public ResponseEntity<List<SearchFilterResponse>> getCityFilters(){
        List<SearchFilterResponse> filters = Arrays.stream(City.values())
                .map(e -> {
                    return new SearchFilterResponse(e.name(), e.getDescription());
                })
                .toList();

        return ResponseEntity.ok().body(filters);
    }

    @Operation(summary = "게시글 타입", description = "게시글 타입 필터 목록을 조회합니다.")
    @GetMapping("/type")
    public ResponseEntity<List<SearchFilterResponse>> getTypeFilters(){
        List<SearchFilterResponse> filters = Arrays.stream(Type.values())
                .map(e -> {
                    return new SearchFilterResponse(e.name(), e.getDescription());
                })
                .toList();
        return ResponseEntity.ok().body(filters);
    }
}
