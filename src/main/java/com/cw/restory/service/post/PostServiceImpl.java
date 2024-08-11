package com.cw.restory.service.post;

import com.cw.restory.domain.post.entity.Post;
import com.cw.restory.domain.post.repository.PostRepository;
import com.cw.restory.exception.custom.PostNotFound;
import com.cw.restory.web.common.response.CommonListResponse;
import com.cw.restory.web.post.request.PostGetRequest;
import com.cw.restory.web.post.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;

    @Override
    public CommonListResponse<PostResponse> getPostAll(PostGetRequest postRequest) {
        List<PostResponse> list = postRepository.findAllByFilters(postRequest).stream()
                .map(p -> PostResponse.builder()
                        .post(p)
                        .build())
                .toList();

        return new CommonListResponse<PostResponse>(list.size(), list);
    }

    @Override
    public PostResponse getPostOne(Long id) {
        Post post = postRepository.findById(id).orElseThrow(PostNotFound::new);
        return PostResponse.builder()
                .post(post)
                .build();
    }
}
