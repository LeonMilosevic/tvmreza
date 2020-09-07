package com.tvmreza.api.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tvmreza.api.entities.Sporazum;

public interface SporazumRepository extends JpaRepository<Sporazum, Long> {

	List<Sporazum> findByOrderByDateDisplayDesc(Pageable pageable);

	List<Sporazum> findByOrderByDateDisplayDesc();

}
