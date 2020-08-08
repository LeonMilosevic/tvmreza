package com.tvmreza.api.controller.videosection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvmreza.api.entities.Videosection;
import com.tvmreza.api.repositories.VideosectionRepository;

@RestController
@RequestMapping("/admin/video")
public class AdminVideosectionController {

	@Autowired
	VideosectionRepository videosectionRepository;

	@PostMapping
	@RequestMapping("/create")
	public Videosection createVideosection(@RequestBody Videosection reqVideosection) throws Exception {
		if (reqVideosection.getHeader().isEmpty() || reqVideosection.getContent().isEmpty()
				|| reqVideosection.getVideoUrl().isEmpty() || reqVideosection.getLocation().isEmpty()) {
			throw new Exception();
		} else {
			return videosectionRepository.save(reqVideosection);
		}
	}

	@GetMapping
	@RequestMapping("/read/{id}")
	public Videosection readVideosection(@PathVariable("id") Long id) {
		return videosectionRepository.findById(id).get();
	}

	@PutMapping
	@RequestMapping("/update/{id}")
	public Videosection updateVideosection(@PathVariable("id") Long id, @RequestBody Videosection reqVideosection) {
		Videosection videosectionToUpdate = videosectionRepository.getOne(id);
		videosectionToUpdate.setContent(reqVideosection.getContent());
		videosectionToUpdate.setDateDisplay(reqVideosection.getDateDisplay());
		videosectionToUpdate.setHeader(reqVideosection.getHeader());
		videosectionToUpdate.setLocation(reqVideosection.getLocation());
		videosectionToUpdate.setVideoUrl(reqVideosection.getVideoUrl());
		return videosectionRepository.save(videosectionToUpdate);
	}

	@DeleteMapping
	@RequestMapping("/remove/{id}")
	public String removeVideosection(@PathVariable("id") Long id) {
		videosectionRepository.deleteById(id);
		return "Success";
	}

	@GetMapping
	@RequestMapping("/read/all/ordered")
	public List<Videosection> readAllOrderedVideosection() {
		return videosectionRepository.findByOrderByDateDisplayDesc();
	}

}
