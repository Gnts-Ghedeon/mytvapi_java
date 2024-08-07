package com.mytv.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytv.api.model.gestMedia.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {

	Serie findByName(String name);
	List<Serie> findByNameContaining(String nom);
	Page<Serie> findByNameContainingOrOverviewContaining(String nom, String desc, Pageable p);
	List<Serie> findByNameContainingOrOverviewContaining(String n, String n2);
	List<Serie> findByTop10True();
	List<Serie> findByTopTrue();

}
