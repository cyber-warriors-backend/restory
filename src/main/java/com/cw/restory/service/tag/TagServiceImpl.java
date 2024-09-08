package com.cw.restory.service.tag;

import com.cw.restory.domain.tag.TagRepository;
import com.cw.restory.web.common.response.CommonListResponse;
import com.cw.restory.web.tag.request.TagGetRequest;
import com.cw.restory.web.tag.response.TagResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    @Override
    public CommonListResponse<TagResponse> getTagAll(TagGetRequest tagGetRequest) {
        List<TagResponse> list = tagRepository.findAllByRequestSize(tagGetRequest.size()).stream()
                .map(p -> TagResponse.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .build())
                .toList();

        return new CommonListResponse<TagResponse>(list.size(), list);
    }
}
