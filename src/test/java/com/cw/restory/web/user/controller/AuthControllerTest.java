package com.cw.restory.web.user.controller;

import com.cw.restory.domain.user.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntityManager em;

    @BeforeEach
    void clean() {userRepository.deleteAllInBatch();}
    @Test
    @DisplayName("로그인 성공 후 세션 응답 및 생성 세션 확인")
    void login() throws Exception {

//        String userId = "asdf1234";
//        String userPassword = "1234";
//
//        //given
//        User user = User.builder()
//                .loginId(userId)
//                .password(userPassword)
//                .build();
//
//        userRepository.save(user);
//
//        AuthRequest authRequest = new AuthRequest(userId, userPassword);
//
//        String json = objectMapper.writeValueAsString(authRequest);
//
//        //expected
//        mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.cookie().value("SESSION", user.getSessions().get(0).getToken()))
//                .andDo(MockMvcResultHandlers.print());
//
//        em.flush();
//
//        Assertions.assertThat(user.getSessions().size()).isEqualTo(1L);
    }
}