package com.tvmreza.api.controller.tvface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvmreza.api.entities.TvFace;
import com.tvmreza.api.repositories.TvFaceRepository;

@RestController
@RequestMapping("/public/tvface")
public class PublicTvFaceController {

	@Autowired
	TvFaceRepository tvfaceRepository;

	@GetMapping
	@RequestMapping("/read/{id}")
	public TvFace readTvFace(@PathVariable("id") Long id) {
		return tvfaceRepository.findById(id).get();
	}

	@GetMapping
	@RequestMapping("/read/all")
	public List<TvFace> readTvFaceAll() {
		return tvfaceRepository.findAll();
	}
}
