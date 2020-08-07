package com.tvmreza.api.controller.footerbanner;

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

import com.tvmreza.api.entities.Footerbanner;
import com.tvmreza.api.repositories.FooterbannerRepository;

@RestController
@RequestMapping("/admin/footerbanner")
public class AdminFooterbannerController {

	@Autowired
	FooterbannerRepository footerbannerRepository;

	@PostMapping
	@RequestMapping("/create")
	public Footerbanner createFooterbanner(@RequestBody Footerbanner reqBanner) throws Exception {
		if (reqBanner.getImageUrl().equals("") || reqBanner.getLinkToUrl().equals("")
				|| reqBanner.getFooterbannerOrder() == 0) {
			throw new Exception();
		} else {
			return footerbannerRepository.save(reqBanner);
		}
	}

	@GetMapping
	@RequestMapping("/read/{id}")
	public Footerbanner readFooterbanner(@PathVariable("id") Long id) throws Exception {
		return footerbannerRepository.findById(id).get();
	}

	@PutMapping
	@RequestMapping("/update/{id}")
	public Footerbanner updateFooterbanner(@PathVariable("id") Long id, @RequestBody Footerbanner reqBanner)
			throws Exception {
		Footerbanner footerBannerToUpdate = footerbannerRepository.getOne(id);
		footerBannerToUpdate.setFooterbannerOrder(reqBanner.getFooterbannerOrder());
		footerBannerToUpdate.setImageUrl(reqBanner.getImageUrl());
		footerBannerToUpdate.setLinkToUrl(reqBanner.getLinkToUrl());

		return footerbannerRepository.save(footerBannerToUpdate);
	}

	@DeleteMapping
	@RequestMapping("/remove/{id}")
	public String removeFooterbanner(@PathVariable("id") Long id) {
		footerbannerRepository.deleteById(id);
		return "Success";
	}

	@GetMapping
	@RequestMapping("/read/all/ordered")
	public List<Footerbanner> readAllFooterbanner() {
		return footerbannerRepository.findByOrderByFooterbannerOrderAsc();
	}

}
