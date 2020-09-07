package com.tvmreza.api.controller.videosection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<Videosection> readAllPageableOrderVideosection(
			@RequestParam(name = "pageNumber", defaultValue = "0") final int pageNumber,
			@RequestParam(name = "pageSize", defaultValue = "5") final int pageSize) throws Exception {
		try {
			Pageable pageable = PageRequest.of(pageNumber, pageSize);
			List<Videosection> videos = videosectionRepository.findByOrderByDateDisplayDesc(pageable);
			return videos;
		} catch (Exception e) {
			throw new Exception();
		}
	}

}
