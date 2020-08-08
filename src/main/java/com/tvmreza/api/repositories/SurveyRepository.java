package com.tvmreza.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvmreza.api.entities.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

	List<Survey> findByOrderByDateCreatedDesc();

	Survey findByDisplayTrue();

}
