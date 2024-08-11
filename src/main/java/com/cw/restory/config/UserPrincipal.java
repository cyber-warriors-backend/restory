package com.cw.restory.config;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class UserPrincipal extends User {

    private final Long id;

    public UserPrincipal(com.cw.restory.domain.user.entity.User user){
        super(user.getLoginId(), user.getPassword(), List.of(
                new SimpleGrantedAuthority("ROLE_USER")
//                new SimpleGrantedAuthority("READ")
        ));
        this.id = user.getId();
    }
    public Long getId() {
        return id;
    }
}
