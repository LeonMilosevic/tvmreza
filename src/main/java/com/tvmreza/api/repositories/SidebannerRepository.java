package com.tvmreza.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvmreza.api.entities.Sidebanner;

public interface SidebannerRepository extends JpaRepository<Sidebanner, Long> {

	List<Sidebanner> findByOrderBySidebannerOrderAsc();

}
