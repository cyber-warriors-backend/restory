package com.cw.restory.domain.post.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum City {
    ALL("전국"),
    GANGWON("강원"),
    GYEONGGI("경기"),
    GYEONGNAM("경남"),
    GYEONGBUK("경북"),
    GWANGJU("광주"),
    DAEGU("대구"),
    DAEJEON("대전"),
    BUSAN("부산"),
    SEOUL("서울"),
    ULSAN("울산"),
    INCHEON("인천"),
    JEJU("제주"),
    JEONNAM("전남"),
    JEONBUK("전북"),
    CHUNGNAM("충남"),
    CHUNGBUK("충북");

    private final String description;
}
