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
	@RequestMapping("/vote/{id}/{answer}")
	/**
	 * Receives the current survey being displayed, receives the question that was
	 * chosen to submit, stores it in the database by incrementing the count of the
	 * specific question.
	 * 
	 * @param id       - id of the survey currently being displayed.
	 * @param question - will be the question that was voted(chosen) by the client.
	 * @return updated survey entity.
	 */
	public Survey voteSurvey(@PathVariable("id") Long id, @PathVariable("answer") String answer) throws Exception {
		Survey surveyFound = surveyRepository.findById(id).get();

		System.out.println(answer);

		switch (answer) { // takes the answer param
		case "answerOne":
			Long currentCount = surveyFound.getAnswerOneCount(); // gets current count
			if (currentCount == null) {
				currentCount = (long) 0;
			}
			surveyFound.setAnswerOneCount(++currentCount); // updates current count
			break;
		case "answerTwo":
			Long currentCountTwo = surveyFound.getAnswerTwoCount();
			if (currentCountTwo == null) {
				currentCountTwo = (long) 0;
			}
			surveyFound.setAnswerTwoCount(++currentCountTwo);
			break;
		case "answerThree":
			Long currentCountThree = surveyFound.getAnswerThreeCount();
			if (currentCountThree == null) {
				currentCountThree = (long) 0;
			}
			surveyFound.setAnswerThreeCount(++currentCountThree);
			break;
		case "answerFour":
			Long currentCountFour = surveyFound.getAnswerFourCount();
			if (currentCountFour == null) {
				currentCountFour = (long) 0;
			}
			surveyFound.setAnswerFourCount(++currentCountFour);
			break;
		case "answerFive":
			Long currentCountFive = surveyFound.getAnswerFiveCount();
			if (currentCountFive == null) {
				currentCountFive = (long) 0;
			}
			surveyFound.setAnswerFiveCount(++currentCountFive);
			break;
		default:
			throw new Exception();
		}

		return surveyRepository.save(surveyFound);

	}
}
