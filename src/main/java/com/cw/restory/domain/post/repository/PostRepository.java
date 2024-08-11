package com.cw.restory.domain.post.repository;

import com.cw.restory.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> , PostQRepository{
}
