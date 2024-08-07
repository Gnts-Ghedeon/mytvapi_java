package com.mytv.api.service.gestMedia;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mytv.api.model.gestMedia.Saison;
import com.mytv.api.model.gestMedia.Serie;
import com.mytv.api.repository.SeasonRepository;

@Service
public class SaisonService{

	@Autowired
	private SeasonRepository seasRep;

	public Saison create(Saison u) {
		
		
		//u.setSerieRef(u.getIdSerie().getIdSerie());
		
		return seasRep.save(u);
		
	}

	public List<Saison> show() {
		return seasRep.findAll();
	}
	
	public Page<Saison> showPage(Pageable p) {
		return seasRep.findAll(p);
	}
	
	public Page<Saison> showByLangue(Long id, Pageable p){
		
		PageImpl<Saison> res = new PageImpl<Saison>(seasRep.findAll().stream()
				   .filter(f -> f.getLangue().contains(id)).toList() 
				   , p
				   
				   ,seasRep.findAll().size());
			
			return res;
	};
	
	public Page<Saison> showBySerie(Serie serie, Pageable p) {
		return seasRep.findByIdSerie(serie, p);
	}
	
	public Page<Saison> showByidSerie(Long idSerie, Pageable p) {
		return seasRep.findBySerieRef(idSerie, p);
	}
	
	
	public Page<Saison> showByLangueAndSerie(Long langue, Long serie, Pageable p){
		
		PageImpl<Saison> res = new PageImpl<Saison>(seasRep.findAll().stream()
				   .filter(f -> f.getLangue().contains(langue))
				   .filter(f -> f.getSerieRef() == serie)
				   .toList() 
				   , p
				   
				   ,seasRep.findAll().size());
			
			return res;
	};
	
	public Page<Saison> search(String n, Pageable p) {
		return seasRep.findByNameContainingOrOverviewContaining(n, n, p);
	}
	
	public Page<Saison> searchByLangue(String n, Long langue, Pageable p) {
		
		PageImpl<Saison> res = new PageImpl<Saison>(seasRep.findByNameContainingOrOverviewContaining(n, n, p).stream()
                .filter(f -> f.getLangue().contains(langue))
                .collect(Collectors.toList()) 
				   , p
				   ,seasRep.findAll().size());
			
			return res;
	}
	
	public Page<Saison> searchBySerie(String n, Long serie, Pageable p) {
		
		PageImpl<Saison> res = new PageImpl<Saison>(seasRep.findByNameContainingOrOverviewContaining(n, n, p).stream()
                .filter(f -> f.getSerieRef() == serie)
                .collect(Collectors.toList()) 
				   , p
				   ,seasRep.findAll().size());
			
			return res;
	}
	
	public Page<Saison> searchByLangueAndSerie(String val, Long langue, Long serie, Pageable p){
		
		PageImpl<Saison> res = new PageImpl<Saison>(seasRep.findByNameContainingOrOverviewContaining(val, val, p).stream()
				   .filter(f -> f.getLangue().contains(langue))
				   .filter(f -> f.getSerieRef() == serie)
				   .toList() 
				   , p
				   
				   ,seasRep.findAll().size());
			
			return res;
	};

	public Saison showById(Long id) {
		
		return seasRep.findById(id).get();
	}

	public Saison update(Long id, Saison p) {

		p.setIdSaison(id);
	   // p.setSerieRef(p.getIdSerie().getIdSerie());
		return seasRep.save(p);
		
	}

	public Boolean delete(Long id) {
		seasRep.deleteById(id);
		return null;
	}

	public Saison findByName(String name) {

		return seasRep.findByName(name);
	}

}
