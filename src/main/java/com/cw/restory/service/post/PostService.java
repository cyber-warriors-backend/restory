package com.cw.restory.service.post;

import com.cw.restory.web.common.response.CommonListResponse;
import com.cw.restory.web.post.request.PostGetRequest;
import com.cw.restory.web.post.response.PostResponse;

public interface PostService {
    public CommonListResponse<PostResponse> getPostAll(PostGetRequest postRequest);
    public PostResponse getPostOne(Long id);
}
