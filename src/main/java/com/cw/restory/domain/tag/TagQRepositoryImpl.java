package com.cw.restory.domain.tag;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.cw.restory.domain.tag.QTag.tag;

@RequiredArgsConstructor
public class TagQRepositoryImpl implements TagQRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Tag> findAllByRequestSize(Integer size) {
        return jpaQueryFactory
                .selectFrom(tag)
                .offset(0)
                .limit(size)
                .orderBy(tag.searchCnt.desc(), tag.id.asc())
                .fetch();
    }

}
