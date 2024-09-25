package com.cw.restory.domain.post.repository;

import com.cw.restory.domain.post.entity.Post;
import com.cw.restory.domain.post.enums.City;
import com.cw.restory.domain.post.enums.Type;
import com.cw.restory.web.post.request.PostGetRequest;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.cw.restory.domain.post.entity.QPost.post;
import static com.cw.restory.domain.post.entity.QPostTag.postTag;
import static com.cw.restory.domain.tag.QTag.tag;
import static com.querydsl.jpa.JPAExpressions.select;

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
                .where(
                        findByCity(postGetRequest.city()),
                        findByType(postGetRequest.type()),
                        post.copyright.eq(true),
                        findByDescription(postGetRequest.description()),
                        findByTagId(postGetRequest.tagId()),
                        findByIsEditorPick(postGetRequest.isEditorPick())
                )
                .offset(postGetRequest.offset())
                .limit(postGetRequest.size())
                .orderBy(orderByDistance(postGetRequest.latitude(), postGetRequest.longitude()))
                .fetch();
                //todo 공통 키워드 검색 추가(제목, 서브타입 like) + orderby / if (파라미터 == distance) -> 거리순 정렬 기능 추가
    }

    private BooleanExpression findByIsEditorPick(Boolean isEditorPick) {
        return isEditorPick ? post.isEditorPick.eq(true) : null;
    }

    private BooleanExpression findByCity(String city) {
        return StringUtils.hasText(city) ? post.city.eq(City.valueOf(city)) : null;
    }

    private BooleanExpression findByType(String type) {
        return StringUtils.hasText(type) ? post.type.eq(Type.valueOf(type)) : null;
    }
    private BooleanExpression findByDescription(String description) {
        return StringUtils.hasText(description) ?
                post.title.contains(description)
                .or(post.address.contains(description))
                .or(post.id.in(
                        select(postTag.post.id)
                        .from(postTag).join(postTag.tag, tag)
                        .where(tag.name.contains(description))
                )) : null;
    }

    private BooleanExpression findByTagId(Long tagId) {
        return tagId != null ? post.id.in(
                select(postTag.post.id)
                        .from(postTag).join(postTag.tag, tag)
                        .where(tag.id.eq(tagId))
        ) : null;
    }

    // Haversine 공식을 사용하여 거리 계산 및 정렬
    private OrderSpecifier<Double> orderByDistance(Double latitude, Double longitude) {
        if (latitude != null && longitude != null) {
            return Expressions.numberTemplate(Double.class,
                    "6371 * acos(cos(radians({0})) * cos(radians({1})) * cos(radians({2}) - radians({3})) + sin(radians({0})) * sin(radians({1})))",
                    latitude, post.latitude, post.longitude, longitude).asc();
        }
        return null;
    }
}
