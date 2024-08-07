package com.mytv.api.news.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	Long id;
	
	@NotBlank(message = "Un titre est requise")
	@Column(nullable = false, columnDefinition = "TEXT")
	String title;
	
	@NotBlank(message = "Un cover est requise")
	@Column(nullable = false, columnDefinition = "TEXT")
	String cover;
	
	@NotBlank(message = "Un contenu est requise")
	@Column(nullable = false, columnDefinition = "TEXT")
	String content;
	
	Date publishDate;
	
	Date updateDate;
	
	Long idUser;
	
	List<Long> categories;
	
}
