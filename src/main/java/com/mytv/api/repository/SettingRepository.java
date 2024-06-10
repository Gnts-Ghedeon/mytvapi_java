package com.mytv.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mytv.api.model.util.Setting;

public interface SettingRepository extends JpaRepository<Setting, Long>{

}
