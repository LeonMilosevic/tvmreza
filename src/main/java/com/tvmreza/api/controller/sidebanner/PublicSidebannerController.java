package com.tvmreza.api.controller.sidebanner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvmreza.api.entities.Sidebanner;
import com.tvmreza.api.repositories.SidebannerRepository;

@RestController
@RequestMapping("/public/sidebanner")
public class PublicSidebannerController {

	@Autowired
	SidebannerRepository sidebannerRepository;

	@GetMapping
	@RequestMapping("/read/all/ordered")
	public List<Sidebanner> readAllFooterbanner() {
		return sidebannerRepository.findByOrderBySidebannerOrderAsc();
	}

}
