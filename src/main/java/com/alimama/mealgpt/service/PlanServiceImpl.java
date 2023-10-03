package com.alimama.mealgpt.service;

import com.alimama.mealgpt.dao.GptPlanRepository;
import com.alimama.mealgpt.pojo.GptPlanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService{
    private final GptPlanRepository gptPlanRepository;

    @Autowired
    public PlanServiceImpl(GptPlanRepository gptPlanRepository) {
        this.gptPlanRepository = gptPlanRepository;
    }

    @Override
    public void savePlan(GptPlanEntity gptPlanEntity) {
        gptPlanRepository.save(gptPlanEntity);
    }
}
