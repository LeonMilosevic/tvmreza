package com.tvmreza.api.entities;

import java.sql.Timestamp;

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
	private String question;
	private String answerOne;
	private String answerTwo;
	private String answerThree;
	private String answerFour;
	private String answerFive;
	private Long answerOneCount;
	private Long answerTwoCount;
	private Long answerThreeCount;
	private Long answerFourCount;
	private Long answerFiveCount;
	private Timestamp dateCreated;

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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswerOne() {
		return answerOne;
	}

	public void setAnswerOne(String answerOne) {
		this.answerOne = answerOne;
	}

	public String getAnswerTwo() {
		return answerTwo;
	}

	public void setAnswerTwo(String answerTwo) {
		this.answerTwo = answerTwo;
	}

	public String getAnswerThree() {
		return answerThree;
	}

	public void setAnswerThree(String answerThree) {
		this.answerThree = answerThree;
	}

	public String getAnswerFour() {
		return answerFour;
	}

	public void setAnswerFour(String answerFour) {
		this.answerFour = answerFour;
	}

	public String getAnswerFive() {
		return answerFive;
	}

	public void setAnswerFive(String answerFive) {
		this.answerFive = answerFive;
	}

	public Long getAnswerOneCount() {
		return answerOneCount;
	}

	public void setAnswerOneCount(Long answerOneCount) {
		this.answerOneCount = answerOneCount;
	}

	public Long getAnswerTwoCount() {
		return answerTwoCount;
	}

	public void setAnswerTwoCount(Long answerTwoCount) {
		this.answerTwoCount = answerTwoCount;
	}

	public Long getAnswerThreeCount() {
		return answerThreeCount;
	}

	public void setAnswerThreeCount(Long answerThreeCount) {
		this.answerThreeCount = answerThreeCount;
	}

	public Long getAnswerFourCount() {
		return answerFourCount;
	}

	public void setAnswerFourCount(Long answerFourCount) {
		this.answerFourCount = answerFourCount;
	}

	public Long getAnswerFiveCount() {
		return answerFiveCount;
	}

	public void setAnswerFiveCount(Long answerFiveCount) {
		this.answerFiveCount = answerFiveCount;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

}
