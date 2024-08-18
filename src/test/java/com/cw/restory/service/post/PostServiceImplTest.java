package com.cw.restory.service.post;

import com.cw.restory.domain.post.entity.Post;
import com.cw.restory.domain.post.entity.PostImage;
import com.cw.restory.domain.post.enums.City;
import com.cw.restory.domain.post.enums.Type;
import com.cw.restory.domain.post.repository.PostImageRepository;
import com.cw.restory.domain.post.repository.PostRepository;
import com.cw.restory.web.common.response.CommonListResponse;
import com.cw.restory.web.post.request.PostGetRequest;
import com.cw.restory.web.post.response.PostResponse;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class PostServiceImplTest {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostImageRepository postImageRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("게시글 목록 조회에서 1페이지에 해당하는 게시글 10개를 조회한다.")
    void getPostAll() {

        //given
        List<Post> postList = IntStream.range(0, 15)
                .mapToObj(i -> Post.builder()
                        .title((i+1) + "번 게시글 제목")
                        .type(Type.CAFE)
                        .content((i+1) + "번 게시글 콘텐트")
                        .latitude(36.0)
                        .longitude(36.0)
                        .address("주소")
                        .city(City.SEOUL)
                        .copyright(true)
                        .build()).toList();
        postRepository.saveAll(postList);

        List<PostImage> postImageList = IntStream.range(0, 3)
                .mapToObj(i -> PostImage.builder()
                        .imageUrl((i+1) + "번 이미지 url")
                        .description((i+1) + "번 이미지 설명")
                        .post(postList.get(0))
                        .build()).toList();
        postImageRepository.saveAll(postImageList);

        List<PostImage> postImageList2 = IntStream.range(0, 2)
                .mapToObj(i -> PostImage.builder()
                        .imageUrl((i+4) + "번 이미지 url")
                        .description((i+4) + "번 이미지 설명")
                        .post(postList.get(1))
                        .build()).toList();
        postImageRepository.saveAll(postImageList2);

        em.clear();

        //when
        CommonListResponse<PostResponse> postAll = postService.getPostAll(PostGetRequest.builder()
                .build());

        //then
        assertThat(postAll.count()).isEqualTo(10);
        assertThat(postAll.data().get(0).getPostImages().size()).isEqualTo(3);
    }
}