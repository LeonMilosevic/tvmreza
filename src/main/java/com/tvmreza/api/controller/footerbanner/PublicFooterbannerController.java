package com.tvmreza.api.controller.footerbanner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvmreza.api.entities.Footerbanner;
import com.tvmreza.api.repositories.FooterbannerRepository;

@RestController
@RequestMapping("/public/footerbanner")
public class PublicFooterbannerController {

	@Autowired
	FooterbannerRepository footerbannerRepository;

	@GetMapping
	@RequestMapping("/read/all/ordered")
	public List<Footerbanner> readAllFooterbanner() {
		return footerbannerRepository.findByOrderByFooterbannerOrderAsc();
	}

}
