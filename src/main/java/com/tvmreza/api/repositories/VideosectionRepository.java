package com.tvmreza.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tvmreza.api.entities.Videosection;

public interface VideosectionRepository extends JpaRepository<Videosection, Long> {

	List<Videosection> findByOrderByDateDisplayDesc();

}
