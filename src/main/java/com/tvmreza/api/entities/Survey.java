package com.tvmreza.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "survey")
public class Survey {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private boolean display;
	private String questionOne;
	private String questionTwo;
	private String questionThree;
	private String questionFour;
	private String questionFive;
	private Long questionOneCount;
	private Long questionTwoCount;
	private Long questionThreeCount;
	private Long questionFourCount;
	private Long questionFiveCount;

	public Survey() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public String getQuestionOne() {
		return questionOne;
	}

	public void setQuestionOne(String questionOne) {
		this.questionOne = questionOne;
	}

	public String getQuestionTwo() {
		return questionTwo;
	}

	public void setQuestionTwo(String questionTwo) {
		this.questionTwo = questionTwo;
	}

	public String getQuestionThree() {
		return questionThree;
	}

	public void setQuestionThree(String questionThree) {
		this.questionThree = questionThree;
	}

	public String getQuestionFour() {
		return questionFour;
	}

	public void setQuestionFour(String questionFour) {
		this.questionFour = questionFour;
	}

	public String getQuestionFive() {
		return questionFive;
	}

	public void setQuestionFive(String questionFive) {
		this.questionFive = questionFive;
	}

	public Long getQuestionOneCount() {
		return questionOneCount;
	}

	public void setQuestionOneCount(Long questionOneCount) {
		this.questionOneCount = questionOneCount;
	}

	public Long getQuestionTwoCount() {
		return questionTwoCount;
	}

	public void setQuestionTwoCount(Long questionTwoCount) {
		this.questionTwoCount = questionTwoCount;
	}

	public Long getQuestionThreeCount() {
		return questionThreeCount;
	}

	public void setQuestionThreeCount(Long questionThreeCount) {
		this.questionThreeCount = questionThreeCount;
	}

	public Long getQuestionFourCount() {
		return questionFourCount;
	}

	public void setQuestionFourCount(Long questionFourCount) {
		this.questionFourCount = questionFourCount;
	}

	public Long getQuestionFiveCount() {
		return questionFiveCount;
	}

	public void setQuestionFiveCount(Long questionFiveCount) {
		this.questionFiveCount = questionFiveCount;
	}

}
