package com.mytv.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytv.api.model.gestMedia.LiveTv;

@Repository
public interface LiveTvRepository extends JpaRepository<LiveTv, Long>{

	LiveTv findByName(String nom);
	List<LiveTv> findByNameContaining(String val);
	Page<LiveTv> findByNameOrOverviewContaining(String n, String o, Pageable p);
	List<LiveTv> findByNameOrOverviewContaining(String val, String val2);
	

}
