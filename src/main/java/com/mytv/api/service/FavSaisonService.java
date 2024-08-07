package com.mytv.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mytv.api.model.FavSaison;
import com.mytv.api.model.gestMedia.Saison;
import com.mytv.api.model.gestUser.User;
import com.mytv.api.repository.FavSaisonRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FavSaisonService {

	@Autowired
	FavSaisonRepository favSaisonRep;
	
	public FavSaison addFav(FavSaison ls) {
		
		return favSaisonRep.save(ls);
	}
	
	public List<FavSaison> show(){
		
		return favSaisonRep.findAll();
	}
	
	public Page<FavSaison> showPage(Pageable p){
		
		return favSaisonRep.findAll(p);
	}
	
	public List<FavSaison> findByUser(User u) {
		
		return favSaisonRep.findByUser(u);
	}
	
	public List<FavSaison> findBySaison(Saison s) {
		
		return favSaisonRep.findBySaison(s);
	}
	
	public Long nbretotalLike(Saison s) {
		
		return (long) favSaisonRep.findBySaison(s).size();
	}
	
	
	public boolean remove(Long id) {
		
		favSaisonRep.deleteById(id);
		 
		return true;
		
	}
}
