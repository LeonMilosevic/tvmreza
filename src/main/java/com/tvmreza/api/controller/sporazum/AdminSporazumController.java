package com.tvmreza.api.controller.sporazum;

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

import com.tvmreza.api.entities.Sporazum;
import com.tvmreza.api.repositories.SporazumRepository;

/**
 * Admin sporazum controller, used by admin to perform CRUD operations for the
 * Sporazum entity.
 * 
 * @see SporazumRepository
 * @author leon
 */
@RestController
@RequestMapping("/admin/sporazum")
public class AdminSporazumController {

	@Autowired
	SporazumRepository sporazumRepository;

	@PostMapping
	@RequestMapping("/create")
	public Sporazum createSporazum(@RequestBody Sporazum reqSporazum) throws Exception {
		if (reqSporazum.getHeader().isEmpty() || reqSporazum.getContent().isEmpty()
				|| reqSporazum.getVideoUrl().isEmpty() || reqSporazum.getLocation().isEmpty()) {
			throw new Exception();
		} else {
			return sporazumRepository.save(reqSporazum);
		}
	}

	@GetMapping
	@RequestMapping("/read/{id}")
	public Sporazum readSporazum(@PathVariable("id") Long id) {
		return sporazumRepository.findById(id).get();
	}

	@PutMapping
	@RequestMapping("/update/{id}")
	public Sporazum updateSporazum(@PathVariable("id") Long id, @RequestBody Sporazum reqSporazum) {
		Sporazum sporazumToUpdate = sporazumRepository.getOne(id);
		sporazumToUpdate.setContent(reqSporazum.getContent());
		sporazumToUpdate.setDateDisplay(reqSporazum.getDateDisplay());
		sporazumToUpdate.setHeader(reqSporazum.getHeader());
		sporazumToUpdate.setLocation(reqSporazum.getLocation());
		sporazumToUpdate.setVideoUrl(reqSporazum.getVideoUrl());
		return sporazumRepository.save(sporazumToUpdate);
	}

	@DeleteMapping
	@RequestMapping("/remove/{id}")
	public String removeSporazum(@PathVariable("id") Long id) {
		sporazumRepository.deleteById(id);
		return "Success";
	}

	@GetMapping
	@RequestMapping("/read/all/ordered")
	public List<Sporazum> readAllSporazum() {
		return sporazumRepository.findByOrderByDateDisplayDesc();
	}

}
