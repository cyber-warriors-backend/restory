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
                        .distance(calculateDistance(postRequest.latitude(), postRequest.longitude(), p.getLatitude(), p.getLongitude()))
                        .build())
                .toList();

        return new CommonListResponse<PostResponse>(list.size(), list);
    }

    @Override
    public PostResponse getPostOne(Long id) {
        Post post = postRepository.findById(id).orElseThrow(PostNotFound::new);

        post.formatContent(post.getFormatText(post.getContent()));
        post.formatSubContent(post.getFormatText(post.getSubContent()));

        return PostResponse.builder()
                .post(post)
                .build();
    }

    private String calculateDistance(Double lat1, Double lon1, Double lat2, Double lon2) {
        if (lat1 == null || lon1 == null || lat2 == null || lon2 == null) {
            return "";
        }

        final int R = 6371; // 지구의 반지름 (킬로미터)
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return formatDistance(R * c); // 킬로미터
    }

    private String formatDistance(double distanceInKm) {
        if (distanceInKm >= 1) {
            return String.valueOf(Math.round(distanceInKm)) + "km";
        }
        return String.valueOf(Math.round(distanceInKm * 1000)) + "m";

    }

}
