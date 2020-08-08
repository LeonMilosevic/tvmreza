package com.tvmreza.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvmreza.api.entities.Navbarpage;

public interface NavbarpageRepository extends JpaRepository<Navbarpage, Long> {

	List<Navbarpage> findByOrderByNavbarOrderAsc();

}
