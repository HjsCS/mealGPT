package com.alimama.mealgpt.service;

import com.alimama.mealgpt.entity.FitnessInfo;
import com.alimama.mealgpt.pojo.FitnessInfoUpdateRequest;
import com.alimama.mealgpt.pojo.FitnessInfoUpdateResponse;

import java.util.List;

public interface FitnessService {
    void save(FitnessInfo fitnessInfo);

    FitnessInfoUpdateResponse update(FitnessInfoUpdateRequest fitnessInfoUpdateRequest);

    List<FitnessInfo> getFitnessInfoByUserName(String userName);
}
