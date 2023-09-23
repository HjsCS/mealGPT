package com.alimama.mealgpt.service;

import com.alimama.mealgpt.entity.FitnessInfo;
import com.alimama.mealgpt.pojo.FitnessInfoUpdateRequest;
import com.alimama.mealgpt.pojo.FitnessInfoUpdateResponse;

public interface FitnessService {
    void save(FitnessInfo fitnessInfo);

    FitnessInfoUpdateResponse update(FitnessInfoUpdateRequest fitnessInfoUpdateRequest);
}
