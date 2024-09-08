package com.cw.restory.domain.user.entity;

import com.cw.restory.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String nickname;
    private String email;
    private String imageUrl;
    private String originalImageName;
    private Boolean isLocationAgree;
    private Boolean isNotice;
    private Boolean isAgree;

    @Builder
    public User(String loginId, String password, String name, String nickname, String email, String imageUrl, String originalImageName, Boolean isLocationAgree, Boolean isNotice, Boolean isAgree) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.imageUrl = imageUrl;
        this.originalImageName = originalImageName;
        this.isLocationAgree = isLocationAgree;
        this.isNotice = isNotice;
        this.isAgree = isAgree;
    }
}
