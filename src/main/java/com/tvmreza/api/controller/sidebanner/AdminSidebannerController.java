package com.tvmreza.api.controller.sidebanner;

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

import com.tvmreza.api.entities.Sidebanner;
import com.tvmreza.api.repositories.SidebannerRepository;

/**
 * Admin sidebanner controller, used for admin to perform CRUD operations for
 * the side banner on the front-end.
 * 
 * @author leon
 */
@RestController
@RequestMapping("/admin/sidebanner")
public class AdminSidebannerController {

	@Autowired
	SidebannerRepository sidebannerRepository;

	@PostMapping
	@RequestMapping("/create")
	public Sidebanner createSidebanner(@RequestBody Sidebanner reqBanner) throws Exception {
		if (reqBanner.getImageUrl().equals("") || reqBanner.getLinkToUrl().equals("")
				|| reqBanner.getSidebannerOrder() == 0) {
			throw new Exception();
		} else {
			return sidebannerRepository.save(reqBanner);
		}
	}

	@GetMapping
	@RequestMapping("/read/{id}")
	public Sidebanner readSidebanner(@PathVariable("id") Long id) throws Exception {
		return sidebannerRepository.findById(id).get();
	}

	@PutMapping
	@RequestMapping("/update/{id}")
	public Sidebanner updateSidebanner(@PathVariable("id") Long id, @RequestBody Sidebanner reqBanner)
			throws Exception {
		Sidebanner sidebannerToUpdate = sidebannerRepository.getOne(id);
		sidebannerToUpdate.setSidebannerOrder(reqBanner.getSidebannerOrder());
		sidebannerToUpdate.setImageUrl(reqBanner.getImageUrl());
		sidebannerToUpdate.setLinkToUrl(reqBanner.getLinkToUrl());

		return sidebannerRepository.save(sidebannerToUpdate);
	}

	@DeleteMapping
	@RequestMapping("/remove/{id}")
	public String removeBanner(@PathVariable("id") Long id) {
		sidebannerRepository.deleteById(id);
		return "Success";
	}

	@GetMapping
	@RequestMapping("/read/all")
	public List<Sidebanner> readAllSidebanner() {
		return sidebannerRepository.findAll();
	}

}
