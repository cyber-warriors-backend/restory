package com.cw.restory.domain.post.repository;

import com.cw.restory.domain.post.entity.Post;
import com.cw.restory.domain.post.enums.City;
import com.cw.restory.domain.post.enums.Type;
import com.cw.restory.web.post.request.PostGetRequest;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.cw.restory.domain.post.entity.QPost.post;

@RequiredArgsConstructor
public class PostQRepositoryImpl implements PostQRepository{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Tuple> findCountByCityFilters() {
        return jpaQueryFactory
                .select(post.city, post.city.count().as("cnt"))
                .from(post)
                .groupBy(post.city)
                .fetch();
    }

    @Override
    public List<Post> findAllByFilters(PostGetRequest postGetRequest) {
        return jpaQueryFactory
                .selectFrom(post)
                .where(findByCity(postGetRequest.city()), findByType(postGetRequest.type()), post.copyright.eq(true))
                .offset(postGetRequest.offset())
                .limit(postGetRequest.size())
                .fetch();
                //todo 공통 키워드 검색 추가(제목, 서브타입 like) + orderby / if (파라미터 == distance) -> 거리순 정렬 기능 추가
    }

    private BooleanExpression findByCity(String city) {
        return StringUtils.hasText(city) ? post.city.eq(City.valueOf(city)) : null;
    }

    private BooleanExpression findByType(String type) {
        return StringUtils.hasText(type) ? post.type.eq(Type.valueOf(type)) : null;
    }
}
