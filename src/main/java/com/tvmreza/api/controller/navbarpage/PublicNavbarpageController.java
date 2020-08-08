package com.tvmreza.api.controller.navbarpage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvmreza.api.entities.Navbarpage;
import com.tvmreza.api.repositories.NavbarpageRepository;

@RestController
@RequestMapping("/public/navbarpage")
public class PublicNavbarpageController {

	@Autowired
	NavbarpageRepository navbarpageRepository;

	@GetMapping
	@RequestMapping("/read/all/ordered")
	public List<Navbarpage> readAllNavbarpageOrdered() {
		return navbarpageRepository.findByOrderByNavbarOrderAsc();
	}

	@GetMapping
	@RequestMapping("/read/{id}")
	public Navbarpage readNavbarpage(@PathVariable("id") Long id) {
		return navbarpageRepository.findById(id).get();
	}
}
