package com.cw.restory.domain.tag;

import java.util.List;

public interface TagQRepository {
    List<Tag> findAllByRequestSize(Integer size);
}