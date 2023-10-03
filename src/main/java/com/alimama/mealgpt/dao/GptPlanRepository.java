package com.alimama.mealgpt.dao;

import com.alimama.mealgpt.pojo.GptPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GptPlanRepository extends JpaRepository<GptPlanEntity, Integer> {
}
