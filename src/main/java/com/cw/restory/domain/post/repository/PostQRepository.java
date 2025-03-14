package com.cw.restory.domain.post.repository;

import com.cw.restory.domain.post.entity.Post;
import com.cw.restory.web.post.request.PostGetRequest;
import com.querydsl.core.Tuple;

import java.util.List;

public interface PostQRepository {
    List<Post> findAllByFilters(PostGetRequest postGetRequest);
    List<Tuple> findCountByCityFilters();
}