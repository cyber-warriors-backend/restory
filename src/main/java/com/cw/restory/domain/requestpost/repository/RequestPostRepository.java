package com.cw.restory.domain.requestpost.repository;

import com.cw.restory.domain.requestpost.entity.RequestPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestPostRepository extends JpaRepository<RequestPost, Long> {
}
