package com.cw.restory.service.information;

import com.cw.restory.domain.information.entity.Information;
import com.cw.restory.domain.information.repository.InformationRepository;
import com.cw.restory.domain.post.repository.PostImageRepository;
import com.cw.restory.domain.post.repository.PostRepository;
import com.cw.restory.service.post.PostService;
import com.cw.restory.web.common.response.CommonListResponse;
import com.cw.restory.web.information.response.InformationResponse;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class InformationServiceImplTest {

    @Autowired
    private InformationRepository informationRepository;
    @Autowired
    private InformationService informationService;
    @Autowired
    private EntityManager em;

    @Test
    void getAllInformation() {

        //given
        List<Information> informations = IntStream.range(0, 15)
                .mapToObj(i -> Information.builder()
                        .title((i + 1) + "번 게시글 제목")
                        .content((i + 1) + "번 게시글 내용")
                        .createdBy((i + 1) + "번 게시글 생성자")
                        .updatedBy((i + 1) + "번 게시글 수정자")
                        .build()).toList();

        informationRepository.saveAll(informations);

        em.clear();

        CommonListResponse<InformationResponse> allInformation = informationService.getAllInformation();

        assertThat(allInformation.count()).isEqualTo(15);


    }

    @Test
    void getOneInformation() {
    }
}