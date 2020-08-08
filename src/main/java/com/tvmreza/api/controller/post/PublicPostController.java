package com.tvmreza.api.controller.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvmreza.api.controller.post.dto.PostDtoRequest;
import com.tvmreza.api.entities.Post;
import com.tvmreza.api.services.post.PublicPostService;

/**
 * Clients will be able to create posts. 
 * 
 * @see PublicPostService, PostDtoRequest
 * @author leon
 *
 */
@RestController
@RequestMapping("/public/post")
public class PublicPostController {

	@Autowired
	PublicPostService postService;

	@PostMapping
	@RequestMapping("/create")
	public Post createPost(@RequestBody PostDtoRequest postDtoRequest) {
		return postService.createPost(postDtoRequest);
	}

}
