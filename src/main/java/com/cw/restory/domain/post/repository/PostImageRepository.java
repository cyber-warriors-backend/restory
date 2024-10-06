package com.cw.restory.domain.post.repository;

import com.cw.restory.domain.post.entity.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostImageRepository extends JpaRepository<PostImage, Long>{
    Optional<PostImage> findByImageUrl(String imageUrl);
}
