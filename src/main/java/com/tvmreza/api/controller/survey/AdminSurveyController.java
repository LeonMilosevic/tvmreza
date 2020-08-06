package com.tvmreza.api.controller.survey;

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

import com.tvmreza.api.entities.Survey;
import com.tvmreza.api.repositories.SurveyRepository;

@RestController
@RequestMapping("/admin/survey")
public class AdminSurveyController {

	@Autowired
	SurveyRepository surveyRepository;

	@PostMapping
	@RequestMapping("/create")
	public Survey createSurvey(@RequestBody Survey reqSurvey) {
		return surveyRepository.save(reqSurvey);
	}

	@GetMapping
	@RequestMapping("/read/{id}")
	public Survey readSurvey(@PathVariable("id") Long id) {
		return surveyRepository.findById(id).get();
	}

	@PutMapping
	@RequestMapping("/update/{id}")
	public Survey updateSurvey(@PathVariable("id") Long id, @RequestBody Survey reqSurvey) {
		Survey surveyToUpdate = surveyRepository.getOne(id);
		surveyToUpdate.setDisplay(reqSurvey.isDisplay());
		surveyToUpdate.setQuestionOne(reqSurvey.getQuestionOne());
		surveyToUpdate.setQuestionTwo(reqSurvey.getQuestionTwo());
		surveyToUpdate.setQuestionThree(reqSurvey.getQuestionThree());
		surveyToUpdate.setQuestionFour(reqSurvey.getQuestionFour());
		surveyToUpdate.setQuestionFive(reqSurvey.getQuestionFive());
		return surveyRepository.save(surveyToUpdate);
	}

	@DeleteMapping
	@RequestMapping("/remove/{id}")
	public String removeSurvey(@PathVariable("id") Long id) {
		surveyRepository.deleteById(id);
		return "Success";
	}

	@GetMapping
	@RequestMapping("/read/all")
	public List<Survey> readAllSurvey() {
		return surveyRepository.findAll();
	}
}
