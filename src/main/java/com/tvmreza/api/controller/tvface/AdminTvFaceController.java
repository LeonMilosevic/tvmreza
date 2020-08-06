package com.tvmreza.api.controller.tvface;

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

import com.tvmreza.api.entities.TvFace;
import com.tvmreza.api.repositories.TvFaceRepository;

@RestController
@RequestMapping("/admin/tvface")
public class AdminTvFaceController {
	@Autowired
	TvFaceRepository tvfaceRepository;

	@PostMapping
	@RequestMapping("/create")
	public TvFace createTvFace(@RequestBody TvFace reqTvFace) throws Exception {
		if (reqTvFace.getFirstName().isEmpty() || reqTvFace.getLastName().isEmpty() || reqTvFace.getImageUrl().isEmpty()
				|| reqTvFace.getWorkPosition().isEmpty() || reqTvFace.getCareer().isEmpty()
				|| reqTvFace.getEducation().isEmpty()) {
			throw new Exception();
		} else {
			return tvfaceRepository.save(reqTvFace);
		}

	}

	@GetMapping
	@RequestMapping("/read/{id}")
	public TvFace readTvFace(@PathVariable("id") Long id) {
		return tvfaceRepository.findById(id).get();
	}

	@PutMapping
	@RequestMapping("/update/{id}")
	public TvFace updateTvFace(@PathVariable("id") Long id, @RequestBody TvFace reqTvFace) {
		TvFace tvFaceToUpdate = tvfaceRepository.getOne(id);

		tvFaceToUpdate.setFirstName(reqTvFace.getFirstName());
		tvFaceToUpdate.setLastName(reqTvFace.getLastName());
		tvFaceToUpdate.setImageUrl(reqTvFace.getImageUrl());
		tvFaceToUpdate.setWorkPosition(reqTvFace.getWorkPosition());
		tvFaceToUpdate.setCareer(reqTvFace.getCareer());
		tvFaceToUpdate.setEducation(reqTvFace.getEducation());
		tvFaceToUpdate.setTvprogram(reqTvFace.getTvprogram());
		tvFaceToUpdate.setProfessionalChallenges(reqTvFace.getProfessionalChallenges());
		tvFaceToUpdate.setContact(reqTvFace.getContact());

		return tvfaceRepository.save(tvFaceToUpdate);
	}

	@DeleteMapping
	@RequestMapping("/remove/{id}")
	public String removeTvFace(@PathVariable("id") Long id) {
		tvfaceRepository.deleteById(id);
		return "Success";
	}

	@GetMapping
	@RequestMapping("/read/all")
	public List<TvFace> readTvFaceAll() {
		return tvfaceRepository.findAll();
	}
}
