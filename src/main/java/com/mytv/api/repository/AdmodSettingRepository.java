package com.mytv.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytv.api.model.util.AdmodSetting;

@Repository
public interface AdmodSettingRepository extends JpaRepository<AdmodSetting, Long> {

}
