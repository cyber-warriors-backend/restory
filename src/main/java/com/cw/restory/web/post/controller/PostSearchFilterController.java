package com.cw.restory.web.post.controller;

import com.cw.restory.domain.post.entity.QPost;
import com.cw.restory.domain.post.enums.City;
import com.cw.restory.domain.post.enums.Type;
import com.cw.restory.domain.post.repository.PostRepository;
import com.cw.restory.web.post.response.SearchFilterResponse;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Tag(name = "검색 필터 API")
@RestController
@RequestMapping("/filters")
@RequiredArgsConstructor
public class PostSearchFilterController {

    private final PostRepository postRepository;

    @Operation(summary = "도시", description = "도시 필터 목록과 도시별 데이터 갯수를 조회합니다.")
    @GetMapping("/city")
    public ResponseEntity<List<SearchFilterResponse>> getCityFilters(){

        List<Tuple> countByCityFilters = postRepository.findCountByCityFilters();

        Map<String, Long> cityCountMap = countByCityFilters.stream()
                .collect(Collectors.toMap(
                        tuple -> tuple.get(QPost.post.city).name(),
                        tuple -> tuple.get(Expressions.numberPath(Long.class, "cnt"))
                ));

        List<SearchFilterResponse> filters = Arrays.stream(City.values())
                .map(e -> {
                    Long cnt = cityCountMap.getOrDefault(e.name(), 0L);

                    return SearchFilterResponse.builder()
                            .code(e.name())
                            .description(e.getDescription())
                            .cnt(cnt) // cnt 추가
                            .build();
                })
                .toList();


        return ResponseEntity.ok().body(filters);
    }

    @Operation(summary = "게시글 타입", description = "게시글 타입 필터 목록을 조회합니다.")
    @GetMapping("/type")
    public ResponseEntity<List<SearchFilterResponse>> getTypeFilters(){
        List<SearchFilterResponse> filters = Arrays.stream(Type.values())
                .map(e -> SearchFilterResponse.builder()
                            .code(e.name())
                            .description(e.getDescription())
                            .build()
                )
                .toList();


        return ResponseEntity.ok().body(filters);
    }
}
