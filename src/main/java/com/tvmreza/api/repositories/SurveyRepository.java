package com.tvmreza.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvmreza.api.entities.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

}
