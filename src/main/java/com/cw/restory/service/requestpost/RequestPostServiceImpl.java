package com.cw.restory.service.requestpost;

import com.cw.restory.domain.requestpost.entity.RequestPost;
import com.cw.restory.domain.requestpost.repository.RequestPostRepository;
import com.cw.restory.web.requestpost.request.RequestPostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RequestPostServiceImpl implements RequestPostService {
    private final RequestPostRepository requestPostRepository;
    @Override
    public Long requestPost(RequestPostRequest requestPostRequest) {

        RequestPost requestPost = requestPostRepository.save(RequestPost.builder()
                .requestPostRequest(requestPostRequest)
                .build());

        return requestPost.getId();
    }

}
