package com.tvmreza.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvmreza.api.entities.Footerbanner;

public interface FooterbannerRepository extends JpaRepository<Footerbanner, Long> {

	List<Footerbanner> findByOrderByFooterbannerOrderAsc();

}
