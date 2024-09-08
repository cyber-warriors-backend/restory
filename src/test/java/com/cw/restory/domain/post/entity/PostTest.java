package com.cw.restory.domain.post.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    @Test
    void formatText() {
        Post post = new Post();
        String text = "포천 아트벨리는 버려진 폐채석장을 자연과 문화·예술이 함께 살아 숨 쉬는 친환경 복합문화예술공간으로 만든 전 세계에서도 그 유례를 찾아보기 힘든 매우 매력적인 공간입니다. 2009년 개장하여 많은 학계에 관심을 받아왔으며, 특히 지질자원의 보고로 인정받아 한탄강 지질 공원과 함께 대한민국의 명소로 선정되었습니다. 화강암을 파고 들어간 웅덩이에 빗물과 샘물이 유입되어 생겨난 천주호는 주변의 직벽과 함께 이국적 풍경이 펼쳐집니다.";
        String formattedText = """
                        포천 아트벨리는 버려진 폐채석장을 자연과 문화·예술이 함께 살아 숨 쉬는 친환경 복합문화예술공간으로 만든 전 세계에서도 그 유례를 찾아보기 힘든 매우 매력적인 공간입니다.
                        2009년 개장하여 많은 학계에 관심을 받아왔으며, 특히 지질자원의 보고로 인정받아 한탄강 지질 공원과 함께 대한민국의 명소로 선정되었습니다.
                        화강암을 파고 들어간 웅덩이에 빗물과 샘물이 유입되어 생겨난 천주호는 주변의 직벽과 함께 이국적 풍경이 펼쳐집니다.""";

        Assertions.assertThat(post.getFormatText(text)).isEqualTo(formattedText);
    }
}