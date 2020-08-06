package com.tvmreza.api.controller.navbarpage;

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

import com.tvmreza.api.entities.Navbarpage;
import com.tvmreza.api.repositories.NavbarpageRepository;

@RestController
@RequestMapping("/admin/navbarpage")
public class AdminNavbarpageController {

	@Autowired
	NavbarpageRepository navbarpageRepository;

	@PostMapping
	@RequestMapping("/create")
	public Navbarpage createNavbarpage(@RequestBody Navbarpage reqNavbarpage) throws Exception {
		if (reqNavbarpage.getHeader().isEmpty() || reqNavbarpage.getContent().isEmpty()
				|| reqNavbarpage.getNavbarName().isEmpty() || reqNavbarpage.getNavbarOrder() == 0) {
			throw new Exception();
		} else {
			return navbarpageRepository.save(reqNavbarpage);
		}
	}

	@GetMapping
	@RequestMapping("/read/{id}")
	public Navbarpage readNavbarpage(@PathVariable("id") Long id) {
		return navbarpageRepository.findById(id).get();
	}

	@PutMapping
	@RequestMapping("/update/{id}")
	public Navbarpage updateNavbarpage(@PathVariable("id") Long id, @RequestBody Navbarpage reqNavbarpage) {
		Navbarpage navbarpageToUpdate = navbarpageRepository.getOne(id);
		navbarpageToUpdate.setNavbarName(reqNavbarpage.getNavbarName());
		navbarpageToUpdate.setHeader(reqNavbarpage.getHeader());
		navbarpageToUpdate.setContent(reqNavbarpage.getContent());
		navbarpageToUpdate.setImagesUrl(reqNavbarpage.getImagesUrl());
		navbarpageToUpdate.setNavbarOrder(reqNavbarpage.getNavbarOrder());
		navbarpageToUpdate.setVideoUrl(reqNavbarpage.getVideoUrl());
		return navbarpageRepository.save(navbarpageToUpdate);
	}

	@DeleteMapping
	@RequestMapping("/remove/{id}")
	public String removeNavbarpage(@PathVariable("id") Long id) {
		navbarpageRepository.deleteById(id);
		return "Success";
	}

	@GetMapping
	@RequestMapping("/read/all")
	public List<Navbarpage> readAllNavbarpage() {
		return navbarpageRepository.findAll();
	}

}
