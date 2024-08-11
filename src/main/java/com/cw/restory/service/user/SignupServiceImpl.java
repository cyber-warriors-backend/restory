package com.cw.restory.service.user;

import com.cw.restory.domain.user.entity.User;
import com.cw.restory.domain.user.repository.UserRepository;
import com.cw.restory.exception.custom.isExistedUser;
import com.cw.restory.web.user.request.SignupRequest;
import com.cw.restory.web.user.response.SignupResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SignupServiceImpl implements SingupService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public SignupResponse signup(SignupRequest signupRequest) {

        Optional<User> user = userRepository.findByLoginId(signupRequest.loginId());
        if(user.isPresent()) throw new isExistedUser();

        String encode = passwordEncoder.encode(signupRequest.password());

        User signUpUser = userRepository.save(User.builder()
                .loginId(signupRequest.loginId())
                .password(encode)
                .build());

        return new SignupResponse(signUpUser.getId(), signUpUser.getLoginId());
    }
}
