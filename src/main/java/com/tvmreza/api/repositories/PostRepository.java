package com.tvmreza.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvmreza.api.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
