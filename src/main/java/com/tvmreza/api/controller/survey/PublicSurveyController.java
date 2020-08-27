package com.tvmreza.api.controller.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvmreza.api.entities.Survey;
import com.tvmreza.api.repositories.SurveyRepository;

/**
 * Public survey controller, used by client, to read and update the Survey
 * entity. Methods explained further down the code.
 * 
 * @see SurveyRepository
 * @author leon
 *
 */
@RestController
@RequestMapping("/public/survey")
public class PublicSurveyController {

	@Autowired
	SurveyRepository surveyRepository;

	@GetMapping
	@RequestMapping("/read")
	/**
	 * Methods finds the only Survey entity that will have display field set to true
	 * boolean, since only one survey will be displayed at all the time.
	 * 
	 * @return boolean true.
	 */
	public Survey readSurveyByTrue() throws Exception {
		Survey survey = surveyRepository.findByDisplayTrue();
		if (survey == null) {
			throw new Exception();
		} else {
			return survey;
		}
	}

	@PutMapping
	@RequestMapping("/vote/{id}/{question}")
	/**
	 * Receives the current survey being displayed, receives the question that was
	 * chosen to submit, stores it in the database by incrementing the count of the
	 * specific question.
	 * 
	 * @param id       - id of the survey currently being desplayed.
	 * @param question - will be the question that was voted(chosen) by the client.
	 * @return updated survey entity.
	 */
	public Survey voteSurvey(@PathVariable("id") Long id, @PathVariable("question") String question) {
		Survey surveyFound = surveyRepository.findById(id).get();

		switch (question) { // takes the question param
		case "questionOne":
			Long currentCount = surveyFound.getAnswerOneCount(); // gets current count
			surveyFound.setAnswerOneCount(++currentCount); // updates current count
			break;
		case "questionTwo":
			Long currentCountTwo = surveyFound.getAnswerTwoCount();
			surveyFound.setAnswerTwoCount(++currentCountTwo);
			break;
		case "questionThree":
			Long currentCountThree = surveyFound.getAnswerThreeCount();
			surveyFound.setAnswerThreeCount(++currentCountThree);
			break;
		case "questionFour":
			Long currentCountFour = surveyFound.getAnswerFourCount();
			surveyFound.setAnswerFourCount(++currentCountFour);
			break;
		case "questionFive":
			Long currentCountFive = surveyFound.getAnswerFiveCount();
			surveyFound.setAnswerFiveCount(++currentCountFive);
			break;
		}

		return surveyRepository.save(surveyFound);

	}
}
