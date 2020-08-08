package com.tvmreza.api.controller.videosection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvmreza.api.entities.Videosection;
import com.tvmreza.api.repositories.VideosectionRepository;

@RestController
@RequestMapping("/public/video")
public class PublicVideosectionController {
	@Autowired
	VideosectionRepository videosectionRepository;

	@GetMapping
	@RequestMapping("/read/all/ordered")
	public List<Videosection> readAllOrderedVideosection() {
		return videosectionRepository.findByOrderByDateDisplayDesc();
	}
}
