package com.alimama.mealgpt.service;

import com.alimama.mealgpt.dao.FitnessInfoRepository;
import com.alimama.mealgpt.entity.FitnessInfo;
import com.alimama.mealgpt.pojo.FitnessInfoUpdateRequest;
import com.alimama.mealgpt.pojo.FitnessInfoUpdateResponse;
import com.alimama.mealgpt.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnessServiceImpl implements FitnessService {

    private FitnessInfoRepository fitnessInfoRepository;
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public FitnessServiceImpl(FitnessInfoRepository fitnessInfoRepository, JwtTokenProvider jwtTokenProvider) {
        this.fitnessInfoRepository = fitnessInfoRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public FitnessInfoUpdateResponse update(FitnessInfoUpdateRequest fitnessInfoUpdateRequest) {
        FitnessInfoUpdateResponse fitnessInfoUpdateResponse = new FitnessInfoUpdateResponse();

        if (fitnessInfoUpdateRequest != null) {
            String jwtToken = fitnessInfoUpdateRequest.getJwtToken();
            FitnessInfo fitnessInfo = fitnessInfoUpdateRequest.getFitnessInfo();
            if (jwtTokenProvider.getUserNameFromJwt(jwtToken).equals(fitnessInfo.getUserName())) {
                save(fitnessInfo);
                fitnessInfoUpdateResponse.setMsg("Successfully update your fitness Info " + fitnessInfo.getUserName());

            } else {
                fitnessInfoUpdateResponse.setMsg("Failed to update your fitness Info");
            }


        }
        return fitnessInfoUpdateResponse;
    }

    public void save(FitnessInfo fitnessInfo) {

        fitnessInfoRepository.save(fitnessInfo);
    }

    @Override
    public List<FitnessInfo> getFitnessInfoByUserName(String username) {
        return fitnessInfoRepository.findTop5ByUserNameOrderByIdDesc(username);
    }
}
