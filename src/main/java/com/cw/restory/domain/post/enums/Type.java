package com.cw.restory.domain.post.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum Type {
    CAFE("카페&음식점"),
    EXPERIENCE("체험"),
    CULTURE("문화공간"),
    STAY("숙박");

    private final String description;
}
