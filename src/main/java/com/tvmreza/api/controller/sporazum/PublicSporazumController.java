package com.tvmreza.api.controller.sporazum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<Sporazum> readAllOrderedSporazum(
			@RequestParam(name = "pageNumber", defaultValue = "0") final int pageNumber,
			@RequestParam(name = "pageSize", defaultValue = "5") final int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return sporazumRepository.findByOrderByDateDisplayDesc(pageable);
	}
}
