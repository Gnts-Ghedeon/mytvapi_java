package com.mytv.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytv.api.model.gestMedia.CategoryRL;

@Repository
public interface RadioCatRepository extends JpaRepository<CategoryRL, Long> {

	CategoryRL findByName(String name);

}
