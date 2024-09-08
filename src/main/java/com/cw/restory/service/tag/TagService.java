package com.cw.restory.service.tag;

import com.cw.restory.web.common.response.CommonListResponse;
import com.cw.restory.web.tag.request.TagGetRequest;
import com.cw.restory.web.tag.response.TagResponse;

public interface TagService {
    public CommonListResponse<TagResponse> getTagAll(TagGetRequest tagGetRequest);
}
