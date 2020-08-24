package com.tvmreza.api.controller.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvmreza.api.entities.Post;
import com.tvmreza.api.repositories.PostRepository;

/**
 * Admin post controller, admin will be able to remove and retrieve list of all
 * posts sorted by most recent.
 * 
 * @see PostRepository, Post
 * @author leon
 */
@RestController
@RequestMapping("/admin/post")
public class AdminPostController {

	@Autowired
	PostRepository postRepository;

	@DeleteMapping
	@RequestMapping("/remove/{id}")
	public String removeArticle(@PathVariable("id") Long id) {
		postRepository.deleteById(id);
		return "Success";
	}

	@GetMapping
	@RequestMapping("/read/all/ordered")
	public List<Post> readAllPosts() {
		return postRepository.findByOrderByDateCreatedDesc();
	}
}
