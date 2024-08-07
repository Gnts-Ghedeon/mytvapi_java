package com.mytv.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytv.api.model.LikeLivetv;
import com.mytv.api.model.gestMedia.LiveTv;
import com.mytv.api.model.gestUser.User;

@Repository
public interface LikeLivetvRepository extends JpaRepository<LikeLivetv, Long>{
	
	Optional<LikeLivetv> findByUser(User u);
	List<LikeLivetv> findByLivetv(LiveTv l);
	Optional<LikeLivetv> findByUserAndLivetv(User u, LiveTv l);
}
