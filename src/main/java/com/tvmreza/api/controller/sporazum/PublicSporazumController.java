package com.tvmreza.api.controller.sporazum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvmreza.api.entities.Sporazum;
import com.tvmreza.api.repositories.SporazumRepository;

@RestController
@RequestMapping("/public/sporazum")
public class PublicSporazumController {

	@Autowired
	SporazumRepository sporazumRepository;

	@GetMapping
	@RequestMapping("/read/all/ordered")
	public List<Sporazum> readAllOrderedSporazum() {
		return sporazumRepository.findByOrderByDateDisplayDesc();
	}
}
